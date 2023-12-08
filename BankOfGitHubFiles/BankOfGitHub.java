import java.util.Scanner;

public class BankOfGitHub 
{
    Scanner scanner = new Scanner(System.in);
    private double createBalance;
    private String newUsersName;
    private char newAccountCreation;
    private char confirmBalance;
    private String userPassword;
    private String confirmedPassword;
    
    public BankOfGitHub() {
        openingMessage();
    }
    
    public void openingMessage() {
        System.out.println("Hello, welcome to Bank of GitHub!\n\nEnter 'Y' to create a new account:");
        do {
            newAccountCreation = scanner.nextLine().charAt(0);
        
            if (newAccountCreation == 'y' || newAccountCreation == 'Y') {
                System.out.println("Great! New account created.\n\nPlease enter a user name:");
                newUsersName = scanner.nextLine();
            } else {
                System.out.println("Invalid input, please enter 'Y' to create a new account:");
            }
        } while (newAccountCreation != 'y' && newAccountCreation != 'Y');
        
        setPassword();
    }
    
    public void setPassword() {
        System.out.println("\nPlease enter a password:");
        userPassword = scanner.nextLine();
        confirmPasswordMethod(userPassword);
    }
    
    public void confirmPasswordMethod (String newUserPassword) {
        userPassword = newUserPassword;
        do{
            System.out.println("\nPlease confirm your password:");
            confirmedPassword = scanner.nextLine();
            
            if (confirmedPassword.equals(userPassword)) {
                System.out.println("\nPassword confirmed!\n");
            } else {
                System.out.println("Passwords do not match, please try again.\n");
            }
        } while (!confirmedPassword.equals(userPassword));
        
        setBalance();
    }

    public void setBalance() {
        System.out.print("WOW, it is your lucky day!\nChoose the balance you would like to instantly deposit:\n$");
        createBalance = scanner.nextDouble();
        System.out.printf("\nAre you sure you would like to deposit $%.2f? (Y for yes, N for no)\n", createBalance);
            do {
                confirmBalance = scanner.next().charAt(0);
                if (confirmBalance == 'y' || confirmBalance == 'Y') {
                    System.out.println("\nOkay! Your balance has been confirmed.");
                } else if (confirmBalance == 'n' || confirmBalance == 'N') {
                    System.out.print("\nNo problem! Re-enter the balance you would like to instantly deposit:\n$");
                    createBalance = scanner.nextDouble();
                } else {
                    System.out.println("Invalid input, please enter Y for yes and N for no:");
            }
        } while (confirmBalance != 'y' && confirmBalance != 'Y' && confirmBalance != 'n' && confirmBalance != 'N');
    
        System.out.printf("\n\nGreat!\nNow that you have $%.2f in GitHubBucks,\nyou can spend it in imaginary land... now umm, goodbye!", createBalance);
    }
}