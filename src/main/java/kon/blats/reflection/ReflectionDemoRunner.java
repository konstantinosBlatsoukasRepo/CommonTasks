package kon.blats.reflection;

/**
 * Created by kon on 1/1/2018.
 */
public class ReflectionDemoRunner {

    public static void main(String[] args) throws IllegalAccessException, NoSuchFieldException {
        Employee employee = new Employee();
        employee.setSalary(1000);
        employee.setId(1);
        employee.setEmployeeType("Super Employee");
        EmployeeDetails employeeDetails = new EmployeeDetails();
        employeeDetails.setName("Kostakis");
        employee.setEmployeeDetails(employeeDetails);

        FieldsToUpperCaseConverter converter = new FieldsToUpperCaseConverter();
        converter.convertFieldsToUpperCase(employee);
        System.out.println();
    }

}
