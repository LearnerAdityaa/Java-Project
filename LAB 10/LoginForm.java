import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginForm extends JFrame {
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton;
    private JLabel statusLabel;

    public LoginForm() {
        setTitle("Login Form");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        JLabel usernameLabel = new JLabel("Username:");
        usernameLabel.setBounds(10, 30, 80, 25);
        add(usernameLabel);

        usernameField = new JTextField(20);
        usernameField.setBounds(100, 30, 165, 25);
        add(usernameField);

        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(10, 70, 80, 25);
        add(passwordLabel);

        passwordField = new JPasswordField(20);
        passwordField.setBounds(100, 70, 165, 25);
        add(passwordField);

        loginButton = new JButton("Login");
        loginButton.setBounds(10, 110, 80, 25);
        add(loginButton);

        statusLabel = new JLabel("");
        statusLabel.setBounds(100, 110, 165, 25);
        add(statusLabel);

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());

                UserAuthentication auth = new UserAuthentication();
                if (auth.verifyCredentials(username, password)) {
                    statusLabel.setText("Login successful!");
                } else {
                    statusLabel.setText("Invalid credentials.");
                }
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new LoginForm().setVisible(true);
            }
        });
    }
}
