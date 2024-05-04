import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.stream.Collectors;

public class TimeDisplayApp extends Application {

    @Override
    public void start(Stage primaryStage) {
        Label timeLabel = new Label("Fetching current time...");

        // Send HTTP GET request to servlet to fetch current time
        try {
            URL url = new URL("http://localhost:8080/currenttime"); // Replace with your servlet URL
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String timeResponse = reader.lines().collect(Collectors.joining("\n"));
            reader.close();

            timeLabel.setText(timeResponse);
        } catch (Exception e) {
            e.printStackTrace();
        }

        VBox root = new VBox(timeLabel);
        Scene scene = new Scene(root, 300, 100);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Current Time Display");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}