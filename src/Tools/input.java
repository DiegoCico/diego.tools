package Tools;

import java.util.Scanner;

public class input {
    /**
     * Reads input from the user and tries to parse it into Integer or Double.
     * If parsing fails, returns the raw string.
     * @return Parsed input or raw input string.
     */
    public static Object input() {
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
}
