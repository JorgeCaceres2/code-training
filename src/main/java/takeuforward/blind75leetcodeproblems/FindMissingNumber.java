package takeuforward.blind75leetcodeproblems;

import java.util.Arrays;

public class FindMissingNumber {

    public static int missingNumberBetterSolution(int[] a, int N) {
        int[] hash = new int[N + 1]; //hash array
        // storing the frequencies:
        for (int i = 0; i < N - 1; i++)
            hash[a[i]]++;
        //checking the frequencies for numbers 1 to N:
        for (int i = 1; i <= N; i++) {
            if (hash[i] == 0) {
                return i;
            }
        }
        // The following line will never execute.
        // It is just to avoid warnings.
        return -1;
    }

    public static int missingNumberOptimalSolutionSum (int [] a, int n) {
        Double sum = ((double) (n+1) * (double) (n+2)) / 2;
        Double sum2 = (double) 0;
        for (int j : a) {
            sum2 += (double) j;
        }
        return (int) (sum - sum2);
    }

    public static int missingNumberOptimalSolutionXOR (int [] a, int n) {
        int xorArray = 0;
        int xorRange = 0;

        // XOR all elements in the array
        for (int i = 0; i < n; i++) {
            xorArray ^= a[i];
            xorRange ^= i;
        }

        xorRange ^= n;
        xorRange ^= (n + 1);

        // The missing number is the XOR of xorArray and xorRange
        return xorArray ^ xorRange;
    }

    public static int missingNumberOptimalSolutionXOR2(int[] a) {
        int xorArray = 0;
        int xorRange = 0;
        // XOR all elements in the array
        for (int i = 0; i < a.length; i++) {
            xorArray ^= a[i];
            xorRange ^= i;
        }

        xorRange ^= a.length;
        xorRange ^= a.length + 1;
        // The missing number is the XOR of xorArray and xorRange
        return xorArray ^ xorRange;
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 4, 5};

        System.out.println("1.The missing number is: " + missingNumberBetterSolution(a, a.length));
        System.out.println("2.The missing number is: " + missingNumberOptimalSolutionSum(a, a.length));
        System.out.println("3.The missing number is: " + missingNumberOptimalSolutionXOR(a, a.length));
        System.out.println("4.The missing number is: " + missingNumberOptimalSolutionXOR2(a));
    }


}
