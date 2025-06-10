import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// this class is used to connect my app to the SQLite database
public class DBConnection {

    // this is the path where my database file is saved on my computer
    // make sure the path is correct, or it won't connect
    private static final String DB_URL = "jdbc:sqlite:C:\\Users\\pc\\OneDrive\\Documents\\Desktop\\Database\\attendance.db"
            ;


    // this method tries to connect to the database and returns the connection
    public static Connection connect() {
        Connection conn = null;
        try {
            // try to connect to the database using the URL above
            conn = DriverManager.getConnection(DB_URL);
            System.out.println(" Successfully connected to the database!");
        } catch (SQLException e) {
            // if it can't connect, this will show an error
            System.out.println(" Oops! Failed to connect to the database: " + e.getMessage());
        }
        return conn;
    }
}
