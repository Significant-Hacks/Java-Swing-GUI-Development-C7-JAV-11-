

### Lab/Challenge Exercise: The Interactive Login Form 🔒

**Goal:** Take a basic, non-functional login form and make it interactive using the event handling concepts you've learned.

**Starter Code:**

```java
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
```

-----

### The Challenge Question

**Question:** Implement the following event handlers in the `ChallengeApp` class:

1.  **Button Click (`ActionListener`):** When the "Login" button is clicked, check if the username is "admin" and the password is "password". If the credentials are correct, change the `statusLabel` text to "Login Successful\!". Otherwise, set it to "Invalid Credentials.".
2.  **Keyboard Event (`KeyListener`):** Allow the user to press the **`Enter`** key in the password field to trigger the login check. This should perform the same action as clicking the "Login" button.
3.  **Focus Events (`FocusListener`):** When the `usernameField` gains focus, change its background color to yellow. When it loses focus, change the background color back to white.

-----

A few key points about GUI design, the starter code was designed that way on purpose.

The goal was to present the audience with a broken UI that they need to fix, even if the primary focus of the challenge is on the event handling logic.

### Why the UI is Distorted 🧐

The original code uses `new GridLayout(4, 1, 10, 10)`.

* `GridLayout(4, 1)` means there are four rows and only **one** column.
* The code adds 7 components (two labels, two text fields, an empty label, a button, and the status label).
* Since the layout is a single column, Swing places all the components one after the other, stacking them vertically. This is why the labels are not next to their corresponding text fields, creating a distorted appearance. 

### The Intent of the Starter Code

The purpose of the starter code is twofold:

1.  **To Focus on Event Handling:** The primary objective is for the audience to implement the event listeners. The broken UI ensures that they are not distracted by complex layout managers and can focus solely on the logic.
2.  **A "Hidden" Challenge:** The most successful students in the class will likely notice the UI distortion and fix it themselves as part of the challenge. The `Solution Code` you were given actually corrects this by changing the layout to `new GridLayout(4, 2, 10, 10)`. This demonstrates a deeper understanding of Swing and shows initiative.

By presenting the code this way, you can introduce a subtle "extra credit" task that encourages the audience to think beyond the explicit instructions. When you present, you can even point this out as a "bonus challenge" for them to solve.

The "fix" is to change the layout to `new GridLayout(4, 2, 10, 10)` to create a grid with four rows and two columns, which correctly aligns the labels and their text fields. 

-----

### The Solution with Explanation

**Notes for Presenters:** The goal is to show the audience that different user actions (a button click, a keyboard press, a mouse click to gain focus) can all be handled independently with the appropriate listener.

**Solution Code (`ChallengeApp.java`):**

```java
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
        setLayout(new GridLayout(4, 2, 10, 10)); // Changed layout for better structure
        setLocationRelativeTo(null);

        // Components
        usernameField = new JTextField(20);
        passwordField = new JPasswordField(20);
        loginButton = new JButton("Login");
        statusLabel = new JLabel("Enter your credentials", SwingConstants.CENTER);

        // Add components to the frame
        add(new JLabel("Username:", SwingConstants.RIGHT));
        add(usernameField);
        add(new JLabel("Password:", SwingConstants.RIGHT));
        add(passwordField);
        add(new JLabel("")); 
        add(loginButton);
        add(statusLabel); // Moved status label to the end for better flow

        // --- Presenter 2: ActionListener ---
        // This makes the button clickable and handles the login logic.
        loginButton.addActionListener(e -> performLogin());

        // --- Presenter 3: KeyListener ---
        // This adds a KeyListener to the password field. The login logic
        // is triggered when the Enter key is typed.
        passwordField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    performLogin();
                }
            }
        });

        // --- Presenter 4: FocusListener ---
        // This changes the background color of the username field
        // based on whether it has focus or not.
        usernameField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                usernameField.setBackground(Color.YELLOW);
            }
            @Override
            public void focusLost(FocusEvent e) {
                usernameField.setBackground(Color.WHITE);
            }
        });

        pack(); // Packs the components nicely
    }

    // A helper method to perform the login logic
    private void performLogin() {
        String username = usernameField.getText();
        char[] passwordChars = passwordField.getPassword();
        String password = new String(passwordChars);
        
        if (username.equals("admin") && password.equals("password")) {
            statusLabel.setText("Login Successful!");
            statusLabel.setForeground(new Color(34, 139, 34)); // Forest Green
        } else {
            statusLabel.setText("Invalid Credentials.");
            statusLabel.setForeground(Color.RED);
        }
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new ChallengeApp().setVisible(true);
        });
    }
}
```

-----

### Criticals/Notes for Attending Questions

  * **Question:** Why did you use `KeyListener`'s `keyPressed` method instead of `keyTyped`?

      * **Answer:** `keyTyped` is for Unicode characters. The `Enter` key is not a character, it's a "virtual key code". `keyPressed` or `keyReleased` are the correct methods to capture these types of non-character keys. This is a common debugging point, as a lot of beginners get stuck on this.

  *** 

  * **Question:** Why did you move the `statusLabel` to the bottom?

      * **Answer:** We changed the `GridLayout` to 4 rows and 2 columns for a better layout and moved the status label to the bottom. This is a good example of how to make a GUI more intuitive and aesthetically pleasing for the user.

  ***

  * **Question:** Why did you use `FocusAdapter` and `KeyAdapter` instead of the full interfaces?

      * **Answer:** As discussed in our presentation, adapter classes like `KeyAdapter` and `FocusAdapter` are convenience classes that provide empty implementations of the interface methods. This saves us from writing boilerplate code for methods we don't need, making our code cleaner and easier to read. For example, the `FocusListener` interface has two methods, but the `FocusAdapter` allows us to override just the ones we need (`focusGained` and `focusLost`).

  ***

  * **Question:** Why did you use `KeyListener`'s `keyPressed` method instead of `keyTyped`?
      * **Answer:** `keyTyped` is for Unicode characters. The `Enter` key is not a character; it's a "virtual key code." `keyPressed` or `keyReleased` are the correct methods to capture these types of non-character keys. This is a common debugging point, as many beginners get stuck on this.

  ***

  * **Question:** Why did you move the `statusLabel` to the bottom?
      * **Answer:** We changed the `GridLayout` to 4 rows and 2 columns for a better layout and moved the status label to the bottom. This is a good example of how to make a GUI more intuitive and aesthetically pleasing for the user.

  ***
 
  * **Question:** Why did you use `FocusAdapter` and `KeyAdapter` instead of the full interfaces?
      * **Answer:** As discussed in our presentation, adapter classes like `KeyAdapter` and `FocusAdapter` are convenience classes that provide empty implementations of the interface methods. This saves us from writing boilerplate code for methods we don't need, making our code cleaner and easier to read. For example, the `FocusListener` interface has two methods, but the `FocusAdapter` allows us to override just the ones we need (`focusGained` and `focusLost`). 

  ***

  * **Question:** Is it safe to store the password as a `String`?
      * **Answer:** That's a great question on best practices\! For this simple demo, we convert the password to a string for comparison. However, in a real application, you should handle the password as a `char[]` and compare it directly to prevent it from lingering in memory, which could pose a security risk. Here, we convert the password to a `String` for comparison, but in a real-world application, this is a **major security risk**. 

        Here's why:
        * `String` objects are **immutable**, meaning once created, they cannot be changed or destroyed until the garbage collector runs. This means the password data remains in memory for an unpredictable amount of time, making it vulnerable to being read by other processes or a memory dump.
        * A `char[]` (character array) is **mutable**. You can explicitly wipe the array clean after you're done with it (e.g., by filling it with zeros), ensuring the password is not left lingering in memory. This is the **correct and safer way** to handle passwords in a Java application.
