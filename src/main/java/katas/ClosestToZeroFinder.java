package katas;

import java.util.List;

public class ClosestToZeroFinder {

    public int findClosestToZero(List<Integer> integers) throws RuntimeException {

        if (integers.isEmpty()) throw new RuntimeException("List may not be empty!");

        int smallest = 0;

        for (int i : integers) {
            if (smallest == 0 && !integers.contains(0)) {
                smallest = i;
            }

            if (smallest == Integer.MAX_VALUE && i == Integer.MIN_VALUE) continue;

            if (Math.abs(i) == Math.abs(smallest) && i > 0) {
                smallest = i;
            } else if (Math.abs(i) < Math.abs(smallest)) {
                smallest = i;
            }
        }

        return smallest;
    }

}
