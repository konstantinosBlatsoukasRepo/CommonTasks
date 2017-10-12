package kon.blats.validation;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.internal.engine.groups.Group;

import javax.validation.constraints.*;
import java.util.Date;

/**
 * Created by k.blatsoukas on 9/1/2017.
 */
@Getter
@Setter
@CheckSalaryEven
public class Person {
    @NotNull
    @Null(groups={Nameless.class})
    private String name;
    @NotNull
    @Null(groups={Nameless.class})
    private String surname;
    @Min(value=1000)
    private int salary;
    @Max(value=35)
    private int age;
    @Past
    private Date dateOfBirth;
}
