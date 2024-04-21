/* DungeonGenerator.java
 * Author: Nolan Renie
 * Date: 2024/04/21
*/

//WIP basic class set-up

import java.util.Random;

public class DungeonGenerator {
    private int size;
    private int complexity;
    private String theme;
    private long seed;
    private String difficultyLevel;

    public DungeonGenerator(int size, int complexity, String theme, long seed, String difficultyLevel) {
        this.size = size;
        this.complexity = complexity;
        this.theme = theme;
        this.seed = seed;
        this.difficultyLevel = difficultyLevel;
    }

    public void generateDungeon() {
        // Generate dungeon logic here based on size, complexity, theme, seed, and difficulty level
        System.out.println("Dungeon generated!");
    }
}