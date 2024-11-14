package takeuforward.blind75leetcodeproblems.string;

import java.util.HashMap;

public class ShortestSubString {

    //TL:N2  SC:O(256)
    public static String shortest(String n, String m) {
        int minLength = Integer.MAX_VALUE;
        int startIdx = -1;

        for (int i = 0; i < n.length(); i++) {
            int[] hash = new int[256];
            int count = 0;
            for (int j = 0; j < m.length(); j++) {
                hash[m.charAt(j)]++;
            }

            for (int j = 0; j < n.length(); j++) {
                if (hash[n.charAt(j)] > 0) {
                    count++;
                    hash[n.charAt(j)]--;
                }
                if (count == m.length()) {
                    if (j - i + 1 < minLength) {
                        minLength = j - i - 1;
                        startIdx = i;
                        break;
                    }
                }
            }
        }
        return n.substring(startIdx, startIdx + minLength);
    }

    //TL: O(2N) + O(M) SL: O(256)
    public static String minWindowOptimalTYF(String s, String t) {
        int[] hash = new int[256];
        int l = 0, r = 0, count = 0, startIdx = -1, minLength = Integer.MAX_VALUE;
        for (int i = 0; i < t.length(); i++) { //O(m)
            hash[t.charAt(i)]++;
        }
        // A D O B E C O D E B A  N  C              A   B   C   D   E   O   N    L   R   COUNT minLen
        // 0 1 2 3 4 5 6 7 8 9 10 11 12             0   0   0   0   0   0   0    0   0   0      0
        while (r < s.length()) {
            if (hash[s.charAt(r)] > 0) {
                count++;
            }
            hash[s.charAt(r)]--;
            while (count == t.length()) {
                if ( (r - l + 1) < minLength) {
                    minLength =  r - l + 1;
                    startIdx = l;
                }
                hash[s.charAt(l)]++;
                if (hash[s.charAt(l)] > 0) {
                    count--;
                }
                l++;
            }
            r++;
        }
        return startIdx == -1 ? "" : s.substring(startIdx, startIdx + minLength);
    }

    public static String minWindow2(String s, String t) {
        int l = 0;
        int r = 0;
        HashMap<Character, Integer> mpp = new HashMap<>();
        int cnt = 0;
        int sindex = -1;
        int minlen = Integer.MAX_VALUE;
        for (int i = 0; i < t.length(); i++) {
            mpp.put(t.charAt(i), mpp.getOrDefault(t.charAt(i), 0) + 1);
        }
        while (r < s.length()) {
            char ch = s.charAt(r);
            if (mpp.containsKey(ch) && mpp.get(ch) > 0) {
                cnt++;
            }
            mpp.put(ch, mpp.getOrDefault(ch, 0) - 1);
            while (cnt == t.length()) {
                if (r - l + 1 < minlen) {
                    minlen = r - l + 1;
                    sindex = l;
                }
                mpp.put(s.charAt(l), mpp.get(s.charAt(l)) + 1);
                if (mpp.get(s.charAt(l)) > 0) {
                    cnt--;
                }
                l++;
            }
            r++;
        }
        return sindex == -1 ? "" : s.substring(sindex, sindex + minlen);
    }

    public static void main(String[] args) {
        //System.out.println("1.Brute approach: " + shortest("ADOBECODEBANC","ABC"));
        System.out.println("2.Optimal approach: " + minWindowOptimalTYF("ADOBECODEBANC", "ABC"));
        // System.out.println("3.Optimal approach: " + minWindow2("ADOBECODEBANC", "ABC"));
    }
}
