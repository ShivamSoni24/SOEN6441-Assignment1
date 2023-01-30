package assignment_01;

// Abstract class which will be further inherited by Full-time and Part-time employee.
abstract class Employee {
    private String firstName;
    private String lastName;
    private int age;
    private int id;

    protected Employee(String firstName, String lastName, int age, int id) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.id = id;
    }

    public int getChequeNum() {
        int chequeNum =  ((int) (Math.random()*(99999 - 10000))) + 10000;
        return chequeNum;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public abstract double getSalary();
}

