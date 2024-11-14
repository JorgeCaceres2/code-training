package takeuforward.blind75leetcodeproblems;

public class maxProduct {
    public static int maxProduct(int[] nums) {
        double prefix = 1;
        double suffix = 1;
        double maxProduct = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (prefix == 0) {
                prefix = 1;
            }
            if (suffix == 0) {
                suffix = 1;
            }
            prefix = prefix * (double) nums[i];
            suffix = suffix * (double) nums[nums.length -1 -i];
            maxProduct = Math.max(maxProduct, Math.max(prefix, suffix));
        }
        return (int) maxProduct;
    }

    public static void main(String[] args) {
        int [] input = new int[] {0,10,10,10,10,10,10,10,10,10,-10,10,10,10,10,10,10,10,10,10,0};
        System.out.println(maxProduct(input));
    }
}
