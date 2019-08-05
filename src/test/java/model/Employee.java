package model;


public class Employee {

    private String name;
    private String age;
    private String salary;
    private String id;


    public Employee(String name, String age, String salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }


    public String getName() {
        return name;
    }

    public String getAge() {
        return age;
    }

    public String getSalary() {
        return salary;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}