// Custom exception for insufficient funds during transactions
class InsufficientFundsException extends Exception {
    public InsufficientFundsException(String message) {
        super(message); // Pass the message to the superclass constructor
    }
}