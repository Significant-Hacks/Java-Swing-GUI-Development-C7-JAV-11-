import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Presenter4Demo {
    public Presenter4Demo() {
        JFrame frame = new JFrame("Presenter 4: Advanced Listeners");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(500, 300);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));

        // FocusListener Demo
        JPanel focusPanel = new JPanel();
        focusPanel.setBorder(BorderFactory.createTitledBorder("FocusListener Demo"));
        
        JTextField emailField = new JTextField(20);
        JLabel focusLabel = new JLabel("Click into the text field.");

        // Code from the slide, using FocusAdapter
        emailField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                emailField.setBackground(Color.YELLOW);
                focusLabel.setText("Email field gained focus.");
            }
            @Override
            public void focusLost(FocusEvent e) {
                emailField.setBackground(Color.WHITE);
                focusLabel.setText("Email field lost focus.");
            }
        });
        
        focusPanel.add(emailField);
        focusPanel.add(focusLabel);
        frame.add(focusPanel);

        // WindowListener Demo
        // Code from the slide, using WindowAdapter
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                int result = JOptionPane.showConfirmDialog(
                    frame, "Are you sure you want to close this window?", "Confirm Exit", JOptionPane.YES_NO_OPTION);
                if (result == JOptionPane.YES_OPTION) {
                    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                } else {
                    // Do nothing, keep the window open
                    frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
                }
            }
        });

        frame.setVisible(true);
    }
}
