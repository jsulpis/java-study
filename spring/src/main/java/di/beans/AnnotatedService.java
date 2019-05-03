package di.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
class AnnotatedService {

    @Autowired
    private AnnotatedDao dao;

    String getValue() {
        return dao.getValue();
    }
}
