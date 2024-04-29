import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import java.sql.*;

public class M06Ch34_01GUI extends Application {
    // JDBC URL, username, and password of MySQL server
    private static final String URL = "jdbc:mysql://localhost:0000/database_name";
    private static final String USER = "username";
    private static final String PASSWORD = "password";

    private Connection connection;
    private TextField idField; // Declaring idField as a class member

    @Override
    public void start(Stage primaryStage) {
        try {
            // Connect to MySQL database
            connection = DriverManager.getConnection(URL, USER, PASSWORD);

            // Create UI components
            Label idLabel = new Label("ID:");
            idField = new TextField(); // Initialize idField here
            Button viewButton = new Button("View");
            Button insertButton = new Button("Insert");
            Button updateButton = new Button("Update");

            // GridPane layout
            GridPane gridPane = new GridPane();
            gridPane.setPadding(new Insets(20));
            gridPane.setHgap(10);
            gridPane.setVgap(10);
            gridPane.add(idLabel, 0, 0);
            gridPane.add(idField, 1, 0);
            gridPane.add(viewButton, 0, 1);
            gridPane.add(insertButton, 1, 1);
            gridPane.add(updateButton, 2, 1);

            // View button action
            viewButton.setOnAction(event -> {
                String id = idField.getText().trim();
                if (!id.isEmpty()) {
                    viewRecord(id);
                } else {
                    showAlert(Alert.AlertType.WARNING, "Error", "Please enter an ID.");
                }
            });

            // Insert button action
            insertButton.setOnAction(event -> {
                insertRecord();
            });

            // Update button action
            updateButton.setOnAction(event -> {
                updateRecord();
            });

            // Set up the scene and show the stage
            Scene scene = new Scene(gridPane, 400, 150);
            primaryStage.setTitle("Staff Database Manager");
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Method to view record with specified ID
    private void viewRecord(String id) {
        try {
            // Query to retrieve record
            String query = "SELECT * FROM Staff WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, id);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                // Display record details
                String lastName = resultSet.getString("lastName");
                String firstName = resultSet.getString("firstName");
                String mi = resultSet.getString("mi");
                String address = resultSet.getString("address");
                String city = resultSet.getString("city");
                String state = resultSet.getString("state");
                String telephone = resultSet.getString("telephone");
                String email = resultSet.getString("email");

                String recordDetails = "Last Name: " + lastName + "\n" +
                        "First Name: " + firstName + "\n" +
                        "MI: " + mi + "\n" +
                        "Address: " + address + "\n" +
                        "City: " + city + "\n" +
                        "State: " + state + "\n" +
                        "Telephone: " + telephone + "\n" +
                        "Email: " + email;

                showAlert(Alert.AlertType.INFORMATION, "Record Details", recordDetails);
            } else {
                showAlert(Alert.AlertType.WARNING, "Error", "Record with ID '" + id + "' not found.");
            }

            // Close resources
            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Method to insert a new record
    private void insertRecord() {
        try {
            // Create a new record based on user input
            String id = generateID();
            String lastName = "NewLastName";
            String firstName = "NewFirstName";
            String mi = "";
            String address = "NewAddress";
            String city = "NewCity";
            String state = "NY";
            String telephone = "1234567890";
            String email = "new@example.com";

            // Insert the new record into the database
            String query = "INSERT INTO Staff (id, lastName, firstName, mi, address, city, state, telephone, email) " +
                    "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, id);
            statement.setString(2, lastName);
            statement.setString(3, firstName);
            statement.setString(4, mi);
            statement.setString(5, address);
            statement.setString(6, city);
            statement.setString(7, state);
            statement.setString(8, telephone);
            statement.setString(9, email);

            int rowsAffected = statement.executeUpdate();
            if (rowsAffected > 0) {
                showAlert(Alert.AlertType.INFORMATION, "Success", "New record inserted with ID: " + id);
            } else {
                showAlert(Alert.AlertType.ERROR, "Error", "Failed to insert new record.");
            }

            // Close resources
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Method to update record for specified ID
    private void updateRecord() {
        try {
            // Update record based on user input
            String id = idField.getText().trim();
            String lastName = "UpdatedLastName";
            String firstName = "UpdatedFirstName";
            String mi = "U";
            String address = "UpdatedAddress";
            String city = "UpdatedCity";
            String state = "CA";
            String telephone = "9876543210";
            String email = "updated@example.com";

            // Update the record in the database
            String query = "UPDATE Staff SET lastName = ?, firstName = ?, mi = ?, address = ?, city = ?, " +
                    "state = ?, telephone = ?, email = ? WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, lastName);
            statement.setString(2, firstName);
            statement.setString(3, mi);
            statement.setString(4, address);
            statement.setString(5, city);
            statement.setString(6, state);
            statement.setString(7, telephone);
            statement.setString(8, email);
            statement.setString(9, id);

            int rowsAffected = statement.executeUpdate();
            if (rowsAffected > 0) {
                showAlert(Alert.AlertType.INFORMATION, "Success", "Record updated for ID: " + id);
            } else {
                showAlert(Alert.AlertType.ERROR, "Error", "Failed to update record.");
            }

            // Close resources
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Method to generate a unique ID (you may implement your own logic)
    private String generateID() {
        // This is just a placeholder implementation, you should replace it with your own logic
        return "ID" + System.currentTimeMillis();
    }

    // Method to display an alert
    private void showAlert(Alert.AlertType alertType, String title, String content) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }

    @Override
    public void stop() throws Exception {
        super.stop();
        if (connection != null) {
            connection.close();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
