package takeuforward.blind75leetcodeproblems.string;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
* design an algorithm to encode a list of string to a string, the encoded string
* is then sent over the network and is decoded back to the original list of strings
*
* Input ["Hello","World"]
* output ["Hello","World"]
* */
public class EncodeDecode {
    private static final char delimiter = '#';

    public static String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String s : strs) {
           sb.append(s.length()).append(delimiter).append(s);
        }
        return sb.toString();
    }

    public static List<String> decode (String s) {
        List <String> answer = new ArrayList<>();
        int i = 1;
        while (i < s.length()) {
            if (s.charAt(i) == delimiter) {
                int length = Integer.parseInt(String.valueOf(s.charAt(i - 1)));
                answer.add(s.substring(i+1, i + length + 1));
                i += length + 2;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        String encode = encode(List.of("Hello","World"));
        System.out.println(encode);
        List <String> decode = decode(encode);
        System.out.println(Arrays.toString(decode.toArray()));
    }
}
