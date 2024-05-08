/* DungeonGenerator.java
 * Author: Nolan Renie
 * Date: 2024/05/07
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class DungeonGenerator {
    private Random random;
    private List<String> roomNames;
    private List<String> roomTypes;
    private List<String> roomContent;

    public DungeonGenerator(String roomNamesFile, String roomTypesFile, String roomContentFile) {
        random = new Random();
        roomNames = readLinesFromFile(roomNamesFile);
        roomTypes = readLinesFromFile(roomTypesFile);
        roomContent = readLinesFromFile(roomContentFile);
    }

    public String generateDescription() {
        String name = getRandomElement(roomNames);
        String type = getRandomElement(roomTypes);
        String content = getRandomElement(roomContent);
        Room room = new Room(name, type, content);
        return "You entered a " + room.getType() + ", " + room.getName() + ".\n" + "The room contains " + room.getContent() + ".";
    }

    private List<String> readLinesFromFile(String filename) {
        List<String> lines = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lines;
    }

    private String getRandomElement(List<String> list) {
        return list.get(random.nextInt(list.size()));
    }
}