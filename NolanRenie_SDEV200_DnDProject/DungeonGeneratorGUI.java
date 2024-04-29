import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class DungeonGeneratorGUI extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("D&D Dungeon Generator");

        // Dungeon parameters
        Label widthLabel = new Label("Width:");
        TextField widthField = new TextField();
        Label heightLabel = new Label("Height:");
        TextField heightField = new TextField();
        Button generateButton = new Button("Generate");

        // Dungeon display area
        TextArea dungeonDisplay = new TextArea();
        dungeonDisplay.setEditable(false);
        Button saveButton = new Button("Save");

        // Layout
        VBox layout = new VBox(10);
        layout.getChildren().addAll(
            new HBox(10, widthLabel, widthField),
            new HBox(10, heightLabel, heightField),
            generateButton,
            dungeonDisplay,
            saveButton
        );

        // Event handling
        generateButton.setOnAction(e -> {
            int width = Integer.parseInt(widthField.getText());
            int height = Integer.parseInt(heightField.getText());
            // Call dungeon generation method here and update the dungeonDisplay
        });

        saveButton.setOnAction(e -> {
            // Save dungeon map to a file
        });

        Scene scene = new Scene(layout, 600, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
