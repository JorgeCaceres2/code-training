package tallerpaypal;

//Method reference

public class Ex5 {


  public static void saySomething () {
    System.out.println("Hello");
  }

  public static void say () {
    System.out.println("Hi");
  }

  public static void main(String[] args) {
    Sayable sayable = Ex5::say;
    sayable.say();
  }

}

interface Sayable {
  void say ();
}
