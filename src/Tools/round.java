package Tools;

public class round {

    /**
     * Rounds a given double number to a specified number of decimal places.
     *
     * @param place The number of decimal places to round the number to.
     * @param num   The number to be rounded.
     * @return The rounded number.
     */
    public double round(int place, float num){
        double multiplier = Math.pow(10, place);

        return Math.round(num* multiplier)/ multiplier;
    }
}
