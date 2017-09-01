package kon.blats.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Created by k.blatsoukas on 9/1/2017.
 */
public class CheckSalaryEvenValidator implements ConstraintValidator<CheckSalaryEven, Person>{

    @Override
    public void initialize(CheckSalaryEven constraintAnnotation) {
    }

    @Override
    public boolean isValid(Person value, ConstraintValidatorContext context) {
        if(value == null ){
            return false;
        }
        boolean isAgeEven = value.getAge() % 2 == 0;
        return isAgeEven;
    }
}
