package kon.blats.validation;


import org.junit.Test;


import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;

import static org.junit.Assert.assertEquals;

/**
 * Created by k.blatsoukas on 9/1/2017.
 */
public class HibernateBuiltInValidator {

    @Test
    public void testBuiltInValidationsCustomAnnotation() throws ParseException {
        Person customPerson = new Person();
        customPerson .setAge(31);
        customPerson .setSalary(1201);
        customPerson .setName("Konstantinos");
        customPerson .setSurname("Blatsoukas");
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        String myBirthDate = "10-03-1986";
        Date date = dateFormat.parse(myBirthDate);
        customPerson .setDateOfBirth(date);

        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        Validator validator = validatorFactory.getValidator();
        Set<ConstraintViolation<Person>> violations = validator.validate(customPerson);
        int totalViolations = violations.size();
        assertEquals(0, totalViolations);
    }

    @Test
    public void testBuiltInValidationsNoViolationsOccurred() throws ParseException {
        Person konstantinosBlatsoukas = new Person();
        konstantinosBlatsoukas.setAge(31);
        konstantinosBlatsoukas.setSalary(1200);
        konstantinosBlatsoukas.setName("Konstantinos");
        konstantinosBlatsoukas.setSurname("Blatsoukas");
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        String myBirthDate = "10-03-1986";
        Date date = dateFormat.parse(myBirthDate);
        konstantinosBlatsoukas.setDateOfBirth(date);

        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        Validator validator = validatorFactory.getValidator();
        Set<ConstraintViolation<Person>> violations = validator.validate(konstantinosBlatsoukas);
        int totalViolations = violations.size();
        assertEquals(0, totalViolations);
    }

    @Test
    public void testBuiltInValidationsViolationsOccurred() throws ParseException {
        Person konstantinosBlatsoukas = new Person();
        konstantinosBlatsoukas.setAge(31);
        konstantinosBlatsoukas.setSalary(1200);
        konstantinosBlatsoukas.setName("Konstantinos");
        konstantinosBlatsoukas.setSurname("Blatsoukas");
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        String myBirthDate = "10-03-2018";
        Date date = dateFormat.parse(myBirthDate);
        konstantinosBlatsoukas.setDateOfBirth(date);

        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        Validator validator = validatorFactory.getValidator();
        Set<ConstraintViolation<Person>> violations = validator.validate(konstantinosBlatsoukas);
        int totalViolations = violations.size();
        assertEquals(1, totalViolations);
    }
}


