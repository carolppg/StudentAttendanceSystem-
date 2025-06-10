import javax.swing.*;
import java.awt.*;

public class AddStudentUI {
    public static void main(String[] args) {

        // this is the window where i’ll add student info
        JFrame window = new JFrame("Add Student");
        window.setSize(400, 300);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setLocationRelativeTo(null); // center it

        // background panel to hold everything
        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout()); // lets me control spacing
        panel.setBackground(new Color(255, 255, 240)); // soft warm color

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10); // spacing between elements
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // title at the top
        JLabel title = new JLabel(" Add New Student");
        title.setFont(new Font("Segoe UI", Font.BOLD, 20));
        title.setHorizontalAlignment(SwingConstants.CENTER);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        panel.add(title, gbc);

        // name label and field
        gbc.gridwidth = 1;
        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(new JLabel("Name:"), gbc);

        gbc.gridx = 1;
        JTextField nameField = new JTextField(15);
        panel.add(nameField, gbc);

        // roll number
        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(new JLabel("Roll No:"), gbc);

        gbc.gridx = 1;
        JTextField rollField = new JTextField(15);
        panel.add(rollField, gbc);

        // class
        gbc.gridx = 0;
        gbc.gridy = 3;
        panel.add(new JLabel("Class:"), gbc);

        gbc.gridx = 1;
        JTextField classField = new JTextField(15);
        panel.add(classField, gbc);

        // add student button
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        JButton addButton = new JButton("Add Student");
        addButton.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        panel.add(addButton, gbc);

        // made-by label
        gbc.gridy = 5;
        JLabel footer = new JLabel("Attendance System");
        footer.setHorizontalAlignment(SwingConstants.CENTER);
        footer.setFont(new Font("Segoe UI", Font.ITALIC, 12));
        footer.setForeground(new Color(120, 120, 120));
        panel.add(footer, gbc);

        // what happens when the button is clicked
        addButton.addActionListener(e -> {
            String name = nameField.getText().trim();
            String roll = rollField.getText().trim();
            String className = classField.getText().trim();

            // simple check to make sure fields aren’t empty
            if (name.isEmpty() || roll.isEmpty() || className.isEmpty()) {
                JOptionPane.showMessageDialog(window, "Please fill all the fields!", "Input Error", JOptionPane.ERROR_MESSAGE);
            } else {
                // for now i just show a message (no database yet)
                JOptionPane.showMessageDialog(window, "Student added successfully!");
                nameField.setText("");
                rollField.setText("");
                classField.setText("");
            }
        });

        // add everything to the window
        window.add(panel);
        window.setVisible(true);
    }
}
