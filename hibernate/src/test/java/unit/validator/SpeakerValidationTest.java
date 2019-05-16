package unit.validator;

import org.junit.BeforeClass;
import org.junit.Test;
import validator.Speaker;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class SpeakerValidationTest {

    private static Validator validator;

    @BeforeClass
    public static void setUpValidator() {
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
        testConstraints(speaker, "ne peut pas être nul");
    }

    @Test
    public void modelWithWrongLengthTest() {
        Speaker speaker = new Speaker("", 100, 0);
        testConstraints(speaker, "la taille doit être comprise entre 1 et 20");

        speaker = new Speaker("Short Name", 100, 0);
        assertNoConstraintViolated(speaker);

        speaker = new Speaker("Very very very very long name", 100, 0);
        testConstraints(speaker, "la taille doit être comprise entre 1 et 20");
    }

    @Test
    public void negativePowerTest() {
        Speaker speaker = new Speaker("R65", -100, 0);
        testConstraints(speaker, "doit être au minimum égal à 0");
    }

    @Test
    public void levelInRangeTest() {
        Speaker speaker = new Speaker("R65", 100, -1);
        testConstraints(speaker, "doit être entre 0 et 10");

        speaker.setLevel(5);
        assertNoConstraintViolated(speaker);

        speaker.setLevel(11);
        testConstraints(speaker, "doit être entre 0 et 10");

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
