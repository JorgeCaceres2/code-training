package hackerrrank.interviewspreparation;

import java.util.ArrayList;
import java.util.List;

public class LeftRotation {

  public static List<Integer> rotLeft(List<Integer> a, int d) {
    // Write your code here
    List<Integer> result = new ArrayList<>();
    for (int i = d ; i < a.size() ; i++) {
      result.add(a.get(i));
    }
    for (int i = 0; i < d; i++) {
      result.add(a.get(i));
    }
    return result;
  }

  public static void main(String[] args) {
    System.out.println(List.of(rotLeft(List.of(1,2,3,4,5), 2)));
  }

}
