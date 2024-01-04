package interviews.oktana.technical;

//Print 'true' if element is present in the array, otherwise print 'false'
public class Ex1 {

  public static void solution(int input, String[] arrayInput) throws Exception {
    // Write your code here
    // Return your answer using System.out.println();
    for (String s : arrayInput) {
      String in = String.valueOf(input);
      if (in.equals(s)) {
        System.out.println("true");
        return;
      }
    }
    System.out.println("false");
  }

  public static void main(String[] args) throws Exception {
    solution(-10, new String[] {"2", "5", "-10", "5", "3", "6"});
  }

}
