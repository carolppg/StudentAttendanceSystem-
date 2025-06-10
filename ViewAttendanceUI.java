import javax.swing.*;
import java.awt.*;

public class ViewAttendanceUI {

    public static void main(String[] args) {

        // this is the first screen users see when the app starts
        // it's like the home page with buttons to go to other parts


        JFrame window = new JFrame("Main Menu - Student Attendance App");
        window.setSize(400, 350);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setLocationRelativeTo(null); // center it on the screen

        // panel to hold all the buttons and text
        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        panel.setBackground(new Color(245, 245, 255)); // light background color

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(15, 15, 15, 15); // space around buttons
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // title at the top
        JLabel title = new JLabel("Student Attendance System");
        title.setFont(new Font("Segoe UI", Font.BOLD, 20));
        title.setHorizontalAlignment(SwingConstants.CENTER);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        panel.add(title, gbc);

        // Add Student button
        JButton addStudentBtn = new JButton("Add Student");
        addStudentBtn.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        gbc.gridy = 1;
        panel.add(addStudentBtn, gbc);

        // View Attendance button
        JButton viewAttendanceBtn = new JButton("View Attendance");
        viewAttendanceBtn.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        gbc.gridy = 2;
        panel.add(viewAttendanceBtn, gbc);

        // Exit button
        JButton exitBtn = new JButton("Exit");
        exitBtn.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        gbc.gridy = 3;
        panel.add(exitBtn, gbc);

        // footer with my name
        JLabel footer = new JLabel("Developed by Carol Emmanuel");
        footer.setHorizontalAlignment(SwingConstants.CENTER);
        footer.setFont(new Font("Segoe UI", Font.ITALIC, 12));
        footer.setForeground(new Color(120, 120, 120));
        gbc.gridy = 4;
        panel.add(footer, gbc);

        // what happens when the buttons are clicked
        addStudentBtn.addActionListener(e -> {
            // this opens the Add Student screen
            // make sure AddStudentUI.java is in the same src folder
            AddStudentUI.main(null);
        });

        viewAttendanceBtn.addActionListener(e -> {
            // this opens the View Attendance screen
            // make sure ViewAttendanceUI.java is in the same src folder
            ViewAttendanceUI.main(null);
        });

        exitBtn.addActionListener(e -> {
            // just closes the app
            window.dispose();
        });

        window.add(panel);
        window.setVisible(true);
    }
}
