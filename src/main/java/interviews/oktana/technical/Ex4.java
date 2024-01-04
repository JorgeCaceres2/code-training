package interviews.oktana.technical;

import java.math.BigInteger;

/*Calculate and print:
The factorial of the provided number.
e.g. Factorial of 5 is:
5x4x3x2x1 = 120*/
public class Ex4 {
  public static void solution(int input) {
    // Write your code here
    // Return your answer using System.out.println();
    System.out.println(factorial(input));

  }

  public static long factorial (int n) {
    System.out.println("Multiplying " + n);
    if (n == 0  || n == 1) {
      return 1;
    } else {

      return n * factorial (n - 1);
    }
  }

  public static BigInteger fatorial2 (int n) {
    BigInteger acumulator = BigInteger.ONE;
    for (int i = 1; i <= n ; i++) {
      acumulator = acumulator.multiply(BigInteger.valueOf(i));
    }
    return acumulator;
  }

  public static void main(String[] args) {

    System.out.println(factorial(10));
    System.out.println(fatorial2(100));
  }

}
