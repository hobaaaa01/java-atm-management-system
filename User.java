import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Class representing a bank user
class User {
    private String userID; // Unique user ID
    private String pin; // User's PIN
    private boolean locked; // Lock status of the account
    private List<Account> accounts; // List of accounts belonging to the user

    public User(String userID, String pin) {
        this.userID = userID;
        this.pin = pin;
        this.locked = false; // Default to unlocked
        this.accounts = new ArrayList<>(); // Initialize the accounts list
    }

    public String getUserID() {
        return userID; // Return user ID
    }

    public String getPIN() {
        return pin; // Return user's PIN
    }

    public boolean isLocked() {
        return locked; // Return lock status
    }

    public void resetPIN(String newPin) {
        this.pin = newPin; // Reset the user's PIN
    }

    public boolean authenticate(String pin) {
        return this.pin.equals(pin); // Check if the provided PIN matches
    }

    public List<Account> getAccounts() {
        return accounts; // Return the list of accounts
    }

    public void addAccount(Account account) {
        accounts.add(account); // Add a new account to the user's list
    }

    public void loadAccountsFromFile(String filePath) {
        try (Scanner fileScanner = new Scanner(new File(filePath))) {
            while (fileScanner.hasNextLine()) {
                String[] data = fileScanner.nextLine().split(",");
                String accountNumber = data[0];
                String accountHolderName = this.userID; // assuming account holder name is the same as userID
                // You can replace this with a specific way to determine the account holder's name
                Account account = new CheckingAccount(accountNumber, accountHolderName, 1000.0); // Example with overdraft
                accounts.add(account);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Account data file not found. No accounts loaded.");
        }
    }
}