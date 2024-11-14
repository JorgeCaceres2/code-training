package takeuforward.sortalgorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InsertionSort {

    public static void insertionSort (int [] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    }

    public static void main(String[] args) {
        int [] input = new int[] {9,3,1,10,5};
        insertionSort(input);
        System.out.println(Arrays.toString(input));

        List<Integer> list = new ArrayList<>();
        list.get(1);
    }
}
