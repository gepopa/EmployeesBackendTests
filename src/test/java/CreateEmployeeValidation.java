import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateEmployeeValidation {

    private Request request = new Request();
    private Response response;


    @Test
    public void testCreateEmployeeNoNameValidation() {
        response = request.createEmployeeWithInvalidBody(Constants.CREATE_EMPLOYEE_WITHOUT_NAME);

        Assert.assertTrue(response.then().extract().asString().contains("Integrity constraint violation: 1048 Column 'employee_name' cannot be null"));

    }

    @Test
    public void testCreateEmployeeNoAgeValidation() {
        response = request.createEmployeeWithInvalidBody(Constants.CREATE_EMPLOYEE_WITHOUT_AGE);

        Assert.assertTrue(response.then().extract().asString().contains("Integrity constraint violation: 1048 Column 'employee_age' cannot be null"));

    }

    @Test
    public void testCreateEmployeeNoSalaryValidation() {
        response = request.createEmployeeWithInvalidBody(Constants.CREATE_EMPLOYEE_WITHOUT_SALARY);

        Assert.assertTrue(response.then().extract().asString().contains("Integrity constraint violation: 1048 Column 'employee_salary' cannot be null"));

    }
}
