package takeuforward.sortalgorithm;

import java.util.Arrays;

public class BubbleSort {

    public static void bubbleSort (int arr [], int n) {
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n-i-1; j++ ) {
                if (arr[j] > arr[j+1]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int [] input = new int[] {4,1,3,9,7};
        bubbleSort(input, input.length);
        System.out.println(Arrays.toString(input));
    }
}
