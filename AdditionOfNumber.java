import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AdditionOfNumber {
    public static void main(String[] args) {
        JFrame formFrame = new JFrame("Form");
        formFrame.setSize(2000, 2000);
        formFrame.setLayout(null);
        formFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        formFrame.setVisible(true);

        JLabel valueOne = new JLabel("Value1:");
        JLabel valueTwo = new JLabel("Value2:");
        JLabel result = new JLabel("Result:");
        JTextField valueOneInput = new JTextField();
        JTextField valueTwoInput = new JTextField();
        JTextField resultInput = new JTextField();
        JButton callBtn = new JButton("Call");

        formFrame.add(valueOne);
        formFrame.add(valueTwo);
        formFrame.add(result);
        formFrame.add(valueOneInput);
        formFrame.add(valueTwoInput);
        formFrame.add(resultInput);
        formFrame.add(callBtn);

        valueOne.setBounds(50, 50, 70, 30);
        valueOneInput.setBounds(130, 50, 200, 30);

        valueTwo.setBounds(50, 100, 70, 30);
        valueTwoInput.setBounds(130, 100, 200, 30);

        result.setBounds(50, 150, 70, 30);
        resultInput.setBounds(130, 150, 200, 30);

        callBtn.setBounds(170, 200, 80, 30);

        // calling the constructor of ActionListener (interface)
        callBtn.addActionListener(new ActionListener() {
          @Override
            public void actionPerformed(ActionEvent e) {
                int a = Integer.parseInt(valueOneInput.getText());
                int b = Integer.parseInt(valueTwoInput.getText());
                String sum = Integer.toString(a + b);
                resultInput.setText(sum);
                // resultInput.setText(String.valueOf(a + b));
            }
        });

    }
}
