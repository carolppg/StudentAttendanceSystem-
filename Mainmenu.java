import javax.swing.*;
import java.awt.*;

public class Mainmenu {
    public static void main(String[] args) {

        // this is the window that opens my attendance screen
        JFrame window = new JFrame("View Attendance");
        window.setSize(750, 450);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setLocationRelativeTo(null); // center the window on the screen

        // this panel is like the background layout where I put everything
        JPanel mainPanel = new JPanel(new BorderLayout(10, 10));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        mainPanel.setBackground(new Color(240, 248, 255)); // soft light blue to make it look calm

        // this is the title at the top of the screen
        JLabel title = new JLabel("Attendance Records");
        title.setFont(new Font("Segoe UI", Font.BOLD, 24)); // big bold text
        title.setHorizontalAlignment(SwingConstants.CENTER); // center it
        title.setForeground(new Color(33, 37, 41)); // dark gray color for better contrast

        // these are the column names in the table
        String[] columns = {"Student ID", "Name", "Subject", "Date", "Status"};

        // I’m just adding fake data here for now to make sure the table works
        String[][] data = {
                {"101", "Alice", "Math", "2024-06-01", "Present"},
                {"102", "Bob", "Science", "2024-06-01", "Absent"},
                {"103", "Carol", "English", "2024-06-01", "Present"}
        };

        // the actual table that shows the data
        JTable table = new JTable(data, columns);
        table.setRowHeight(25); // space between rows
        table.setFont(new Font("Segoe UI", Font.PLAIN, 14)); // font for table data
        table.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 14)); // bold headers
        table.setGridColor(Color.LIGHT_GRAY); // light lines between cells

        // scroll bar in case the table gets long
        JScrollPane scrollPane = new JScrollPane(table);

        // back button to close the window or go back
        JButton backButton = new JButton("Back");
        backButton.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        backButton.setBackground(new Color(220, 220, 220)); // light gray
        backButton.setFocusPainted(false); // remove button border highlight
        backButton.addActionListener(e -> window.dispose()); // just closes the window

        // footer with my name at the bottom
        JLabel footer = new JLabel("Made by Carol Emmanuel");
        footer.setHorizontalAlignment(SwingConstants.CENTER);
        footer.setFont(new Font("Segoe UI", Font.ITALIC, 12));
        footer.setForeground(new Color(100, 100, 100)); // soft gray

        // bottomPanel holds both the button and the footer stacked vertically
        JPanel bottomPanel = new JPanel(new BorderLayout());
        bottomPanel.setOpaque(false); // make it match background
        bottomPanel.add(backButton, BorderLayout.NORTH);
        bottomPanel.add(footer, BorderLayout.SOUTH);

        // now I’m putting everything into the layout
        mainPanel.add(title, BorderLayout.NORTH);
        mainPanel.add(scrollPane, BorderLayout.CENTER);
        mainPanel.add(bottomPanel, BorderLayout.SOUTH);

        // add everything to the window and show it
        window.add(mainPanel);
        window.setVisible(true);
    }
}
