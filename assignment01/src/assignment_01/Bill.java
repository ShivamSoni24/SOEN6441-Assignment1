package assignment_01;

public class Bill implements FinanceDetails{
    private String companyName;
    private double amountDue;
    private String month;
    private int day;
    private int year;
    private int chequeNum;

    public Bill(String companyName, double amountDue, String month, int day, int year) {
        this.companyName = companyName;
        this.amountDue = amountDue;
        this.month = month;
        this.day = day;
        this.year = year;
        this.chequeNum = generateChequeNum();
    }

    //method to get a random 5-digit number as cheque number
    private int generateChequeNum() {
        chequeNum =  ((int) (Math.random()*(99999 - 10000))) + 10000;
        return chequeNum;
    }

    private int getChequeNum() {
        return chequeNum;
    }

    private String getCompanyName() {
        return companyName;
    }

    private double getAmountDue() {
        return amountDue;
    }

    private String getDueDate() {
        return (this.month+ " " + Integer.toString(this.day) + ", " + Integer.toString(this.year));
    }

    //Overridden method to display given bill's cheque details
    @Override
    public void displayCheque() {
        System.out.println("\nCheque number is:     " + getChequeNum());
        System.out.println("Cheque is payable to: " + getCompanyName());
        System.out.println("Amount payable is:    " + getAmountDue());
        System.out.println("The due date is:      " + getDueDate()+ "\n");
    }
}
