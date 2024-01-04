package tallerpaypal;

public class Ex1 {

  public static void main(String... doYourBest) {
    Simpson simpson = new Simpson();
    transFormIntoHomer (simpson);
    System.out.println(simpson.name);
  }

  private static void transFormIntoHomer(Simpson simpson) {
    simpson.name= "Homer";
  }

}
  class Simpson {
    String name;
  }


