import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CombinedDemo {
    private JFrame mainFrame;

    public CombinedDemo() {
        mainFrame = new JFrame("Best Case Scenario: Combined Demo");
        mainFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        mainFrame.setSize(700, 500);
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setLayout(new BorderLayout(10, 10));

        // --- Presenter 1 & 2: Event Handling & ActionListener (Top Panel) ---
        // Demonstrates Event Source, Event Object, Event Listener, and ActionListener
        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 15));
        topPanel.setBorder(BorderFactory.createTitledBorder("Action & Input Handling"));
        
        JLabel inputLabel = new JLabel("Enter your name:");
        JTextField nameField = new JTextField(15);
        JButton submitButton = new JButton("Submit");
        
        submitButton.addActionListener(e -> {
            String name = nameField.getText();
            JOptionPane.showMessageDialog(mainFrame, "Hello, " + name + "! Event handled successfully.");
        });
        
        // This button demonstrates the getActionCommand() method
        JButton logButton = new JButton("Log");
        logButton.setActionCommand("log_event");
        logButton.addActionListener(e -> {
            if ("log_event".equals(e.getActionCommand())) {
                System.out.println("Log button was clicked.");
            }
        });

        topPanel.add(inputLabel);
        topPanel.add(nameField);
        topPanel.add(submitButton);
        topPanel.add(logButton);
        mainFrame.add(topPanel, BorderLayout.NORTH);

        // --- Presenter 3: Mouse & Keyboard Events (Center Panel) ---
        // Demonstrates MouseListener and KeyListener on a single panel
        JPanel centerPanel = new JPanel(new BorderLayout());
        centerPanel.setBorder(BorderFactory.createTitledBorder("Mouse & Keyboard Interactions"));
        
        JTextArea eventLogArea = new JTextArea(10, 40);
        eventLogArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(eventLogArea);

        // Code from the slides, demonstrating MouseAdapter
        JPanel interactionPanel = new JPanel();
        interactionPanel.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        JLabel interactionLabel = new JLabel("Click or press keys here.");
        interactionPanel.add(interactionLabel);

        interactionPanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                eventLogArea.append("Mouse clicked at (" + e.getX() + ", " + e.getY() + ")\n");
            }
        });

        // Code from the slides, demonstrating KeyAdapter
        interactionPanel.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                eventLogArea.append("Key Typed: " + e.getKeyChar() + "\n");
            }
        });
        
        // Ensure the panel can receive keyboard focus
        interactionPanel.setFocusable(true);
        interactionPanel.requestFocusInWindow();
        
        centerPanel.add(interactionPanel, BorderLayout.NORTH);
        centerPanel.add(scrollPane, BorderLayout.CENTER);
        mainFrame.add(centerPanel, BorderLayout.CENTER);
        
        // --- Presenter 4: Advanced Listeners (Bottom Panel) ---
        // Demonstrates FocusListener
        JPanel bottomPanel = new JPanel();
        bottomPanel.setBorder(BorderFactory.createTitledBorder("Focus & Window Events"));
        
        JTextField focusField = new JTextField(15);
        JLabel focusStatus = new JLabel("Click me to see focus events.");
        
        // Code from the slides, using FocusAdapter
        focusField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                focusStatus.setText("Focus Gained!");
            }
            @Override
            public void focusLost(FocusEvent e) {
                focusStatus.setText("Focus Lost!");
            }
        });
        
        bottomPanel.add(focusField);
        bottomPanel.add(focusStatus);
        mainFrame.add(bottomPanel, BorderLayout.SOUTH);

        // Code from the slides, demonstrating WindowAdapter
        mainFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                int result = JOptionPane.showConfirmDialog(mainFrame, "Exit the combined demo?", "Confirm", JOptionPane.YES_NO_OPTION);
                if (result == JOptionPane.YES_OPTION) {
                    mainFrame.dispose();
                }
            }
        });

        mainFrame.setVisible(true);
    }
}
