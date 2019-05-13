package rest.controller;

import org.springframework.web.bind.annotation.*;
import rest.dto.PersonDTO;
import rest.model.Greeting;

/**
 * Example of a REST controller.
 * <p>
 * Most of the code has been taken from an official Spring guide:
 * https://spring.io/guides/gs/rest-service
 */
@RestController
public class GreetingController {

    public static final String TEMPLATE = "Hello, %s!";
    public static final String DEFAULT = "World";

    @GetMapping("/greeting")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = DEFAULT) String name) {
        return new Greeting(String.format(TEMPLATE, name));
    }

    @PostMapping("/greeting")
    public Greeting greeting(@RequestBody PersonDTO person) {
        return new Greeting(String.format(TEMPLATE, person.getName()));
    }
}
