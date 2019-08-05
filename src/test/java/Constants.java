

class Constants {


    static final String BASE_URL = "http://dummy.restapiexample.com/api/v1/";

    static final String GET_ALL_EMPLOYEES = "employees";
    static final String ADD_EMPLOYEE = "create";
    static final String GET_EMPLOYEE_BY_ID = "employee/{employeeId}";
    static final String UPDATE_EMPLOYEE_DATA = "update/{employeeId}";
    static final String DELETE_EMPLOYEE = "delete/{employeeId}";

    static final String ID = "id";
    static final String CREATE_EMPLOYEE_WITHOUT_NAME = "{\"salary\":\"123\",\"age\":\"23\"}";
    static final String CREATE_EMPLOYEE_WITHOUT_AGE = "{\"salary\":\"123\",\"name\":\"some name\"}";
    static final String CREATE_EMPLOYEE_WITHOUT_SALARY = "{\"name\":\"other name\",\"age\":\"23\"}";

}
