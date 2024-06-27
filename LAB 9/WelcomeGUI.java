import javax.swing.*;
public class WelcomeGUI
{
    public static void main(String[] args) {
        JFrame frame = new JFrame("Welcome");
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500,500);
        JLabel label1 = new JLabel("Welcome to Java Program");
        label1.setBounds(100,100,200,100);
        frame.add(label1);

    }
}