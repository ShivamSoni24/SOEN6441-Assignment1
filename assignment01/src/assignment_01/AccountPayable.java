package assignment_01;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.List;


// Driver class
public class AccountPayable {
    
    // Main array which stores all objects
    private ArrayList<FinanceDetails> allUtilities;
    Scanner inputObject;
    // Full-time and Part-time employee counter.
    private int fullTimeEmpCnt;
    private int partTimeEmpCnt;
    // For month I am taking input as integer and converting it to month so spelling doesn't mismatch.
    private final Map<Integer, String> monthName;
    public static final String EXCEPTIONMESSAGE = "data type mismatch, please retry";

    AccountPayable() {
        allUtilities = new ArrayList<>();
        inputObject  = new Scanner(System.in);
        fullTimeEmpCnt = 0;
        partTimeEmpCnt = 0;
        monthName = new HashMap<>();
        monthName.put(1, "January");
        monthName.put(2, "February");
        monthName.put(3, "March");
        monthName.put(4, "April");
        monthName.put(5, "May");
        monthName.put(6, "June");
        monthName.put(7, "July");
        monthName.put(8, "August");
        monthName.put(9, "September");
        monthName.put(10, "October");
        monthName.put(11, "November");
        monthName.put(12, "December");
    }

    // Main Object
    public static void main(String[] args) {
        boolean flag = false;
        AccountPayable mainObject = new AccountPayable();
        while (!flag) {
            try{
                mainObject.displayMenu();
                flag = true;
            } catch (Exception e) {
                System.out.println(EXCEPTIONMESSAGE);
                mainObject.inputObject.nextLine();
            }
        }

    }

    // Function which displays the menu.
    public void displayMenu() {
        int inputdata = 4;
        do {
            System.out.println("\n***\tOPTIONS\t***");
            System.out.println("1. Add an employee\n2. Add a bill\n3. Issue cheques\n4. Exit");
            System.out.print("Enter your choice:\t");
            inputdata = inputObject.nextInt();

            switch (inputdata) {
                case 1 -> addNewEmployee();
                case 2 -> addABill();
                case 3 -> displayCheques();
                case 4 -> System.out.println("\nProgram is terminating. Bye!");
                default -> System.out.println("\nPlease enter a number between 1 to 4\n\n");
            }
        } while (inputdata != 4);
    }

    // Function to take demographic data from the user and puts it in the full-time and part-time employee
    public List<Object> getGeneralEmpdata() {
        List<Object> data = new ArrayList<>();

        System.out.print("Enter first name: ");
        data.add(inputObject.next());
        System.out.print("Enter last name: ");
        data.add(inputObject.next());
        System.out.print("Enter age: ");
        data.add(inputObject.nextInt());
        System.out.print("Enter ID: ");
        data.add(inputObject.nextInt());
        return data;
    }

    // Function to add new employee to the system.
    public void addNewEmployee() {
        System.out.println("\nEnter the type of employee to add\n1.Full time\n2.Part time");
        System.out.print("Enter your choice: ");
        int inputdata = 0;

            inputdata = inputObject.nextInt();
            while(inputdata < 1 || inputdata > 2){
                System.out.print("Enter a valid number from 1 or 2: ");
                inputdata = inputObject.nextInt();
            }

        switch (inputdata) {
            case 1 -> {
                if (fullTimeEmpCnt < 5) {
                    fullTimeEmpCnt++;
                    List<Object> data = getGeneralEmpdata();
                    System.out.print("Enter salary per month: ");
                    double salary = inputObject.nextDouble();
                    allUtilities.add(new FullTimeEmp(data.get(0).toString(), data.get(1).toString(),
                            Integer.parseInt(data.get(2).toString()), Integer.parseInt(data.get(3).toString()),
                            salary));
                } else
                    System.out.println("The limit to add full-time employees is 5, you've already reached that " +
                            "limit.");
            }
            case 2 -> {
                if (partTimeEmpCnt < 5) {
                    partTimeEmpCnt++;
                    List<Object> data = getGeneralEmpdata();
                    System.out.print("Enter echelon(1-5): ");
                    int echelon = inputObject.nextInt();
                    while(echelon < 1 || echelon > 5){
                        System.out.print("Enter a valid echelon from 1 to 5: ");
                        echelon = inputObject.nextInt();
                    }
                    System.out.print("Enter hours worked: ");
                    int numOfHrsWrkd = inputObject.nextInt();

                    allUtilities.add(new PartTimeEmp(data.get(0).toString(), data.get(1).toString(),
                            Integer.parseInt(data.get(2).toString()), Integer.parseInt(data.get(3).toString()),
                            echelon, numOfHrsWrkd));
                } else
                    System.out.println("The limit to add part-time employees is 5, you've already reached that " +
                            "limit.");
            }
            default -> System.out.println("Please enter a valid choice...try again.");
        }
    }

    // Function to add a new bill in the system.
    public void addABill() {
        System.out.print("Enter the name of company: ");
        //cleaning up the last possible \n character
        inputObject.nextLine();
        String companyName = inputObject.nextLine();
        System.out.print("Enter the amount due:      ");
        double amountDue = inputObject.nextDouble();
        System.out.print("Enter the day of due date [DD, 01-31]: ");
        int day = inputObject.nextInt();
        while(day <= 0 || day >=32)
        {
            System.out.print("Enter the valid date in range of 1-31: ");
            day = inputObject.nextInt();
        }

        System.out.print("Enter the month of due date [MM, 01-12]: ");
        int intMonth = inputObject.nextInt();
        while(intMonth <= 0 || intMonth >=13)
        {
            System.out.print("Enter the valid month in range of 1-12: ");
            intMonth = inputObject.nextInt();
        }
        String month = monthName.get(intMonth);
        System.out.print("Enter the year: ");
        int yyyy = inputObject.nextInt();
        while(yyyy < 2015 || yyyy > 2099){
            System.out.print("Enter a valid year(acceptable years range from 2015 to 2099): ");
            yyyy = inputObject.nextInt();
        }

        allUtilities.add(new Bill(companyName, amountDue, month, day, yyyy));
    }

    // function to display all the cheques in the system.
    public void displayCheques() {
        if(allUtilities.size() == 0)
            System.out.println("There is no entries made yet, please enter the data first.");
        else {
            System.out.print("\033[H\033[2J");
            System.out.flush();
            for (FinanceDetails allUtility : allUtilities) {
                allUtility.displayCheque();
            }
        }
    }
}