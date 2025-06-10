import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ViewAttendanceUI {

    public static void main(String[] args) {

        // this is the window that opens my attendance screen
        JFrame window = new JFrame("View Attendance");
        window.setSize(750, 450);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setLocationRelativeTo(null); // center the window

        // panel to hold everything
        JPanel mainPanel = new JPanel(new BorderLayout(10, 10));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        mainPanel.setBackground(new Color(240, 248, 255)); // soft light blue

        // title at the top
        JLabel title = new JLabel("Attendance Records");
        title.setFont(new Font("Segoe UI", Font.BOLD, 24));
        title.setHorizontalAlignment(SwingConstants.CENTER);
        title.setForeground(new Color(33, 37, 41));

        // this model holds the data from the database
        DefaultTableModel tableModel = new DefaultTableModel();
        tableModel.setColumnIdentifiers(new String[]{"ID", "Student ID", "Subject", "Date", "Status"});

        // connect to the database and get the data
        try {
            Connection conn = DBConnection.connect(); // use our connection method
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM attendance");

            while (rs.next()) {
                int id = rs.getInt("id");
                int studentId = rs.getInt("student_id");
                String subject = rs.getString("subject");
                String date = rs.getString("date");
                String status = rs.getString("status");

                // add each row to the table model
                tableModel.addRow(new Object[]{id, studentId, subject, date, status});
            }

            rs.close();
            stmt.close();
            conn.close(); // good habit to close everything
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "❌ Error loading data: " + e.getMessage());
        }

        // this is the table that shows the attendance data
        JTable table = new JTable(tableModel);
        table.setRowHeight(25);
        table.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        table.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 14));
        table.setGridColor(Color.LIGHT_GRAY);

        JScrollPane scrollPane = new JScrollPane(table);

        // back button
        JButton backButton = new JButton("Back");
        backButton.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        backButton.setBackground(new Color(220, 220, 220));
        backButton.setFocusPainted(false);
        backButton.addActionListener(e -> window.dispose());

        // footer with my name
        JLabel footer = new JLabel("Made by Carol Emmanuel");
        footer.setHorizontalAlignment(SwingConstants.CENTER);
        footer.setFont(new Font("Segoe UI", Font.ITALIC, 12));
        footer.setForeground(new Color(100, 100, 100));

        JPanel bottomPanel = new JPanel(new BorderLayout());
        bottomPanel.setOpaque(false);
        bottomPanel.add(backButton, BorderLayout.NORTH);
        bottomPanel.add(footer, BorderLayout.SOUTH);

        // putting everything together
        mainPanel.add(title, BorderLayout.NORTH);
        mainPanel.add(scrollPane, BorderLayout.CENTER);
        mainPanel.add(bottomPanel, BorderLayout.SOUTH);

        window.add(mainPanel);
        window.setVisible(true);
    }
}

