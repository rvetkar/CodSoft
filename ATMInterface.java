import java.util.Scanner;

public class ATMInterface 
{

    private static double balance = 5000.00;

    public static void main(String[] args) 
    {

        Scanner sc = new Scanner(System.in);
        System.out.println("\nWelcome to ATM Interface");

        while (true) 
        {
            
            System.out.println("Press 1 to Check balance");
            System.out.println("Press 2 to Withdraw Cash");
            System.out.println("Press 3 to  Deposit Cash");
            System.out.println("Press 4 to Exit");

            System.out.print("Enter your choice: ");
            int ch = sc.nextInt();

            switch (ch) {
                case 1:
                    checkbalance();
                    break;
                case 2:
                    withdraw(sc);
                    break;
                case 3:
                    deposit(sc);
                    break;
                case 4:
                    System.out.println("Exiting the ATM Interface");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void checkbalance() 
    {
        System.out.println("Your current balance is: " + balance);
    }

    private static void withdraw(Scanner scanner) 
    {
        System.out.print("Enter the amount to withdraw: ");
        double amount = scanner.nextDouble();

        if (amount > balance) 
        {
            System.out.println("Insufficient balance.");
        } 
        else 
        {
            balance -= amount;
            System.out.println("You have successfully withdrawn: " + amount);
            System.out.println("Your Current balance is: " + balance);
        }
    }

    private static void deposit(Scanner sc) 
    {
        System.out.print("Enter the amount to deposit: ");
        double amount = sc.nextDouble();

        balance += amount;
        System.out.println("You have successfully deposited: " + amount);
        System.out.println("Your new balance is: " + balance);
    }
}
