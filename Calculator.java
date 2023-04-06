import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculator {
    //Create instnace variables for all the GUI components
    private JFrame frame;
    private JLabel label1, label2, label3;
    private JTextField textField1, textField2;
    private JButton addButton, subButton,cancelButton;

    public Calculator() {
        // Create and configure the GUI components
        label1 = new JLabel("Enter number 1: ");
        textField1 = new JTextField(10);

        label2 = new JLabel("Enter number 2: ");
        textField2 = new JTextField(10);

        addButton = new JButton("Add");
        subButton = new JButton("Subtract");
        cancelButton = new JButton("Cancel");

        label3 = new JLabel("Result: ");

        // Add event listeners to the buttons using a lambda function so that when the button is pressed,a  function is called
        addButton.addActionListener(e -> performAddition());
        subButton.addActionListener(e -> performSubtraction());
        cancelButton.addActionListener(e ->  System.exit(0));

        // Create and configure the panel GUI compmonent
        JPanel panel = new JPanel(new GridLayout(3, 2));
        panel.add(label1);
        panel.add(textField1);
        panel.add(label2);
        panel.add(textField2);
        panel.add(addButton);
        panel.add(subButton);
        panel.add(cancelButton);

        // Create and configure the frame GUI compmonent
        frame = new JFrame("Simple Calculator");
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Position certain elements on the Frame
        frame.add(panel, BorderLayout.CENTER);
        frame.add(label3, BorderLayout.SOUTH);
        frame.add(cancelButton,BorderLayout.NORTH);
        frame.setVisible(true);
    }

        
    private void performAddition() {
        // Get the text from textField1 and textField2 and remove any leading or trailing whitespace
        String input1 = textField1.getText().trim();
        String input2 = textField2.getText().trim();
    
        // Check if both inputs are valid using the isValidInput() method down below
        if (isValidInput(input1) && isValidInput(input2)) {
            // Parse the input strings as doubles
            double num1 = Double.parseDouble(input1);
            double num2 = Double.parseDouble(input2);

            double result = num1 + num2;
            // Set the text of label3 to display the result with the answer rounded to 2 decimal places
            label3.setText("Result: " + String.format("%.2f", result));
        } else {
            // If either input is invalid, display an error message using the errorMessage() method
            errorMessage();
        }
    }
    private void performSubtraction() {
        // Get the text from textField1 and textField2 and remove any leading or trailing whitespace
        String input1 = textField1.getText().trim();
        String input2 = textField2.getText().trim();

        // Check if both inputs are valid using the isValidInput() method down below
        if (isValidInput(input1) && isValidInput(input2)) {

            // Parse the input strings as doubles
            double num1 = Double.parseDouble(input1);
            double num2 = Double.parseDouble(input2);
            double result = num1 - num2;

            // Set the text of label3 to display the result with the answer rounded to 2 decimal places
            label3.setText("Result: " + String.format("%.2f", result));

        } else {
            // If either input is invalid, display an error message using the errorMessage() method
            errorMessage();
        }
    }

    
    private boolean isValidInput(String input) {
         // expression to match the input string
        // \d+ represents one or more digit
        // \.\d+ represents a decimal point followed by one or more digits
        // ? indicates that the decimal part is optional
        // If the input matches the pattern, return true, otherwise return false
        return input.matches("\\d+(\\.\\d+)?");
    }

    private void errorMessage() {
        //Show error message dialog 
        JOptionPane.showMessageDialog(frame, "Please enter valid numbers!");

        //Clear the Screen
        textField1.setText("");
        textField2.setText("");
        label3.setText("Result: ");
    }

    public static void main(String[] args) {
        //In the main method, create  a Calculator object
        Calculator calculator = new Calculator();
    }
}

  