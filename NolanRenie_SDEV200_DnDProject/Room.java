/* Room.java
 * Author: Nolan Renie
 * Date: 2024/05/07
*/

//import java.util.Random;

class Room {
    private String name;
    private String type;
    private String content;

    public Room(String name, String type, String content) {
        this.name = name;
        this.type = type;
        this.content = content;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getContent() {
        return content;
    }
}