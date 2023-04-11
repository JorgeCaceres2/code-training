package designpatterns;

public class LazySingleton {

  private static volatile LazySingleton INSTANCE;

  private LazySingleton() {

  }

  public static LazySingleton getInstance() {
    if (INSTANCE == null) {
      synchronized (LazySingleton.class) {
        if (INSTANCE == null) {
          INSTANCE = new LazySingleton();
        }
      }
    }
    return INSTANCE;
  }

  public static void main(String[] args) {
    LazySingleton ls1 = LazySingleton.getInstance();
    LazySingleton ls2 = LazySingleton.getInstance();

    System.out.println(ls1 == ls2);
  }
}

