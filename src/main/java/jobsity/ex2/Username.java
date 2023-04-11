package jobsity.ex2;




public class Username {
  public static boolean validate(String username) {

    return username != null
        && username.matches("[a-zA-Z0-9_]+")
        && username.length() >= 4
        && Character.isLetter(username.charAt(0))
        && !username.endsWith("_");

    //([A-Za-z0-9\-\_]+)

    //4 char

    //numer, lett and _

    //start with letter and not end with _

  }

  public static void main(String[] args) {
    System.out.println(validate("Mike_Standish")); // Valid username
    System.out.println(validate("Mike Standish")); // Invalid username
  }
}
