import javax.swing.*;
import java.awt.*;

public class MarkAttendanceUI {

    public static void main(String[] args) {

        // this screen is for marking attendance manually (no database yet)

        JFrame window = new JFrame("Mark Attendance");
        window.setSize(400, 400);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setLocationRelativeTo(null); // center the window

        // using panel to hold all the fields
        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        panel.setBackground(new Color(255, 254, 240)); // light warm yellowish background

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10); // space around fields
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // title at the top
        JLabel title = new JLabel("Mark Attendance");
        title.setFont(new Font("Segoe UI", Font.BOLD, 20));
        title.setHorizontalAlignment(SwingConstants.CENTER);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        panel.add(title, gbc);

        // roll number field
        gbc.gridwidth = 1;
        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(new JLabel("Roll No:"), gbc);

        gbc.gridx = 1;
        JTextField rollField = new JTextField(15);
        panel.add(rollField, gbc);

        // subject dropdown
        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(new JLabel("Subject:"), gbc);

        gbc.gridx = 1;
        String[] subjects = {"Math", "Science", "English", "History"};
        JComboBox<String> subjectBox = new JComboBox<>(subjects);
        panel.add(subjectBox, gbc);

        // date field
        gbc.gridx = 0;
        gbc.gridy = 3;
        panel.add(new JLabel("Date (yyyy-mm-dd):"), gbc);

        gbc.gridx = 1;
        JTextField dateField = new JTextField(15);
        panel.add(dateField, gbc);

        // radio buttons for attendance status
        gbc.gridx = 0;
        gbc.gridy = 4;
        panel.add(new JLabel("Status:"), gbc);

        gbc.gridx = 1;
        JPanel statusPanel = new JPanel();
        JRadioButton presentBtn = new JRadioButton("Present");
        JRadioButton absentBtn = new JRadioButton("Absent");
        ButtonGroup statusGroup = new ButtonGroup();
        statusGroup.add(presentBtn);
        statusGroup.add(absentBtn);
        statusPanel.add(presentBtn);
        statusPanel.add(absentBtn);
        panel.add(statusPanel, gbc);

        // submit button
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 2;
        JButton submitBtn = new JButton("Mark Attendance");
        submitBtn.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        panel.add(submitBtn, gbc);

        // footer with your name
        gbc.gridy = 6;
        JLabel footer = new JLabel("Created by Carol Emmanuel");
        footer.setHorizontalAlignment(SwingConstants.CENTER);
        footer.setFont(new Font("Segoe UI", Font.ITALIC, 12));
        footer.setForeground(new Color(100, 100, 100));
        panel.add(footer, gbc);

        // what happens when the button is clicked
        submitBtn.addActionListener(e -> {
            String roll = rollField.getText().trim();
            String subject = (String) subjectBox.getSelectedItem();
            String date = dateField.getText().trim();
            String status = presentBtn.isSelected() ? "Present" :
                    absentBtn.isSelected() ? "Absent" : "";

            if (roll.isEmpty() || date.isEmpty() || status.isEmpty()) {
                JOptionPane.showMessageDialog(window, "Please fill all fields!", "Missing Data", JOptionPane.ERROR_MESSAGE);
            } else {
                // just show a success message for now
                JOptionPane.showMessageDialog(window, "Attendance marked for Roll No: " + roll);
                // clear fields after submission
                rollField.setText("");
                dateField.setText("");
                statusGroup.clearSelection();
            }
        });

        window.add(panel);
        window.setVisible(true);
    }
}
