package di.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class AnnotatedController {

    private AnnotatedService service;
    private BeanForConfig bean;

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
}
