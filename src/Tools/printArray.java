package Tools;

import java.util.ArrayList;

public class printArray {
    /**
     * Prints elements of an ArrayList in a single line.
     * @param list The ArrayList to be printed.
     */
    public static void printArray(ArrayList<Object> list) {
        if (list.isEmpty()) {
            System.out.println("The list is empty.");
        } else {
            String stringL = "";
            for (Object obj : list) {
                stringL += obj + ", ";
            }
            System.out.println(stringL.substring(0, stringL.length() - 2));
        }
    }
}
