package hackerrrank.interviewspreparation;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SockPairs {

  public static int sockMerchant(int n, List<Integer> ar) {
    // Write your code here

    Map<Integer, Integer> map = new HashMap();

    ar.stream().forEach(element ->
        {
          Integer valueCount = map.get(element) == null ? 1 : map.get(element) + 1;
          map.put(element, valueCount);
        }
    );

    int pairs = 0;
    for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
      pairs += entry.getValue() / 2;
    }
    return pairs;
  }


  public static void main(String[] args) {
    List <Integer> list = List.of(1,2,1,2,1,2,2);
    System.out.println(sockMerchant(7, list));
  }

}
