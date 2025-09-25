import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ChallengeApp extends JFrame {
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton;
    private JLabel statusLabel;

    public ChallengeApp() {
        setTitle("Interactive Login");
        setSize(400, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(4, 1, 10, 10));
        setLocationRelativeTo(null);

        // Components
        statusLabel = new JLabel("Enter your credentials", SwingConstants.CENTER);
        usernameField = new JTextField(20);
        passwordField = new JPasswordField(20);
        loginButton = new JButton("Login");

        // Add components to the frame
        add(statusLabel);
        add(new JLabel("Username:", SwingConstants.RIGHT));
        add(usernameField);
        add(new JLabel("Password:", SwingConstants.RIGHT));
        add(passwordField);
        add(new JLabel("")); // Empty label for spacing
        add(loginButton);
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new ChallengeApp().setVisible(true);
        });
    }
}