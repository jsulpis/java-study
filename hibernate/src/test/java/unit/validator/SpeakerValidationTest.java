package unit.validator;

import org.junit.BeforeClass;
import org.junit.Test;
import validator.Speaker;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Locale;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class SpeakerValidationTest {

    private static Validator validator;

    @BeforeClass
    public static void setUpValidator() {
        Locale.setDefault(Locale.ENGLISH);
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    public void speakerWithGoodAttributes() {
        Speaker speaker = new Speaker("R65", 100, 0);
        assertNoConstraintViolated(speaker);
    }

    @Test
    public void modelIsNullTest() {
        Speaker speaker = new Speaker(null, 100, 0);
        testConstraints(speaker, "must not be null");
    }

    @Test
    public void modelWithWrongLengthTest() {
        Speaker speaker = new Speaker("", 100, 0);
        testConstraints(speaker, "size must be between 1 and 20");

        speaker = new Speaker("Short Name", 100, 0);
        assertNoConstraintViolated(speaker);

        speaker = new Speaker("Very very very very long name", 100, 0);
        testConstraints(speaker, "size must be between 1 and 20");
    }

    @Test
    public void negativePowerTest() {
        Speaker speaker = new Speaker("R65", -100, 0);
        testConstraints(speaker, "must be greater than or equal to 0");
    }

    @Test
    public void levelInRangeTest() {
        Speaker speaker = new Speaker("R65", 100, -1);
        testConstraints(speaker, "must be between 0 and 10");

        speaker.setLevel(5);
        assertNoConstraintViolated(speaker);

        speaker.setLevel(11);
        testConstraints(speaker, "must be between 0 and 10");

    }

    private void assertNoConstraintViolated(Speaker speaker) {
        Set<ConstraintViolation<Speaker>> constraintViolations = validator.validate(speaker);
        assertThat(constraintViolations).isEmpty();
    }

    private void testConstraints(Speaker speaker, String s) {
        Set<ConstraintViolation<Speaker>> constraintViolations = validator.validate(speaker);
        assertThat(constraintViolations).hasSize(1);
        assertThat(constraintViolations.iterator().next().getMessage()).isEqualTo(s);
    }
}
