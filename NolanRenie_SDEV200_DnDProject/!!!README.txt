This project is a WIP. It has been completed for a class project, but I intend on improving it in the future or remaking it in something like C++.

The following is a UML Diagram. 
 ___________________________
|         Main              
|---------------------------
| + main(String[]): void   
 ---------------------------
           |
           |
           |
           v
  ___________________
 |    DungeonGeneratorGUI   
 |-------------------------
 | + main(String[]): void  
 | + start(Stage): void    
  -------------------------
           |
           |
           |
           v
  ___________________
 |   DungeonGenerator    
 |-----------------------
 | - random: Random       
 | - roomNames: List<String>
 | - roomTypes: List<String>
 | - roomContent: List<String>
 |-------------------------
 | + generateDescription(): String
 | - readLinesFromFile(String): List<String>
 | - getRandomElement(List<String>): String
  -------------------------
            |
            |
            |
            v
  ___________________
 |         Room          
 |-----------------------
 | - name: String        
 | - type: String        
 | - content: String     
 |-----------------------
 | + Room(String, String, String) 
 | + getName(): String   
 | + getType(): String   
 | + getContent(): String
  -----------------------
