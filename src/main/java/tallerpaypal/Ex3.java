package tallerpaypal;


//Reference

public class Ex3 {

  public static void main(String[] args) {
    StringBuilder name = new StringBuilder("Homer ");
    addSureName (name);
    System.out.println(name);
  }

  private static void addSureName(StringBuilder name) {
    name.append("Simpson");
  }


}
