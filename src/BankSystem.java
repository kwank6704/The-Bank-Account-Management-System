import java.util.Scanner;

public class BankSystem {
	private Scanner scanner;
	private DatabaseHandler databaseHandler;
	private Account loggedInAccount;
	
	public void start() {
	    System.out.println("Welcome to the Bank System!");
	    while (true) {
	        showMenu();
	    }
	}

	private void showMenu() {
	    System.out.println("1. Login");
	    System.out.println("2. Create Account");
	    System.out.println("3. Exit");
	    System.out.print("Choose an option: ");
	    int choice = scanner.nextInt();
	    scanner.nextLine(); 
	    
	    switch (choice) {
	        case 1: login(); break;
	        case 2: createAccount(); break;
	        case 3: exit(); break;
	        default: System.out.println("Invalid option.");
	    }
	}
	
	private void login() {
	    System.out.print("Enter account number: ");
	    String accountNumber = scanner.nextLine();
	    System.out.print("Enter password: ");
	    String password = scanner.nextLine();

	    Account account = databaseHandler.findAccount(accountNumber);
	    if (account != null && account.getPassword().equals(password)) {
	        loggedInAccount = account;
	        System.out.println("Login successful!");
	        userMenu();
	    } else {
	        System.out.println("Invalid credentials!");
	    }
	}

	private void createAccount() {
	    System.out.print("Enter your name: ");
	    String name = scanner.nextLine();
	    System.out.print("Set a password: ");
	    String password = scanner.nextLine();
	    String accountNumber = "ACC" + System.currentTimeMillis();

	    Account newAccount = new Account(accountNumber, name, password, 0.0);
	    databaseHandler.addAccount(newAccount);
	    System.out.println("Account created! Your account number is: " + accountNumber);
	}

	private void userMenu() {
	    while (true) {
	        System.out.println("1. Deposit");
	        System.out.println("2. Withdraw");
	        System.out.println("3. Transfer");
	        System.out.println("4. Check Balance");
	        System.out.println("5. Logout");
	        System.out.print("Choose an option: ");
	        int choice = scanner.nextInt();
	        scanner.nextLine();

	        switch (choice) {
	            case 1: deposit(); break;
	            case 2: withdraw(); break;
	            case 3: transfer(); break;
	            case 4: checkBalance(); break;
	            case 5: logout(); return;
	            default: System.out.println("Invalid option.");
	        }
	    }
	}


}
