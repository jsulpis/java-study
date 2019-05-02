package di;

import di.beans.AbstractBean;
import di.beans.AbstractBeanImpl;
import di.beans.BeanForConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigurationClass {

    @Bean
    BeanForConfig provideBean() {
        return new BeanForConfig(provideDependency());
    }

    @Bean
    AbstractBean provideDependency() {
        // We can chose here which implementation of AbstractBean to inject if there is more than one.
        return new AbstractBeanImpl();
    }
}
