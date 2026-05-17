import javax.swing.*;

// Main class to run the ATM Management System
public class ATMManagementSystem {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ATM atm = new ATM(); // Create an instance of ATM
            atm.createAndShowGUI(); // Create and show the ATM GUI
        });
    }
}