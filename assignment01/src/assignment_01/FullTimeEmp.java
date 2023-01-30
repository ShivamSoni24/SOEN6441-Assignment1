package assignment_01;

// Class to exhibit characteristics of a full-time employee.
public class FullTimeEmp extends Employee implements FinanceDetails {
    private double salary;

    public FullTimeEmp(String firstName, String lastName, int age, int id, double salary) {
        super(firstName, lastName, age, id);
        this.salary = salary;
    }
    @Override
    public double getSalary() {
        return salary;
    }

    //Overridden method to display given full-time employee's cheque details
    @Override
    public void displayCheque() {
        System.out.println("\nCheque number is:     " + getChequeNum());
        System.out.println("Cheque is payable to: " + getFirstName() + " " + getLastName());
        System.out.println("Amount payable is:    " + getSalary() + "\n");
    }
}
