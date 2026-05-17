// Class representing a checking account with overdraft capabilities
class CheckingAccount extends Account {
    private double overdraftLimit; // Limit for overdraft

    public CheckingAccount(String accountNumber, String accountHolderName, double overdraftLimit) {
        super(accountNumber, accountHolderName); // Call the superclass constructor
        this.overdraftLimit = overdraftLimit; // Set overdraft limit
    }

    @Override
    public void deposit(double amount) {
        balance += amount; // Increase balance by the deposit amount
    }

    @Override
    public void withdraw(double amount) throws InsufficientFundsException {
        // Check if the withdrawal is within the overdraft limit
        if (balance + overdraftLimit < amount) {
            throw new InsufficientFundsException("Insufficient funds for withdrawal."); // Throw exception if not enough funds
        }
        balance -= amount; // Decrease balance by the withdrawal amount
    }
}