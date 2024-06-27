import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class Calculator {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Calculator");
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500,500);
        JLabel label1 = new JLabel("Value:");
        JLabel label2 = new JLabel("Value:");
        JLabel result = new JLabel("Result:");
        JButton add = new JButton("+");
        JButton sub = new JButton("-");
        JButton mux= new JButton("*");
        JButton div = new JButton("/");
        JTextField value1T = new JTextField(10);
        JTextField value2T = new JTextField(10);
        JTextField resultT = new JTextField(10);
        frame.add(label1);
        frame.add(label2);
        frame.add(result);
        frame.add(value1T);
        frame.add(value2T);
        frame.add(add);
        frame.add(sub);
        frame.add(mux);
        frame.add(div);
        frame.add(resultT);
        label1.setBounds(50,70,90,30);
        value1T.setBounds(100,70,100,30);
        label2.setBounds(50,120,90,30);
        value2T.setBounds(100,120,100,30);
        result.setBounds(50,170,90,30);
        resultT.setBounds(100,170,100,30);
        add.setBounds(50,220,50,30);
        sub.setBounds(100,220,50,30);
        mux.setBounds(150,220,50,30);
        div.setBounds(200,220,50,30);

        add.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                int a = Integer.parseInt(value1T.getText());
                int b = Integer.parseInt(value2T.getText());
                String sum = Integer.toString(a+b);
                resultT.setText(sum);

            }
        });
        sub.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                int a = Integer.parseInt(value1T.getText());
                int b = Integer.parseInt(value2T.getText());
                String sub = Integer.toString(a-b);
                resultT.setText(sub);

            }
        });
        mux.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                int a = Integer.parseInt(value1T.getText());
                int b = Integer.parseInt(value2T.getText());
                String mux = Integer.toString(a*b);
                resultT.setText(mux);

            }
        });
        div.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                int a = Integer.parseInt(value1T.getText());
                int b = Integer.parseInt(value2T.getText());
                String div = Integer.toString(a/b);
                resultT.setText(div);

            }
        });



    }
}
