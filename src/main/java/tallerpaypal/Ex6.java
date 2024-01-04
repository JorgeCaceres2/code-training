package tallerpaypal;

public class Ex6 {

  public static void main(String[] args) {
    int a = 5;
    Square s = (int x) -> x * x;
    int ans = s.calculate(a);
    System.out.println(ans);
  }
}

interface Square {

  int calculate(int x);

  default int add(int x, int y) {
    return (x + y);
  }
}
