package rest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import rest.controller.GreetingController;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static rest.controller.GreetingController.DEFAULT;
import static rest.controller.GreetingController.TEMPLATE;

@RunWith(SpringRunner.class)
@WebMvcTest(GreetingController.class)
public class GreetingControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void requestWithoutParameterShouldReturnDefaultValue() throws Exception {
        checkGetResponse("/greeting", DEFAULT);
    }

    @Test
    public void requestWithParameterShouldReturnPersonalisedResponse() throws Exception {
        checkGetResponse("/greeting?name=Bob", "Bob");
    }

    @Test
    public void requestWithEmptyParameterShouldReturnDefaultValue() throws Exception {
        checkGetResponse("/greeting?name=", DEFAULT);
    }

    @Test
    public void requestWithWrongParameterShouldReturnDefaultValue() throws Exception {
        checkGetResponse("/greeting?user=Bob", DEFAULT);
    }

    private void checkGetResponse(String query, String expectedName) throws Exception {
        String expectedContent = String.format(TEMPLATE, expectedName);
        mvc.perform(MockMvcRequestBuilders.get(query).accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo(String.format("{\"content\":\"%s\"}", expectedContent))));
    }

    @Test
    public void postRequestWithEmptyPayloadShouldReturnClientError() throws Exception {
        checkPostRequest("", 400, "");
    }

    @Test
    public void postRequestWithWrongPayloadShouldReturnClientError() throws Exception {
        checkPostRequest("wrongPayload", 400, "");
    }

    @Test
    public void postRequestWithPayloadShouldReturnPersonalisedResponse() throws Exception {
        String testName = "Bob";
        String contentSent = String.format("{\"name\":\"%s\"}", testName);

        String expectedContent = String.format(TEMPLATE, testName);
        String expectedResponse = String.format("{\"content\":\"%s\"}", expectedContent);

        checkPostRequest(contentSent, 200, expectedResponse);
    }

    private void checkPostRequest(String contentSent, int expectedHttpStatus, String expectedResponse) throws Exception {
        mvc.perform(MockMvcRequestBuilders.post("/greeting")
                .contentType(MediaType.APPLICATION_JSON)
                .content(contentSent)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().is(expectedHttpStatus))
                .andExpect(content().string(equalTo(expectedResponse)));
    }
}
