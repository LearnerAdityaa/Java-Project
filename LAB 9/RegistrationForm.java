package javamysqlconnect;

import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class RegistrationForm {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(CreateRegistrationForm::new);
    }
}

class CreateRegistrationForm extends JFrame implements ActionListener {
    JTextField userIdInput, nameInput, addressInput, phoneInput, genderInput, emailInput;
    JPasswordField passwordInput, confirmPasswordInput;
    JButton submitBtn, resetBtn;
    Connection connection;

    CreateRegistrationForm() {
        // Initialize and connect to the database
        try {
            String dbUrl = "jdbc:mysql://localhost:3306/bca_third_sem";
            String dbUsername = "root";
            String dbPassword = "";
            connection = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
            System.out.println("Connected With the database successfully");
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Database connection failed. Check console for details.", "Error", JOptionPane.ERROR_MESSAGE);
            return; // Exit if connection is not successful
        }

        // Create JFrame
        setTitle("Registration Form");
        setLayout(null);
        setSize(500, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create components
        userIdInput = new JTextField();
        nameInput = new JTextField();
        addressInput = new JTextField();
        phoneInput = new JTextField();
        genderInput = new JTextField();
        emailInput = new JTextField();
        passwordInput = new JPasswordField();
        confirmPasswordInput = new JPasswordField();

        submitBtn = new JButton("Submit");
        resetBtn = new JButton("Reset");

        submitBtn.addActionListener(this);
        resetBtn.addActionListener(this);

        // Position components
        addComponent("User ID:", userIdInput, 50);
        addComponent("Name:", nameInput, 100);
        addComponent("Address:", addressInput, 150);
        addComponent("Phone:", phoneInput, 200);
        addComponent("Gender:", genderInput, 250);
        addComponent("Email:", emailInput, 300);
        addComponent("Password:", passwordInput, 350);
        addComponent("Confirm Password:", confirmPasswordInput, 400);
        add(submitBtn).setBounds(100, 450, 100, 30);
        add(resetBtn).setBounds(250, 450, 100, 30);

        setVisible(true);
    }

    private void addComponent(String label, JComponent component, int y) {
        add(new JLabel(label)).setBounds(50, y, 150, 30);
        add(component).setBounds(200, y, 200, 30);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submitBtn) {
            handleSubmit();
        } else if (e.getSource() == resetBtn) {
            resetForm();
            JOptionPane.showMessageDialog(this, "Form has been reset.", "Info", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private void handleSubmit() {
        String userId = userIdInput.getText().trim();
        String name = nameInput.getText().trim();
        String address = addressInput.getText().trim();
        String phone = phoneInput.getText().trim();
        String gender = genderInput.getText().trim();
        String email = emailInput.getText().trim();
        String password = new String(passwordInput.getPassword()).trim();
        String confirmPassword = new String(confirmPasswordInput.getPassword()).trim();

        // Validate input fields
        if (userId.isEmpty()  name.isEmpty()  address.isEmpty() || phone.isEmpty()
                 gender.isEmpty()  email.isEmpty()  password.isEmpty()  confirmPassword.isEmpty()) {
            JOptionPane.showMessageDialog(this, "All fields are required.", "Validation Error", JOptionPane.ERROR_MESSAGE);
            return;
        }