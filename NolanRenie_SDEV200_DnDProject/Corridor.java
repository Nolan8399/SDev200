/* Corridor.java
 * Author: Nolan Renie
 * Date: 2024/04/21
*/

//WIP basic class set-up

import java.util.Random;

class Corridor {
    private int length;
    private int width;
    private String obstacles;
    private Room[] connections;
    private String description;

    public Corridor() {
        // Default constructor
    }

    public void setLength(int length) {
        this.length = length;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setObstacles(String obstacles) {
        this.obstacles = obstacles;
    }

    public void setConnections(Room[] connections) {
        this.connections = connections;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}