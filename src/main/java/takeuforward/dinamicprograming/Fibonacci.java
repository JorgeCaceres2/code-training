package takeuforward.dinamicprograming;

public class Fibonacci {

    public static int getFibonacci(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else {
            return getFibonacci(n - 1) + (n - 2);
        }
    }

    public static void main(String[] args) {
        int n = 10;
        System.out.println("Fibonacci of " + n + " is -> " + getFibonacci(n));
    }
}
