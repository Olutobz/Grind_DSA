package blackrock;

/**
 * Created by Damola Olutoba Onikoyi
 * DATE: 13, September 2024
 * EMAIL: damexxey94@gmail.com
 */


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * You've decided to make a road trip across the country in a straight line.
 * You have chosen the direction you'd like to travel and made a list of cities with gas stations to stop at and fill up your tank.
 * To ensure this route is viable, you need to know the distance between the adjacent cities to be able to travel
 * this distance on a single gasoline tank, but you only know the distances to each city from your starting point.
 * <p>
 * <blockquote>
 * <pre>
 * Input: Read lines from standard input. each line contains the list of cities and distances to them, comma-delimited,
 * from the starting point of your trip. You start your trip at point 0. The cities with their distances are separated semicolons.
 *
 * Output: Print out the distance from the starting point to the nearest city, and the distances
 * between the two nearest cities separated by a comma, in order they appear on the route
 *
 * Example:
 * Input = Rkbs,5453;  Wdqiz,1245; Rwds,3890; Ujma,5589; Tbzmo,1303;
 * Output = 1245,58,2587,1563,136
 * </pre>
 * </blockquote>
 */

public class RoadTripBetweenTwoCities {

    // TC -> O(n log n), SC -> O(N)
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = "Rkbs,5453; Wdqiz,1245; Rwds,3890; Ujma,5589; Tbzmo,1303;";
        String[] cityDistancePairs = input.split(";");

        List<Integer> distances = new ArrayList<>();

        for (String pair : cityDistancePairs) {
            if (!pair.trim().isEmpty()) {
                String[] cityDistance = pair.split(",");
                distances.add(Integer.parseInt(cityDistance[1].trim()));
            }
        }

        Collections.sort(distances);
        System.out.print(distances.get(0));

        for (int i = 1; i < distances.size(); i++) {
            System.out.print("," + (distances.get(i) - distances.get(i - 1)));
        }
    }
}
