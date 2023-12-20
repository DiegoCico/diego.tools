package Tools;

/**
 * Utility class for number conversions.
 */
public class toInt {

    /**
     * Converts a string to an integer.
     *
     * @param num The string to convert.
     * @return The integer value of the string.
     * @throws NumberFormatException if the string cannot be parsed as an integer.
     */
    public static int toInt(String num) {
        try {
            return Integer.parseInt(num);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid input for integer conversion: " + num, e);
        }
    }
}
