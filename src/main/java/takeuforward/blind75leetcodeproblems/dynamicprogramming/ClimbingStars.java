package takeuforward.blind75leetcodeproblems.dynamicprogramming;

public class ClimbingStars {

    public static int climbStairsOptimalSolution(int n) {
        if (n <= 1) {
            return 1;
        }

        int prev1 = 1;
        int prev2 = 1;

        for (int i = 2; i <= n; i++) {
            int current = prev1 + prev2;
            prev2 = prev1;
            prev1 = current;
        }

        return prev1;

    }

    public static int climbStairsFibonacciBased(int n) {
        if (n <= 1) {
            return 1;
        }
        return climbStairsFibonacciBased(n - 1) + climbStairsFibonacciBased(n - 2);
    }

    public static void main(String[] args) {
        int n = 5;
        System.out.println("Optimal: " + climbStairsOptimalSolution(n));
        System.out.println("FibonacciBased: " + climbStairsFibonacciBased(n));
    }
}
