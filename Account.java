// Abstract class representing a generic bank account
abstract class Account {
    protected String accountNumber; // Unique account number
    protected double balance; // Current balance of the account
    protected String accountHolderName; // Name of the account holder

    // Constructor to initialize account number and holder name, sets initial balance to 0.0
    public Account(String accountNumber, String accountHolderName) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = 0.0;
    }

    // Abstract methods for deposit and withdrawal, to be implemented by subclasses
    public abstract void deposit(double amount);
    public abstract void withdraw(double amount) throws InsufficientFundsException;

    // Getter methods for account details
    public double getBalance() {
        return balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }
}