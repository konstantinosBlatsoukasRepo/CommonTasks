package kon.blats.validation;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.util.Date;

/**
 * Created by k.blatsoukas on 9/1/2017.
 */
@Getter
@Setter
public class Person {
    @NotNull
    private String name;
    @NotNull
    private String surname;
    @Min(value=1000)
    private int salary;
    @Max(value=35)
    private int age;
    @Past
    private Date dateOfBirth;
}
