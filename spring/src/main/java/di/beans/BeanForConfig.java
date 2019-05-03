package di.beans;

/**
 * Bean provided in the context using a configuration class.
 * Note that neither this class nor its dependencies have any Spring annotation.
 */
public class BeanForConfig {

    private AbstractBean otherBean;

    public BeanForConfig(AbstractBean otherBean) {
        this.otherBean = otherBean;
    }

    String getValue() {
        return otherBean != null ? "Bean with " + otherBean.getClass().getSimpleName() : "Missing dependency";
    }
}
