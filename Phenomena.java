import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Phenomena implements ActionListener 
{ 
    JFrame frame;
    TextField t;
    TextField t1;
    TextField r;
    JLabel l;
    JLabel l1;
    JLabel r1;
    JButton Call;

    // Constructor
    Phenomena()
    {
        frame = new JFrame("Calculation Phenomenon");
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 300);

        t = new TextField();
        t1 = new TextField();
        r = new TextField();
        l = new JLabel("Value 1");
        l1 = new JLabel("Value 2");
        r1 = new JLabel("Operation");

        Call = new JButton("Calculate");

        t.setBounds(120, 30, 100, 50);
        t1.setBounds(120, 90, 100, 50);
        r.setBounds(120, 150, 200, 50);
        l.setBounds(50, 30, 80, 30);
        l1.setBounds(50, 90, 80, 30);
        r1.setBounds(50, 150, 80, 30);
        Call.setBounds(120, 210, 100, 30);

       Call.addActionListener(this);

        frame.add(t);
        frame.add(t1);
        frame.add(r);
        frame.add(l);
        frame.add(l1);
        frame.add(r1);
        frame.add(Call);
        
        frame.setVisible(true);
    }

    public static void main(String[] args) 
    {
        Phenomena calc = new Phenomena();
    }

    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource() == Call)
        {
            String operation = r.getText();
            int v1 = Integer.parseInt(t.getText());
            int v2 = Integer.parseInt(t1.getText());

            int result = 0;
            boolean validOperation = true;

            switch (operation.toLowerCase()) {
                case "add":
                case "addition":
                case "sum":
                    result = v1 + v2;
                    break;
                case "subtract":
                case "subtraction":
                case "difference":
                    result = v1 - v2;
                    break;
                case "multiply":
                case "multiplication":
                case "product":
                    result = v1 * v2;
                    break;
                case "divide":
                case "division":
                    if (v2 != 0) {
                        result = v1 / v2;
                    } else {
                        r.setText("Cannot divide by zero");
                        validOperation = false;
                    }
                    break;
                default:
                    r.setText("Invalid operation");
                    validOperation = false;
                    break;
            }

            if (validOperation) {
                r.setText(String.valueOf(result));
                
            }
        }
    }
}
