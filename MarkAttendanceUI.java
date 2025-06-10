import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MarkAttendanceUI {

    public static void main(String[] args) {

        // this is the window for marking attendance
        JFrame frame = new JFrame("Mark Attendance");
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null); // center it

        // this panel will hold the form inputs
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(6, 1, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        panel.setBackground(new Color(245, 255, 250));

        // inputs: student ID, subject, date, status
        JTextField studentIdField = new JTextField();
        JTextField subjectField = new JTextField();
        JTextField dateField = new JTextField();

        // status options (Present / Absent)
        String[] statusOptions = {"Present", "Absent"};
        JComboBox<String> statusCombo = new JComboBox<>(statusOptions);

        // label the fields
        panel.add(new JLabel("Enter Student ID:"));
        panel.add(studentIdField);

        panel.add(new JLabel("Enter Subject:"));
        panel.add(subjectField);

        panel.add(new JLabel("Enter Date (YYYY-MM-DD):"));
        panel.add(dateField);

        panel.add(new JLabel("Select Status:"));
        panel.add(statusCombo);

        // button to mark attendance
        JButton markBtn = new JButton("Mark Attendance");
        markBtn.setBackground(new Color(144, 238, 144));
        markBtn.setFocusPainted(false);

        // back button
        JButton backBtn = new JButton("Back");
        backBtn.addActionListener(e -> frame.dispose());

        // what happens when I click the "Mark Attendance" button
        markBtn.addActionListener(e -> {
            String studentId = studentIdField.getText().trim();
            String subject = subjectField.getText().trim();
            String date = dateField.getText().trim();
            String status = (String) statusCombo.getSelectedItem();

            // make sure nothing is empty
            if (studentId.isEmpty() || subject.isEmpty() || date.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "Please fill all the fields.");
                return;
            }

            // try to save it into the database
            try {
                Connection conn = DBConnection.connect();
                String sql = "INSERT INTO attendance (student_id, subject, date, status) VALUES (?, ?, ?, ?)";
                PreparedStatement pstmt = conn.prepareStatement(sql);
                pstmt.setInt(1, Integer.parseInt(studentId));
                pstmt.setString(2, subject);
                pstmt.setString(3, date);
                pstmt.setString(4, status);
                pstmt.executeUpdate();
                conn.close();

                JOptionPane.showMessageDialog(frame, " Attendance marked successfully!");
                studentIdField.setText("");
                subjectField.setText("");
                dateField.setText("");
                statusCombo.setSelectedIndex(0);

            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(frame, " Failed to mark attendance: " + ex.getMessage());
            } catch (NumberFormatException nfe) {
                JOptionPane.showMessageDialog(frame, "Student ID must be a number.");
            }
        });

        // add everything to the panel
        panel.add(markBtn);
        panel.add(backBtn);

        frame.add(panel);
        frame.setVisible(true);
    }
}
