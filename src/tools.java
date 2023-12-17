import java.sql.Array;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.function.Supplier;

public class tools {

    // a way to test your function, whatever it returns should be the expected output
    public static void testSame(Supplier<?> script, Object output, String name){
        if (script.get().equals(output))
            System.out.println("Test (" + name + "): Passed");
        else
            System.out.println("Test (" + name + "): Got = " + script.get() + ", Expected = " + output);
    }

    // easy way to import your texts and convert it to any data type
    public static Object input(){
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException ignored) {}


        try {
            return Double.parseDouble(input);
        } catch (NumberFormatException ignored) {}

        return input;
    }

    public static void printArray(ArrayList list){
        String stringL = "";
        for(int i = 0; i < list.size(); i++){
            stringL += list.get(i) + ", ";
        }
        System.out.println(stringL.substring(0,stringL.length()-2));
    }

}
