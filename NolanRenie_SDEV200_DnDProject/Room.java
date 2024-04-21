/* Room.java
 * Author: Nolan Renie
 * Date: 2024/04/21
*/

//WIP basic class set-up

import java.util.Random;

class Room {
    private int length;
    private int width;
    private String contents;
    private Room[] connections;
    private String description;
    private String specialFeatures;

    public Room() {
        // Default constructor
    }

    public void setDimensions(int length, int width) {
        this.length = length;
        this.width = width;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    public void setConnections(Room[] connections) {
        this.connections = connections;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setSpecialFeatures(String features) {
        this.specialFeatures = features;
    }
}