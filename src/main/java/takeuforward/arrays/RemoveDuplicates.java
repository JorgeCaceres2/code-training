package takeuforward.arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class RemoveDuplicates {

    public static int removeDuplicates (int [] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int n : nums) {
            if (map.get(n) != null) {
                map.put(n, map.get(n) + 1);
            } else {
                map.put(n, 1);
            }
        }

        Map<String, String> queryParams = new HashMap<>();
        queryParams.put("tenant", "tenant");
        queryParams.put("orderType", null);

       // Map <String, String> queryParams2 = Map.of("tenant", "tenant", "orderType", null);

        List<Integer> integers = map.keySet().stream().toList();
        nums = integers.stream().mapToInt(i -> i).toArray();
        System.out.println(Arrays.toString(nums));
        return nums.length;

    }

    public static void main(String[] args) {
        int [] input = new int[] {1,1,2};
        System.out.println(removeDuplicates(input));

    }
}
