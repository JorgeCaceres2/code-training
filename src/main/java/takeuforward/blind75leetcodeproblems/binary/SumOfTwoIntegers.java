package takeuforward.blind75leetcodeproblems.binary;

public class SumOfTwoIntegers {

    public static int getSum(int a, int b) {
        while (b != 0) {
            int temp = (a & b) << 1;  //010 110 010
            a = a ^ b; //010 110 100
            b = temp;
        }
        return a;
    }

    public static void main(String[] args) {
        int a = 2, b = 3;
        System.out.println(a + " + " + b + " = " + getSum(a, b));
    }
}
/*
*   000 0
*   100 1
*   010 2
*   110 3
*   001 4
*   101 5
*   011 6
*   111 7
* */


