package takeuforward.blind75leetcodeproblems.string;

import java.util.HashMap;
import java.util.Map;

public class LongestRepeatingCharacter {

    public static int characterReplacement(String s, int k) {
        int maxFreq = 0;
        int maxLength = 0;
        int l = 0;
        int r = 0;
        Map<Character, Integer> hash = new HashMap<>();

        while (r < s.length()) {
            hash.put(s.charAt(r), hash.getOrDefault(s.charAt(r), 0) + 1);
            maxFreq = Math.max (maxFreq, hash.get(s.charAt(r)));
            while ((r - l + 1) - maxFreq > k) {
                hash.put(s.charAt(l), hash.getOrDefault(s.charAt(l), 0) - 1);
                maxFreq = Math.max(maxFreq, hash.get(s.charAt(l)));
                l++;
            }
            if ((r - l + 1) - maxFreq <= k) {
                maxLength = Math.max(maxLength, (r-l+1));
            }
            r++;
        }
        return maxLength;
    }

    public static int characterReplacementOptimal(String s, int k) {
        int maxFreq = 0, maxLength = 0, l = 0, r = 0;
        Map<Character, Integer> hash = new HashMap<>();
        while (r < s.length()) {
            hash.put(s.charAt(r), hash.getOrDefault(s.charAt(r), 0) + 1);
            maxFreq = Math.max (maxFreq, hash.get(s.charAt(r)));
            if ((r - l + 1) - maxFreq > k) {
                hash.put(s.charAt(l), hash.getOrDefault(s.charAt(l), 0) - 1);
                maxFreq = Math.max(maxFreq, hash.get(s.charAt(l)));
                l++;
            }
            if ((r - l + 1) - maxFreq <= k) {
                maxLength = Math.max(maxLength, (r-l+1));
            }
            r++;
        }
        return maxLength;
    }

    public static int characterReplacementBestOptimal (String s, int k) {
        int[] arr = new int[26];
        char [] ans = s.toCharArray();
        int max = 0;
        int i = 0;
        for (int j = 0; j < ans.length; j++) {
            arr[ans[j] - 'A']++;
            max = Math.max(max, arr[ans[j] - 'A']);
            while (j - i + 1 - max > k) {
                arr[ans[i++] - 'A']--;
            }
        }
        return ans.length-i;
    }

    public static void main(String[] args) {
        System.out.println("1.Better Solution: " + characterReplacement("AABABBA", 1));
        System.out.println("1.Optimal Solution: " + characterReplacementOptimal("AABABBA", 1));
    }
}
