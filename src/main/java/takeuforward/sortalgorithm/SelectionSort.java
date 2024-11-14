package takeuforward.sortalgorithm;

import java.util.Arrays;

public class SelectionSort {

    public static void selectionSort(int[] arr) {

        for (int i = 0; i < arr.length - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIdx]) {
                    minIdx = j;
                }
            }
            int temp = arr[minIdx];
            arr[minIdx] = arr[i];
            arr[i] = temp;
        }
    }


    public static void main(String[] args) {
        int[] input = new int[]{4, 1, 3, 9, 7};
        selectionSort(input);
        System.out.println(Arrays.toString(input));
    }
}
