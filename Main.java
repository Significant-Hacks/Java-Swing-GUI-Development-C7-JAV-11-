import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            // Create the main frame for the entire application
            JFrame mainFrame = new JFrame("Group 4: Event Handling Demo");
            mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            mainFrame.setSize(600, 400);
            mainFrame.setLocationRelativeTo(null);
            mainFrame.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));

            // Create the main menu panel
            JPanel menuPanel = new JPanel();
            menuPanel.setLayout(new GridLayout(7, 1, 10, 10));

            // Create and add buttons for each presenter's demo
            JButton presenter1Button = new JButton("Presenter 1: Event Architecture Demo");
            presenter1Button.addActionListener(e -> new Presenter1Demo());
            menuPanel.add(presenter1Button);

            JButton presenter2Button = new JButton("Presenter 2: ActionListener Demo");
            presenter2Button.addActionListener(e -> new Presenter2Demo());
            menuPanel.add(presenter2Button);

            JButton presenter3Button = new JButton("Presenter 3: Mouse & Key Listeners Demo");
            presenter3Button.addActionListener(e -> new Presenter3Demo());
            menuPanel.add(presenter3Button);

            JButton presenter4Button = new JButton("Presenter 4: Advanced Listeners Demo");
            presenter4Button.addActionListener(e -> new Presenter4Demo());
            menuPanel.add(presenter4Button);

            JButton bestCaseButton = new JButton("Best Case Scenario: Combined Demo");
            bestCaseButton.addActionListener(e -> new CombinedDemo());
            menuPanel.add(bestCaseButton);
            
            // Adding a placeholder button for the lab/challenge exercise
            JButton labChallengeButton = new JButton("Lab/Challenge Exercise");
            labChallengeButton.addActionListener(e -> JOptionPane.showMessageDialog(mainFrame, "This button would launch the lab/challenge exercise."));
            menuPanel.add(labChallengeButton);

            JButton exitButton = new JButton("Exit");
            exitButton.addActionListener(e -> mainFrame.dispose());
            menuPanel.add(exitButton);

            mainFrame.add(menuPanel);
            mainFrame.setVisible(true);
        });
    }
}
