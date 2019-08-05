import io.restassured.response.Response;
import model.Employee;
import org.testng.annotations.Test;

import static com.jayway.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;



public class JsonSchemaValidator {

    private RandomGenerator randomName = new RandomGenerator(14);
    private RandomGenerator randomAge = new RandomGenerator(2);
    private RandomGenerator randomSalary = new RandomGenerator(5);

    private String name = randomName.randomLetters();
    private String age = randomAge.randomNumbers();
    private String salary = randomSalary.randomNumbers();


    private Employee newEmployee = new Employee(name, age, salary);
    private Request request = new Request();
    private Response response;
    @Test
    public void testJsonSchema() {

        response = request.createEmployeeWithDetails(newEmployee);
        response.then().assertThat().body(matchesJsonSchemaInClasspath("resources/jsonSchema.json"));

    }

}
