import javax.swing.*;
import java.io.*;
import java.util.List;

// Class to manage admin functionalities
class Admin {
    private String adminID = "admin"; // Default admin ID
    private String adminPIN = "admin123"; // Default admin PIN

    // Authenticates admin credentials
    public boolean authenticate(String id, String pin) {
        return adminID.equals(id) && adminPIN.equals(pin);
    }

    // Creates a new user and saves to the user list and file
    public void createUser(List<User> users) {
        String userID = JOptionPane.showInputDialog("Enter new User ID:");
        String pin = JOptionPane.showInputDialog("Enter new User PIN:");
        User newUser = new User(userID, pin);
        users.add(newUser);
        saveUserToFile(newUser); // Save the new user to a file
        JOptionPane.showMessageDialog(null, "User created successfully.");
    }

    // Saves user information to a file
    private void saveUserToFile(User user) {
        try (PrintWriter writer = new PrintWriter(new FileWriter("users.txt", true))) {
            writer.println(user.getUserID() + "," + user.getPIN()); // Append user data
        } catch (IOException e) {
            System.out.println("Error saving user to file.");
        }
    }

    // Resets the PIN for an existing user
    public void resetUserPIN(List<User> users) {
        String userID = JOptionPane.showInputDialog("Enter User ID to reset PIN:");
        for (User user : users) {
            if (user.getUserID().equals(userID)) {
                String newPin = JOptionPane.showInputDialog("Enter new PIN:");
                user.resetPIN(newPin); // Reset the user's PIN
                JOptionPane.showMessageDialog(null, "PIN reset successfully.");
                return;
            }
        }
        JOptionPane.showMessageDialog(null, "User not found.");
    }
}