package tallerpaypal;


//longest substring with no repeated characters
public class Challenge2 {

  public static int lengthOfLongestSubstring (String s) {
    if (s == null || s.length() == 0) {
      return 0;
    }
    StringBuilder subStr = new StringBuilder();
    char [] inputCharacters = s.toCharArray();
    int maxLength = 0;
    for (int i = 0; i < s.length(); i++) {
      String actual = String.valueOf(inputCharacters[i]);
      if (!subStr.toString().contains(actual)) {
        subStr.append(actual);
        maxLength = Math.max(subStr.toString().length(), maxLength);
      } else {
        System.out.println("substr: " + subStr + ", max: " + maxLength +" ");
        maxLength = Math.max(subStr.toString().length(), maxLength);
        subStr = new StringBuilder().append(actual);
      }

    }
    return maxLength;
  }

  public static void main(String[] args) {
    int result = lengthOfLongestSubstring("dvdf");
    System.out.println(result);
  }


}


/*
* /*
 En el ejercicio basicamente se recibe una cadena y hay que encontrar la cadena mas larga
 con caracteres no repetidos. Ejemplo:
    aabczaqww
    La subcadena mas larga es "abcz" entonces se deberia devolver 4.
    Hay un cornercase y por eso el length == 0 al final del metodo... Que pasaria si todos los caracteres
    fueran diferentes ?...

class Scratch {
  public static int lengthOfLongestSubstring(String s) {
    StringBuilder builder = new StringBuilder();
    int length = 0;
    char[] caracteres = s.toCharArray();
    for (int i = 0; i < caracteres.length; i++) {
      char caracter = caracteres[i];

      if(!builder.toString().contains(String.valueOf(caracter))) {
        builder.append(caracter);
      } else {
        if(builder.toString().length() > length){
          length = builder.toString().length();
        }
        builder.setLength(0);
        builder.append(caracter);
      }
    }
    if(length == 0) {
      length = builder.toString().length();
    }
    return length;
  }
  public static void main(String[] arg){
    int result = lengthOfLongestSubstring("abcd");
    //int result = lengthOfLongestSubstring("agusa");
    System.out.println("Length: " + result);
  }
}

*
* */
