import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Presenter2Demo {
    public Presenter2Demo() {
        JFrame frame = new JFrame("Presenter 2: ActionListener Demo");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(500, 400);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new GridLayout(3, 1, 10, 10));

        // Demoing button clicks with ActionListener
        JPanel buttonPanel = new JPanel();
        buttonPanel.setBorder(BorderFactory.createTitledBorder("Button Action Demo"));
        
        JButton showMessageButton = new JButton("Show Message");
        JButton changeColorButton = new JButton("Change BG Color");

        // The ActionListener is added to the button
        showMessageButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // This is where the code from the slide would go
                JOptionPane.showMessageDialog(frame, "You clicked the Show Message button!");
            }
        });

        // Demonstrating getActionCommand()
        changeColorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if ("Change BG Color".equals(e.getActionCommand())) {
                    buttonPanel.setBackground(new Color((int)(Math.random() * 255), (int)(Math.random() * 255), (int)(Math.random() * 255)));
                }
            }
        });

        buttonPanel.add(showMessageButton);
        buttonPanel.add(changeColorButton);
        frame.add(buttonPanel);
        
        // Demoing JTextField with ActionListener
        JPanel textPanel = new JPanel();
        textPanel.setBorder(BorderFactory.createTitledBorder("Text Field Action Demo"));
        
        JTextField textField = new JTextField(20);
        JLabel resultLabel = new JLabel("Enter text and press Enter.");
        
        textField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String enteredText = textField.getText();
                resultLabel.setText("You entered: " + enteredText);
                textField.setText(""); // Clear the text field
            }
        });
        
        textPanel.add(textField);
        textPanel.add(resultLabel);
        frame.add(textPanel);

        // Demonstrating a long task (this will freeze the GUI, which is the point for the demo)
        JPanel freezePanel = new JPanel();
        freezePanel.setBorder(BorderFactory.createTitledBorder("EDT Blocking Demo (DO NOT USE!)"));
        JButton freezeButton = new JButton("Freeze GUI for 5s");
        freezeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    // This is the code from the slide that shows what NOT to do
                    Thread.sleep(5000); 
                    JOptionPane.showMessageDialog(frame, "GUI Unfrozen!");
                } catch (InterruptedException ex) {
                    Thread.currentThread().interrupt();
                }
            }
        });
        freezePanel.add(freezeButton);
        frame.add(freezePanel);

        frame.setVisible(true);
    }
}
