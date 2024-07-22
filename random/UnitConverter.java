/**
 * Created by Damola Olutoba Onikoyi
 * DATE: 21, July 2024
 * EMAIL: damexxey94@gmail.com
 */


import java.util.HashMap;
import java.util.Map;

/**
 * [JaneStreet Online Sample technical Interview Question]
 * <p>
 * write a function to do this?
 * <blockquote>
 * <pre>
 * Example facts
 * 1 m = 3.28 ft
 * 1 ft = 12 in
 * 1 min = 60sec
 * 1 hr = 60 min
 *
 * Example
 * 2m = ? in ---> answer = 78.72
 * 13 in = ? m --> answer = 0.330
 * 13 in = ? hr ---->"not convertible"
 *
 * </pre>
 * </blockquote>
 */
public class UnitConverter {

    public static String convertUnit(int value, String fromUnit, String toUnit) {
        final Map<String, Double> fromBase = new HashMap<>();
        fromBase.put("m", 1.0);
        fromBase.put("ft", 3.28);
        fromBase.put("in", 3.28 * 12);
        fromBase.put("hr", 1.0);
        fromBase.put("min", 60.0);
        fromBase.put("sec", 3600.0);

        final Map<String, Double> toBase = new HashMap<>();
        toBase.put("m", 1.0);
        toBase.put("ft", 1 / 3.28);
        toBase.put("in", 1 / (3.28 * 12));
        toBase.put("hr", 1.0);
        toBase.put("min", 1 / 60.0);
        toBase.put("sec", 1 / 3600.0);

        if (isValidInput(fromBase, toBase, fromUnit, toUnit)) {
            double baseUnitValue = value * toBase.get(fromUnit);
            double convertedValue = baseUnitValue * fromBase.get(toUnit);
            return String.format("%.3f", convertedValue);
        } else {
            return "Not convertible";
        }
    }

    private static boolean isValidInput(Map<String, Double> fromBase, Map<String, Double> toBase,
                                        String fromUnit, String toUnit) {
        return fromBase.containsKey(fromUnit) && toBase.containsKey(toUnit)
                && ((isLengthUnit(fromUnit) && isLengthUnit(toUnit))
                || (isTimeUnit(fromUnit) && isTimeUnit(toUnit)));
    }

    private static boolean isLengthUnit(String unit) {
        return unit.equals("m") || unit.equals("ft") || unit.equals("in");
    }

    private static boolean isTimeUnit(String unit) {
        return unit.equals("hr") || unit.equals("min") || unit.equals("sec");
    }

}
