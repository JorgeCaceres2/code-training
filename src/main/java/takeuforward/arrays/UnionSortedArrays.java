package takeuforward.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class UnionSortedArrays {
    public static ArrayList<Integer> findUnion(int arr1[], int arr2[], int n, int m) {
        // add your code here
        ArrayList<Integer> result = new ArrayList<>();

        int j = 0;
        int i = 0;
        while (i < n && j < m) {
            if (arr1[i] <= arr2[j]) {
                if (result.isEmpty() || result.get(result.size() - 1) != arr1[i]) {
                    result.add(arr1[i]);
                }
                i++;
            } else {
                if (result.isEmpty() || result.get(result.size() - 1) != arr2[j]) {
                    result.add(arr2[j]);
                }
                j++;
            }
        }

        for (int a = i; a < n; a++) {
            if (result.isEmpty() || result.get(result.size() - 1) != arr1[a]) {
                result.add(arr1[a]);
            }
        }


        for (int a = j; a < m; a++) {
            if (result.isEmpty() || result.get(result.size() - 1) != arr2[a]) {
                result.add(arr2[a]);
            }
        }

        return result;

    }
}
