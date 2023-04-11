package designpatterns;

public class EagerSingleton {

  public static final EagerSingleton INSTANCE = new EagerSingleton();

  private EagerSingleton () {

  }

  public static EagerSingleton getInstance() {
    return INSTANCE;
  }

  public static void main(String[] args) {
    EagerSingleton s1 = EagerSingleton.getInstance();
    EagerSingleton s2 = EagerSingleton.getInstance();

    System.out.println(s1 == s2);
  }

}
