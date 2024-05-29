import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.*;
import javax.swing.*;
public class SquareOfNumber {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Square of Number");
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setSize(500,500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JLabel label1 = new JLabel("Value:");
        JLabel label2 = new JLabel("Result:");
        JButton btn = new JButton("Calculate");
        JTextField text1 = new JTextField(10);
        JTextField text2 = new JTextField(10);
        
        frame.add(label1);
        frame.add(label2);
        frame.add(text1);
        frame.add(text2);
        frame.add(btn);
       
        label1.setBounds(80,50,70,30);
        text1.setBounds(120,50,100,30);
        label2.setBounds(80,90,100,30);
        text2.setBounds(120,90,100,30);
        btn.setBounds(120,125,90,30);

        //event listener
        btn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                int a = Integer.parseInt(text1.getText());
                String output = Integer.toString(a*a);
                text2.setText(output);
            }
            
        });
        
        
    }
}
