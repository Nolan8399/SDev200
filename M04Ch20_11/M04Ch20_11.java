/* M04Ch20_11.java
 * Author: Nolan Renie
 * Date: 2024/04/14
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class M04Ch20_11 {

    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: filename");
            System.exit(0);
        }

        File file = new File(args[0]);
        if (!file.isFile()) {
            System.out.println(args[0] + " is not a file.");
            System.exit(0);
        }

        Stack<String> stack = new Stack<>();
        ArrayList<String> symbols = new ArrayList<>();
        Collections.addAll(symbols, "(", ")", "{", "}", "[", "]");
        try(BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(file)))) {
            String s;
            while ((s = in.readLine()) != null) {

                for (char c : s.toCharArray()) {
                    String symbol = c + "";
                    int symbolIndex = symbols.indexOf(symbol);

                    if (symbolIndex == -1)
                        continue;

                    if (stack.size() == 0) {
                        stack.push(symbol);
                    } else {
                        int lastIndex = symbols.indexOf(stack.peek());
                        if (symbolIndex - 1 == lastIndex) {
                            stack.pop();
                        } else {
                            if ((lastIndex & 1) == 1)
                                System.out.println("ERROR at:" + s);
                            stack.push(symbol);
                        }
                    }
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("IO error.");
            e.printStackTrace();
        }
    }
}