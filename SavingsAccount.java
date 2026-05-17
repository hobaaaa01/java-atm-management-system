// Class representing a savings account that earns interest
class SavingsAccount extends Account {
    private double interestRate; // Interest rate for the savings account

    public SavingsAccount(String accountNumber, String accountHolderName, double interestRate) {
        super(accountNumber, accountHolderName); // Call the superclass constructor
        this.interestRate = interestRate; // Set interest rate
    }

    @Override
    public void deposit(double amount) {
        balance += amount; // Increase balance by the deposit amount
    }

    @Override
    public void withdraw(double amount) throws InsufficientFundsException {
        // Check for sufficient funds before withdrawal
        if (balance < amount) {
            throw new InsufficientFundsException("Insufficient funds for withdrawal."); // Throw exception if not enough funds
        }
        balance -= amount; // Decrease balance by the withdrawal amount
    }

    // Calculates and returns the interest earned
    public double calculateInterest() {
        return balance * interestRate; // Calculate interest based on the balance
    }
}