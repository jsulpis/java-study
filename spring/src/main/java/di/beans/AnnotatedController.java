package di.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;

@Controller
public class AnnotatedController {

    private AnnotatedService service;
    private BeanForConfig bean;

    @Value("${someConfigValue}")
    private String property;

    @Autowired
    public AnnotatedController(AnnotatedService service, BeanForConfig bean) {
        this.service = service;
        this.bean = bean;
    }

    public String getValueFromService() {
        return service.getValue();
    }

    public String getValueFromBean() {
        return bean.getValue();
    }

    public String getProperty() {
        return property;
    }
}
