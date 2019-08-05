import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

class Request {


    Response createEmployeeWithDetails(Employee employee) {

        return
                given()
                        .when()
                        .body("{\n" +
                                "\t\"name\":\"" + employee.getName() + "\",\n" +
                                "\t\"salary\":\"" + employee.getSalary() + "\",\n" +
                                "\t\"age\":\"" + employee.getAge() + "\"\n" +
                                "}")
                        .post(Constants.BASE_URL + Constants.ADD_EMPLOYEE)
                        .then()
                        .extract()
                        .response();

    }

    Response getEmployeeById(String employeeId) {

        return
                given()
                        .when()
                        .get(Constants.BASE_URL + Constants.GET_EMPLOYEE_BY_ID, employeeId)
                        .then()
                        .extract()
                        .response();
    }


    Response getAllEmployees() {

        return
                given()
                        .when()
                        .get(Constants.BASE_URL + Constants.GET_ALL_EMPLOYEES)
                        .then()
                        .extract()
                        .response();
    }

    Response createEmployeeWithInvalidBody(String payload) {

        return
                given()
                        .when()
                        .body(payload)
                        .post(Constants.BASE_URL + Constants.ADD_EMPLOYEE)
                        .then()
                        .extract()
                        .response();

    }

    Response updateEmployee(String employeeId, String payload) {

        return
                given()
                        .when()
                        .body(payload)
                        .put(Constants.BASE_URL + Constants.UPDATE_EMPLOYEE_DATA, employeeId)
                        .then()
                        .extract()
                        .response();
    }

    Response deleteEmployee(String employeeId) {

        return
                given()
                        .when()
                        .delete(Constants.BASE_URL + Constants.DELETE_EMPLOYEE, employeeId)
                        .then()
                        .extract()
                        .response();
    }
}
