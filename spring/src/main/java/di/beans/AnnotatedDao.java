package di.beans;

import org.springframework.stereotype.Repository;

@Repository
class AnnotatedDao {

    private static final String VALUE = "Value from Dao";

    String getValue() {
        return VALUE;
    }
}
