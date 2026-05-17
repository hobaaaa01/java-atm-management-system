// Class representing a financial transaction
class Transaction {
    private String transactionID; // Unique transaction ID
    private String accountNumber; // Account number associated with the transaction
    private double amount; // Amount involved in the transaction
    private String type; // Type of transaction (e.g., Deposit, Withdrawal, Transfer)

    public Transaction(String transactionID, String accountNumber, double amount, String type) {
        this.transactionID = transactionID; // Set transaction ID
        this.accountNumber = accountNumber; // Set account number
        this.amount = amount; // Set transaction amount
        this.type = type; // Set transaction type
    }

    @Override
    public String toString() {
        return transactionID + "," + accountNumber + "," + amount + "," + type; // Format transaction details
    }

    public String getAccountNumber() {
        return accountNumber; // Return associated account number
    }
}