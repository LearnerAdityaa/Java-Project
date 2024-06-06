
import javax.swing.*;


import java.awt.*;
import java.awt.event.*;

class ChangeFrame implements ActionListener
{
    JFrame f1,f2;
    JLabel username1,password1;
    JTextField t1,t2;
    JButton b1,b2;
    ChangeFrame()
    {
        f1= new JFrame("Login Form");
        f2= new JFrame("Welcome Page");
        f1.setLayout(null);
        f1.setSize(1000,1000);
        f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f2.setLayout(null);
        f2.setSize(1000,1000);
        f2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        t1=new JTextField();
        t2=new JTextField();
        username1=new JLabel("username");
        password1= new JLabel("password");
        b1=new JButton("Login");
        b2=new JButton("Logout");
        username1.setBounds(50,30,80,50);
        password1.setBounds(50,90,80,50);
        t1.setBounds(200,30,100,50);
        t2.setBounds(200,90,100,50);
        b1.setBounds(80,180,80,50);
        b2.setBounds(80,180,80,50);
        f1.add(username1);
        f1.add(password1);
        f1.add(t1);
        f1.add(t2);
        f1.add(b1);

        f2.add(username1);
        f2.add(password1);
        f2.add(t2);
        f2.add(t1);
        f2.add(b2);
        f1.setVisible(true);
        
    }
 public static void main(String[] args) {
    ChangeFrame obj = new ChangeFrame();
 }
 public void actionPerformed(ActionEvent e)
 {

 }
}