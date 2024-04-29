import java.sql.*;

public class M06Ch34_01 {
    // JDBC URL, username, and password of MySQL server
    private static final String URL = "jdbc:mysql://localhost:3306/your_database_name";
    private static final String USER = "your_username";
    private static final String PASSWORD = "your_password";

    public static void main(String[] args) {
        try {
            // Load MySQL JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Connect to MySQL database
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);

            // Create a statement
            Statement statement = connection.createStatement();

            // Create Staff table if not exists
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS Staff (id CHAR(9) NOT NULL, lastName VARCHAR(15), " +
                    "firstName VARCHAR(15), mi CHAR(1), address VARCHAR(20), city VARCHAR(20), state CHAR(2), " +
                    "telephone CHAR(10), email VARCHAR(40), PRIMARY KEY (id))");

            // View button: Display record with a specified ID
            String viewQuery = "SELECT * FROM Staff WHERE id = ?";
            PreparedStatement viewStatement = connection.prepareStatement(viewQuery);

            // Insert button: Insert a new record
            String insertQuery = "INSERT INTO Staff (id, lastName, firstName, mi, address, city, state, telephone, email) " +
                    "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement insertStatement = connection.prepareStatement(insertQuery);

            // Update button: Update record for the specified ID
            String updateQuery = "UPDATE Staff SET lastName = ?, firstName = ?, mi = ?, address = ?, city = ?, " +
                    "state = ?, telephone = ?, email = ? WHERE id = ?";
            PreparedStatement updateStatement = connection.prepareStatement(updateQuery);

            // Close resources
            connection.close();
            statement.close();
            viewStatement.close();
            insertStatement.close();
            updateStatement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
