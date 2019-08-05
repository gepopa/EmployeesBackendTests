import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class TestGetAllEmployees {


    private final String name = RandomGenerator.randomLetters(14);
    private final String age = RandomGenerator.randomNumbers(2);
    private final String salary = RandomGenerator.randomNumbers(5);

    private final Employee newEmployee = new Employee(name, age, salary);
    private final Request request = new Request();

    @Test
    public void testCanGetAllEmployees() {
        String employeeId = request.createEmployeeWithDetails(newEmployee).getBody().jsonPath().getString(Constants.ID);

        newEmployee.setId(employeeId);

        Response response = request.getAllEmployees();

        List<String> employeeNames = response.getBody().jsonPath()
                .getList("employee_name");

        List<String> employeeIds = response.getBody().jsonPath()
                .getList("id");

        List<String> employeeSalaryList = response.getBody().jsonPath()
                .getList("employee_salary");

        List<String> employeeAgeList = response.getBody().jsonPath()
                .getList("employee_age");


        Assert.assertTrue(employeeIds.contains(newEmployee.getId()));
        Assert.assertTrue(employeeNames.contains(newEmployee.getName()));
        Assert.assertTrue(employeeSalaryList.contains(newEmployee.getSalary()));
        Assert.assertTrue(employeeAgeList.contains(newEmployee.getAge()));


    }


}
