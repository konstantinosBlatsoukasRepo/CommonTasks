package kon.blats.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * Created by k.blatsoukas on 9/1/2017.
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = CheckSalaryEvenValidator.class)
@Documented
public @interface CheckSalaryEven {
    String message() default "kon.blats salary is not an even number";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
