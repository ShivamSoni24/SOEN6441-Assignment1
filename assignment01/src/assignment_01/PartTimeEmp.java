package assignment_01;

// Class to exhibit characteristics of a part-time employee.
public class PartTimeEmp extends Employee implements FinanceDetails {
    private int echelon;
    private double numOfHrsWrkd;
    private int hourlyRate;
    public PartTimeEmp(String firstName, String lastName, int age, int id, int echelon, int numOfHrsWrkd) {
        super(firstName, lastName, age, id);
        this.echelon = echelon;
        this.numOfHrsWrkd = numOfHrsWrkd;
        this.hourlyRate = getHourlyRate(echelon);
    }

    // function to return respective hourly rate of a given echelon.
    private int getHourlyRate(int echelon) {
        switch (echelon) {
            case 1: return 15;
            case 2: return 20;
            case 3: return 25;
            case 4: return 30;
            case 5: return 40;
            default: return 0;
        }
    }

    @Override
    public double getSalary() {
        return (hourlyRate * numOfHrsWrkd);
    }

    //Overridden method to display given part-time employee's cheque details
    @Override
    public void displayCheque() {
        System.out.println("\nCheque number is:     " + getChequeNum());
        System.out.println("Cheque is payable to: " + getFirstName() + " " + getLastName());
        System.out.println("Amount payable is:    " + getSalary() + "\n");
    }
}
