import io.restassured.response.Response;
import model.Employee;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class GetAllEmployees {


    private Request request = new Request();

    private RandomGenerator randomName = new RandomGenerator(14);
    private RandomGenerator randomAge = new RandomGenerator(2);
    private RandomGenerator randomSalary = new RandomGenerator(5);

    private String name = randomName.randomLetters();
    private String age = randomAge.randomNumbers();
    private String salary = randomSalary.randomNumbers();

    private Employee newEmployee = new Employee(name, age, salary);


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
