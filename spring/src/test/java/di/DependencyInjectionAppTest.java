package di;

import di.beans.AnnotatedController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DependencyInjectionAppTest {

    @Autowired
    private ApplicationContext context;

    @Test
    public void componentsShouldBeAvailableInContext() {
        assertThat(context.containsBean("annotatedController")).isTrue();
        assertThat(context.containsBean("annotatedService")).isTrue();
        assertThat(context.containsBean("annotatedDao")).isTrue();
    }

    @Test
    public void beanFromConfigAreNotBeAvailableInContext() {
        assertThat(context.containsBean("beanFromConfig")).isFalse();
        assertThat(context.containsBean("abstractBean")).isFalse();
    }

    @Test
    public void serviceAndDaoShouldBeInjectedInController() {
        AnnotatedController controller = (AnnotatedController) context.getBean("annotatedController");
        assertThat(controller.getValueFromService()).isEqualTo("Value from Dao");
    }

    @Test
    public void beanFromConfigurationShouldBeInjectedInController() {
        AnnotatedController controller = (AnnotatedController) context.getBean("annotatedController");
        assertThat(controller.getValueFromBean()).isEqualTo("Bean with AbstractBeanImpl");
    }
}
