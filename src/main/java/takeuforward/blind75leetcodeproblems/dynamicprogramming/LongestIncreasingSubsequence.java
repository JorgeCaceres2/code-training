package takeuforward.blind75leetcodeproblems.dynamicprogramming;

public class LongestIncreasingSubsequence {
    public int lengthOfLIS(int[] nums) {
        int [] t = new int[nums.length];
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if(nums[i] > nums[j]) {
                    if (t[i] < t[j] + 1) {
                        t[i] = t[j] + 1;
                    }
                }
            }
        }
        int max = 0;
        for (int j : t) {
            max = Math.max(max, j);
        }
        return t[max] + 1;
    }

    public static void main(String[] args) {
        LongestIncreasingSubsequence longestIncreasingSubsequence = new LongestIncreasingSubsequence();
        int [] input = new int[] {10,9,2,5,3,7,101,18};
        System.out.println(longestIncreasingSubsequence.lengthOfLIS(input));
    }
}
