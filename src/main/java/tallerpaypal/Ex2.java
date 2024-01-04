package tallerpaypal;

//Primitive by value
public class Ex2 {

  public static void main(String[] args) {
    int homerAge= 30;
    changeHomerAge (homerAge);
    System.out.println(homerAge);
  }

  private static void changeHomerAge(int homerAge) {
    homerAge = 35;
  }

}
