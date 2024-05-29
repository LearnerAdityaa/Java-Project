import javax.swing.*;


public class StdRegistration {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Registration Form");
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setSize(500,500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JLabel name= new JLabel("Name:");
        JLabel phone = new JLabel("Phone:");
        JLabel password = new JLabel("Password:");
        JLabel repassword = new JLabel("Re-Password:");
        JLabel gender = new JLabel("Gender:");
        JLabel education = new JLabel("Education:");
        JButton submit = new JButton("Submit");
        JTextField nameT= new JTextField(50);
        JTextField phoneT = new JTextField(10);
        JTextField passwordT = new JTextField(30);
        JTextField repasswordT = new JTextField(30);
        JRadioButton gender1 = new JRadioButton("Male");
        JRadioButton gender2 = new JRadioButton("Female");
        JCheckBox education1 = new JCheckBox("+2");
        JCheckBox education2 = new JCheckBox("Bachelor");
        ButtonGroup lol = new ButtonGroup();
    JPanel p1=new JPanel();
       lol.add(gender1);
       lol.add(gender2);
        p1.add(gender1);
        p1.add(gender2);
       frame.getContentPane().add(p1);
       gender1.setFocusable(false);
       gender2.setFocusable(false);
    //    frame.setFocusable(false);
        frame.add(phone);
        frame.add(password);
        frame.add(repassword);
        frame.add(gender);
        frame.add(education);
        frame.add(submit);
        frame.add(phoneT);
        frame.add(passwordT);
        frame.add(repasswordT);
        frame.add(gender1);
        frame.add(gender2);
        frame.add(education1);
        frame.add(education2);
        frame.add(name);
        frame.add(nameT);
        //positioning
        name.setBounds(50,30,50,30);
        nameT.setBounds(100,30,150,30);
        phone.setBounds(50,70,50,30);
        phoneT.setBounds(100,70,150,30);
        password.setBounds(50,120,120,30);
        passwordT.setBounds(130,120,100,30);
        repassword.setBounds(50,170,100,30);
        repasswordT.setBounds(130,170,100,30);
        gender.setBounds(50,220,50,30);
        gender1.setBounds(100,220,80,30);
        gender2.setBounds(180,220,80,30);
        education.setBounds(50,270,80,30);
        education1.setBounds(120,270,80,30);
        education2.setBounds(180,270,80,30);
        submit.setBounds(50,320,90,30);
    
      
        


    }
    
}
