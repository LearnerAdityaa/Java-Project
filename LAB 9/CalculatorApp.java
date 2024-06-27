import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CalculatorApp implements ActionListener {
    JFrame frame;
    JTextField textfield;
    JButton[] numberButtons = new JButton[10];
    JButton[] functionButtons = new JButton[9];
    JButton addButton, subButton, mulButton, divButton,
            decButton, equButton, delButton, clrButton, negButton;
    JPanel panel;
    Font myFont = new Font("Ink Free", Font.BOLD, 30);
    double num1 = 0, num2 = 0, result = 0;
    char operator;

    // Constructor
    CalculatorApp() {
        frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 600);
        frame.setLayout(null);

        // Text field setup
        textfield = new JTextField();
        textfield.setBounds(50, 25, 375, 50);
        textfield.setFont(myFont);
        textfield.setEditable(false);
        frame.add(textfield);

        // Initialize function buttons
        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("*");
        divButton = new JButton("/");
        decButton = new JButton(".");
        equButton = new JButton("=");
        delButton = new JButton("D");
        clrButton = new JButton("C");
        negButton = new JButton("(-)");

        // Assign function buttons to array
        functionButtons[0] = addButton;
        functionButtons[1] = subButton;
        functionButtons[2] = mulButton;
        functionButtons[3] = divButton;
        functionButtons[4] = decButton;
        functionButtons[5] = equButton;
        functionButtons[6] = delButton;
        functionButtons[7] = clrButton;
        functionButtons[8] = negButton;

        // Add action listeners and style to function buttons
        for (JButton button : functionButtons) {
            button.addActionListener(this);
            button.setFont(myFont);
            button.setFocusable(false);
        }

        // Number buttons setup
        for (int i = 0; i < 10; i++) {
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].setFont(myFont);
            numberButtons[i].setFocusable(false);
            numberButtons[i].addActionListener(this);
        }

        // Set bounds for special buttons
        negButton.setBounds(50, 412, 80, 50);
        delButton.setBounds(195, 412, 80, 50);
        clrButton.setBounds(340, 412, 80, 50);
        negButton.setBackground(Color.YELLOW);
        delButton.setBackground(Color.LIGHT_GRAY);
        clrButton.setBackground(Color.RED);

        // Add special buttons to frame
        frame.add(negButton);
        frame.add(delButton);
        frame.add(clrButton);

        // Panel setup
        panel = new JPanel();
        panel.setBounds(50, 100, 370, 300);
        panel.setLayout(new GridLayout(4, 4, 10, 10));

        // Add buttons to panel
        // row 1
        panel.add(numberButtons[1]);
        panel.add(numberButtons[2]);
        panel.add(numberButtons[3]);
        panel.add(addButton);
        // row 2
        panel.add(numberButtons[4]);
        panel.add(numberButtons[5]);
        panel.add(numberButtons[6]);
        panel.add(subButton);
        // row 3
        panel.add(numberButtons[7]);
        panel.add(numberButtons[8]);
        panel.add(numberButtons[9]);
        panel.add(mulButton);
        // row 4
        panel.add(decButton);
        panel.add(numberButtons[0]);
        panel.add(equButton);
        panel.add(divButton);

        // Add panel to frame
        equButton.setBackground(Color.GREEN);
        frame.add(panel);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new CalculatorApp();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < 10; i++) {
            if (e.getSource() == numberButtons[i]) {
                textfield.setText(textfield.getText().concat(String.valueOf(i)));
            }
        }

        if (e.getSource() == decButton) {
            textfield.setText(textfield.getText().concat("."));
        }

        try {
            if (e.getSource() == addButton) {
                num1 = Double.parseDouble(textfield.getText());
                operator = '+';
                textfield.setText("");
            } else if (e.getSource() == subButton) {
                num1 = Double.parseDouble(textfield.getText());
                operator = '-';
                textfield.setText("");
            } else if (e.getSource() == mulButton) {
                num1 = Double.parseDouble(textfield.getText());
                operator = '*';
                textfield.setText("");
            } else if (e.getSource() == divButton) {
                num1 = Double.parseDouble(textfield.getText());
                operator = '/';
                textfield.setText("");
            } else if (e.getSource() == equButton) {
                num2 = Double.parseDouble(textfield.getText());
                switch (operator) {
                    case '+':
                        result = num1 + num2;
                        break;
                    case '-':
                        result = num1 - num2;
                        break;
                    case '*':
                        result = num1 * num2;
                        break;
                    case '/':
                        if (num2 != 0) {
                            result = num1 / num2;
                        } else {
                            textfield.setText("Error");
                            return;
                        }
                        break;
                }
                textfield.setText(String.valueOf(result));
                num1 = result;
            }
        } catch (NumberFormatException ex) {
            textfield.setText("Error");
        }

        if (e.getSource() == clrButton) {
            textfield.setText("");
        }

        if (e.getSource() == delButton) {
            String string = textfield.getText();
            textfield.setText("");
            if (string.length() > 0) {
                textfield.setText(string.substring(0, string.length() - 1));
            }
        }

        try {
            if (e.getSource() == negButton) {
                double temp = Double.parseDouble(textfield.getText());
                temp *= -1;
                textfield.setText(String.valueOf(temp));
            }
        } catch (NumberFormatException ex) {
            textfield.setText("Error");
        }
    }
}
