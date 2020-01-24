package katas;

import java.util.Arrays;
import java.util.List;

public class Application {

    public static void main(String[] args) {
        ClosestToZeroFinder closest = new ClosestToZeroFinder();

        // Init list with some values
        List<Integer> intList = Arrays.asList(2, 10, 9, 4, -5, -1, 2, -2);

        try {
            int lowestDistance = closest.findClosestToZero(intList);
            // Expecting -1
            System.out.println(lowestDistance);
        } catch (RuntimeException e) {
            e.printStackTrace();
        }

        // Reassign intList to immutable empty list (should throw RuntimeException when used with our findClosestToZero method)
        intList = List.of();

        try {
            int lowestDistance = closest.findClosestToZero(intList);
            // Shouldn't be reached
            System.out.println(lowestDistance);
        } catch (RuntimeException e) {
            // Should say "List may not be empty!"
            e.printStackTrace();
        }
    }

}
