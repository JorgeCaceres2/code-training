package takeuforward.arrays;

import java.util.List;

public class Print2largest {
    public int print2largest(List<Integer> arr) {
        // Code Here
        int max = Integer.MIN_VALUE;
        int secMax= -1;

        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i) > max) {
                secMax = Math.max(max, secMax);
                max = arr.get(i);
            } else if ((arr.get(i) > secMax) && (arr.get(i) < max)) {
                secMax = arr.get(i);
            }
        }

        return secMax;
    }
}
