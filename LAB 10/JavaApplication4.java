package javaapplication4;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class JavaApplication4 extends JFrame {
    private JTable table;
    private DefaultTableModel tableModel;
    private JTextField questionField;
    private JTextField answerField;

    private static final String URL = "jdbc:mysql://localhost:3306/qa_db";
    private static final String USER = "root";  // Default user
    private static final String PASSWORD = "";  // Default password (blank)

    public JavaApplication4() {
        setTitle("Questions and Answers");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        tableModel = new DefaultTableModel(new Object[]{"Question", "Answer"}, 0);
        table = new JTable(tableModel);

        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER);

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(3, 2));

        inputPanel.add(new JLabel("Question:"));
        questionField = new JTextField();
        inputPanel.add(questionField);

        inputPanel.add(new JLabel("Answer:"));
        answerField = new JTextField();
        inputPanel.add(answerField);

        JButton addButton = new JButton("Add QA");
        inputPanel.add(addButton);
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addQA();
            }
        });

        add(inputPanel, BorderLayout.SOUTH);
        loadData();
    }

    private void loadData() {
        String sql = "SELECT id, question, answer FROM qa";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                tableModel.addRow(new Object[]{rs.getString("question"), rs.getString("answer")});
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void addQA() {
        String question = questionField.getText();
        String answer = answerField.getText();

        if (!question.isEmpty() && !answer.isEmpty()) {
            String sql = "INSERT INTO qa(question, answer) VALUES(?, ?)";
            try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
                 PreparedStatement pstmt = conn.prepareStatement(sql)) {

                pstmt.setString(1, question);
                pstmt.setString(2, answer);
                pstmt.executeUpdate();

                tableModel.addRow(new Object[]{question, answer});
                questionField.setText("");
                answerField.setText("");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            JOptionPane.showMessageDialog(this, "Please enter both a question and an answer.", "Input Error", JOptionPane.WARNING_MESSAGE);
        }
    }

    public static void main(String[] args) {
//        SwingUtilities.invokeLater(() -> {
            JavaApplication4 app = new JavaApplication4();
            app.setVisible(true);
//        });
 }
}
