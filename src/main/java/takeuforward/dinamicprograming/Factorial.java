package takeuforward.dinamicprograming;

public class Factorial {

    private static int getFactorial (int n) {
        if (n == 0) {
            return 1;
        } else {
            return n * getFactorial(n -1);
        }
    }

    public static void main(String[] args) {
        int n = 5;
        System.out.println("Factorial of " + n + " is -> " + getFactorial(n));
    }
}
