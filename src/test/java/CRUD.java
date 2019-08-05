import io.restassured.response.Response;
import model.Employee;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;


public class CRUD {

    private Request request = new Request();
    private Response response;

    private String updatedName;
    private Integer updatedAge;
    private Double updatedSalary;
    private Employee newEmployee;
    private String name;
    private String age;
    private String salary;

    @BeforeTest
    public void setup() {
        RandomGenerator randomName = new RandomGenerator(14);
        name = randomName.randomLetters();

        RandomGenerator randomAge = new RandomGenerator(2);
        age = randomAge.randomNumbers();

        RandomGenerator randomSalary = new RandomGenerator(5);
        salary = randomSalary.randomNumbers();

        updatedName = "U" + name;
        updatedAge = Integer.valueOf(age) + 5;
        updatedSalary = Double.valueOf(salary) + 9000;
        newEmployee = new Employee(name, age, salary);

        response = request.createEmployeeWithDetails(newEmployee);

        String employeeId = response.getBody().jsonPath().getString(Constants.ID);
        newEmployee.setId(employeeId);

    }


    @Test(priority = 1)
    public void testNewEmployeeCanBeCreated() {


        assertThat("Status code was not the expected one.", response.getStatusCode(), is(HttpStatus.SC_OK));

        assertThat("Employee salary does not match!", response.getBody().jsonPath()
                .getString("salary"), is(newEmployee.getSalary()));

        assertThat("Employee name does not match!", response.getBody().jsonPath()
                .getString("name"), is(newEmployee.getName()));

        assertThat("Employee age does not match!", response.getBody().jsonPath()
                .getString("age"), is(newEmployee.getAge()));


    }

    @Test(priority = 2)
    public void testGetEmployeeData() {

        String employeeId = newEmployee.getId();
        response = request.getEmployeeById(employeeId);

        assertThat("Employee salary does not match!", response.getBody().jsonPath()
                .getString("employee_salary"), is(newEmployee.getSalary()));

        assertThat("Employee Id does not match!", response.getBody().jsonPath().getString(Constants.ID),
                is(newEmployee.getId()));

        assertThat("Employee name does not match!", response.getBody().jsonPath()
                .getString("employee_name"), is(newEmployee.getName()));


        assertThat("Employee age does not match!", response.getBody().jsonPath()
                .getString("employee_age"), is(newEmployee.getAge()));


    }


    @Test(priority = 3)
    public void testUpdatedEmployee() {



        String payload = "{\"name\":\"" +
                updatedName + "\",\"salary\":\"" +
                updatedSalary + "\",\"age\":\"" +
                updatedAge + "\"}";

        response = request.updateEmployee(newEmployee.getId(), payload);

        assertThat("Status code was not the expected one.", response.getStatusCode(), is(HttpStatus.SC_OK));

        response = request.getEmployeeById(newEmployee.getId());

        assertThat("Employee Id does not match!", response.getBody().jsonPath().getString(Constants.ID),
                is(newEmployee.getId()));

        assertThat("Employee salary does not match!", response.getBody().jsonPath()
                .getDouble("employee_salary"), is(updatedSalary));

        assertThat("Employee age does not match!", response.getBody().jsonPath()
                .getInt("employee_age"), is(updatedAge));

        assertThat("Employee name does not match!", response.getBody().jsonPath()
                .getString("employee_name"), is(updatedName));


    }

    @Test(priority = 4)
    public void testDeleteEmployeeById() {

        String employeeId = newEmployee.getId();

        response = request.deleteEmployee(employeeId);

        assertThat("Status code was not the expected one.", response.getStatusCode(), is(HttpStatus.SC_OK));

        Assert.assertTrue(response.then().extract().asString().contains("successfully! deleted Records"));
    }


}
