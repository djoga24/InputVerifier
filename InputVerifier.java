import javax.swing.*;
import java.awt.*;

public class InputVerifier {
    // Declare instance variables for components used in the GUI

    private JFrame main_frame;
    private JLabel inputLabel;
    private JTextField inputField;
    private JButton verifyButton;
    private JButton quitButton;
    private JLabel resultLabel;

    public InputVerifier() {
        main_frame = new JFrame("Integer Input Verifier");

        // Create components needed in GUI
        inputLabel = new JLabel("Enter an integer:");
        inputField = new JTextField(9);
        verifyButton = new JButton("Verify");
        quitButton = new JButton("Quit");
        resultLabel = new JLabel("");

        // Add components to the frame
        JPanel panel = new JPanel();
        panel.add(inputLabel);
        panel.add(inputField);
        panel.add(verifyButton);
        panel.add(quitButton);
        panel.add(resultLabel);
        main_frame.add(panel);

        // Set frame properties
        main_frame.setSize(300, 120);
        main_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        main_frame.setLocationRelativeTo(null);
        main_frame.setResizable(false);
        main_frame.setVisible(true);

        // Add action listeners to buttons. Lambda functionns so that when the button is pressed, it will call the function.
        verifyButton.addActionListener(e -> checkInteger());
        // Disposes of frame when button clicked
        quitButton.addActionListener(e -> main_frame.dispose());
    }

    // Method that checks if the input is an integer when the verify button is clicked
    public void checkInteger() {
        String input = inputField.getText();
        try {
            // Parse input to integer
            int value = Integer.parseInt(input);
            // Display message if input is an integer
            resultLabel.setText(input + " is an integer.");
            inputField.setText("");
        } catch (NumberFormatException ex) {
            // Display message if input is not an integer
            JOptionPane.showMessageDialog(main_frame, input + " is not an integer");
            inputField.setText("");
            resultLabel.setText("");
        }
    }

    // Main method that runs the program
    public static void main(String[] args) {
        new InputVerifier();
    }
}