import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Swap extends JFrame implements ActionListener {
     JButton button1;
     JButton button2;

    public Swap() {
        // Set the title of the JFrame
        setTitle("Swap Button Names");

        // Set the size of the JFrame
        setSize(300, 150);

        // Set the default close operation
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Set the layout manager
        setLayout(new FlowLayout());

        // Create two buttons
        button1 = new JButton("Button 1");
        button2 = new JButton("Button 2");

        // Add action listeners to the buttons
        button1.addActionListener(this);
        button2.addActionListener(this);

        // Add buttons to the JFrame
        add(button1);
        add(button2);

        // Make the JFrame visible
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Get the text of both buttons
        String text1 = button1.getText();
        String text2 = button2.getText();

        // Swap the text of the buttons
        button1.setText(text2);
        button2.setText(text1);
    }

    public static void main(String[] args) {
        // Create an instance of the SwapButtonNames class
        new Swap();
    }
}
