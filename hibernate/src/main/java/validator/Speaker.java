package validator;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
public class Speaker {

    @NotNull
    @Size(min = 1, max = 20)
    private final String model;

    @NotNull
    @Min(0)
    private final int powerInWatts;

    @NotNull
    @Range(min = 0, max = 10)
    private int level;
}
