import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class M06Ch35_01 extends Application {
    private DBConnectionPanel connectionPanel;
    private Label resultLabel;

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Batch Update Comparison");

        connectionPanel = new DBConnectionPanel();

        Button connectButton = new Button("Connect to Database");
        connectButton.setOnAction(e -> connectButtonClicked());

        resultLabel = new Label();

        VBox root = new VBox(10);
        root.setPadding(new Insets(10));
        root.getChildren().addAll(connectionPanel, connectButton, resultLabel);

        primaryStage.setScene(new Scene(root, 400, 200));
        primaryStage.show();
    }

    private void connectButtonClicked() {
        try {
            Connection connection = connectionPanel.getConnection();
            if (connection != null) {
                long startTime = System.currentTimeMillis();
                insertRecords(connection, false);
                long endTime = System.currentTimeMillis();
                long durationWithoutBatch = endTime - startTime;

                startTime = System.currentTimeMillis();
                insertRecords(connection, true);
                endTime = System.currentTimeMillis();
                long durationWithBatch = endTime - startTime;

                resultLabel.setText("Duration without batch: " + durationWithoutBatch + "ms\n" +
                        "Duration with batch: " + durationWithBatch + "ms");
            }
        } catch (SQLException e) {
            resultLabel.setText("Failed to connect to database: " + e.getMessage());
        }
    }

    private void insertRecords(Connection connection, boolean useBatch) throws SQLException {
        String insertQuery = "INSERT INTO Temp(num1, num2, num3) VALUES (?, ?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);

        for (int i = 0; i < 1000; i++) {
            double num1 = Math.random();
            double num2 = Math.random();
            double num3 = Math.random();

            preparedStatement.setDouble(1, num1);
            preparedStatement.setDouble(2, num2);
            preparedStatement.setDouble(3, num3);

            if (useBatch) {
                preparedStatement.addBatch();
            } else {
                preparedStatement.executeUpdate();
            }
        }

        if (useBatch) {
            preparedStatement.executeBatch();
        }

        preparedStatement.close();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
