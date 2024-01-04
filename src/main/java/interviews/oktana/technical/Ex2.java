package interviews.oktana.technical;

/*
*Print the FIRST position where the element is on the array
If the element is in the FIRST position of the array print '1'
If the element is in the SECOND position of the array print '2'
If the element is in the THIRD position of the array print '3'
...
If the element is in the Nth position of the array print corresponding N number
If the element is NOT present in the array print '-1'
 */
public class Ex2 {
  public static void solution(int input, String[] arrayInput) throws Exception {
    // Write your code here
    // Return your answer using System.out.println();
    String in = String.valueOf(input);
    for (int i=0; i< arrayInput.length ; i++) {
      if (in.equals(arrayInput[i])) {
        System.out.println(i+1);
        return;
      }
    }
    System.out.println("-1");
  }

  public static void main(String[] args) throws Exception {
    solution(9, new String[] {"2", "5", "-10", "5", "9", "6"});
  }
}
