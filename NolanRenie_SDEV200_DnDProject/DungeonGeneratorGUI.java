/* DungeonGeneratorGUI.java
 * Author: Nolan Renie
 * Date: 2024/05/07
*/

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

//import java.util.Random;

public class DungeonGeneratorGUI extends Application {
    //private DungeonGenerator dungeonGenerator;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Dungeon Room Description Generator");
        
        // Initialize DungeonGenerator
        DungeonGenerator dungeonGenerator = new DungeonGenerator("DnDText/RoomState.txt", "DnDText/RoomDesc.txt", "DnDText/RoomContent.txt");

        // Create UI elements
        Label descriptionLabel = new Label();
        Button generateButton = new Button("Generate Description");
        generateButton.setOnAction(e -> {
            String description = dungeonGenerator.generateDescription();
            descriptionLabel.setText(description);
        });

        // Create layout
        VBox layout = new VBox(20);
        layout.getChildren().addAll(descriptionLabel, generateButton);
        layout.setMinSize(400, 150);

        // Set scene
        Scene scene = new Scene(layout);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}