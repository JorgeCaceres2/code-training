package takeuforward.blind75leetcodeproblems.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {
    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str: strs) {
            char [] sortedChars = str.toCharArray();
            Arrays.sort(sortedChars);
            String sortedStr = new String(sortedChars);
            List<String> list = map.getOrDefault(sortedStr, new ArrayList<>());
            list.add(str);
            map.put(sortedStr, list);
        }
        return new ArrayList<>(map.values());
    }

    public static List<List<String>> groupAnagramsOptimusSolution(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str: strs) {
            int [] freq = new int[26];
            for (char ch: str.toCharArray()) {
                freq[ch - 'a']++;
            }
            String freqString = Arrays.toString(freq);
            List<String> list = map.getOrDefault(freqString, new ArrayList<>());
            list.add(str);
            map.put(freqString, list);
        }
        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        System.out.println("Result: " + groupAnagrams(new String[] {"eat","tea","tan","ate","nat","bat"}));
        System.out.println("Result: " + groupAnagramsOptimusSolution(new String[] {"eat","tea","tan","ate","nat","bat"}));
    }
}
