package hackerrrank.interviewspreparation;

public class Hiker {

  public static int countingValleys(int steps, String path) {
    int valleyCount = 0;
    int seaLevel = 0;
    char[] array = path.toCharArray();
    for (char c : array)
      switch (String.valueOf(c)) {
        case "U":
          seaLevel++;
          break;
        case "D":
          if (seaLevel == 0) {
            valleyCount ++;
          }
          seaLevel--;
          break;
    }
    return valleyCount;
  }

  public static void main(String[] args) {
    String path = "UDDDUDUU";
    int l = path.length();

    System.out.println("Valleys: "+ countingValleys(l, path));
  }

}
