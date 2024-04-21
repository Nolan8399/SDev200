/* Main.java
 * Author: Nolan Renie
 * Date: 2024/04/21
*/

//WIP basic class set-up

class Main {
    public static void main(String[] args) {
        DungeonGenerator generator = new DungeonGenerator(100, 5, "Caves", 123456789, "Hard");
        generator.generateDungeon();
    }
}
