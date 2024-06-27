//Lab 9 question no 5;
//package javaapplication3;

/**
 *
 * @author HP
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class JavaApplication3 extends JFrame {
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton;
    private JLabel statusLabel;

    public JavaApplication3() {
        // Create the UI components
        setTitle("Login Form");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        usernameField = new JTextField(15);
        passwordField = new JPasswordField(15);
        loginButton = new JButton("Login");
        statusLabel = new JLabel(" ");

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2));
        panel.add(new JLabel("Username:"));
        panel.add(usernameField);
        panel.add(new JLabel("Password:"));
        panel.add(passwordField);
        panel.add(statusLabel);
        panel.add(loginButton);

        add(panel);
        setVisible(true);

        // Add action listener for the login button
        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());
                if (validateLogin(username, password)) {
                    statusLabel.setText("Login successful!");
                } else {
                    statusLabel.setText("Invalid username or password.");
                }
            }
        });
    }

    private boolean validateLogin(String username, String password) {
        boolean isValid = false;
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            // Connect to the database
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/java_db", "root", " ");

            // Create the SQL query
            String sql = "SELECT * FROM students WHERE username = ? AND password = ?";
            statement = connection.prepareStatement(sql);
            statement.setString(1, username);
            statement.setString(2, password);

            // Execute the query
            resultSet = statement.executeQuery();

            // Check if any result is returned
            if (resultSet.next()) {
                isValid = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Close resources
            try {
                if (resultSet != null) resultSet.close();
                if (statement != null) statement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return isValid;
    }

    public static void main(String[] args) {
//        SwingUtilities.invokeLater(new Runnable() {
//            public void run() {
                new JavaApplication3();
//            }
//        });
    }
}

