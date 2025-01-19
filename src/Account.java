
public class Account {
	private String accountNumber;
	private String accountHolderName;
	private String password;
	private double balance;
	
	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getAccountHolderName() {
		return accountHolderName;
	}

	public void setAccountHolderName(String accountHolderName) {
		this.accountHolderName = accountHolderName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}


	//constructor
	public void Account(String accountNumber, String accountHolderName, String password, double balance) {
	    this.accountNumber = accountNumber;
	    this.accountHolderName = accountHolderName;
	    this.password = password;
	    this.balance = balance;
	}

	//Method
	public void deposit(double amount) {
	    if (amount > 0) {
	        balance += amount;
	        System.out.println("Deposit successful! New balance: " + balance);
	    } else {
	        System.out.println("Invalid amount.");
	    }
	}
	public void withdraw(double amount) {
	    if (amount > 0 && amount <= balance) {
	        balance -= amount;
	        System.out.println("Withdrawal successful! New balance: " + balance);
	    } else {
	        System.out.println("Invalid amount or insufficient funds.");
	    }
	}
	public void transfer(Account recipient, double amount) {
	    if (amount > 0 && amount <= balance) {
	        balance -= amount;
	        recipient.deposit(amount);
	        System.out.println("Transfer successful! New balance: " + balance);
	    } else {
	        System.out.println("Invalid amount or insufficient funds.");
	    }
	}

}
