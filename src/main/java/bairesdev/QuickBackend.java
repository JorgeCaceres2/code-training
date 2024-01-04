package bairesdev;

import java.util.Arrays;

public class QuickBackend {

  //funcion que dado un array de enteros "arr" y un entero "ent" devuelva la cantidad de apariciones del elemento "ent"
  //en el array "arr"

  public static int function(int[] arr, int ent) {
    int count = 0;
    for (int i : arr) {
      if (i == ent) {
        count++;
      }
    }
    return count;
  }


  public static int function2(int[] arr, int ent) {
    return (int) Arrays.stream(arr)
        .filter(element -> element == ent)
        .count();
  }

  public static void main(String[] args) {
    int arr[] = {2, 3, 4, 3, 2, 3};
    int ent = 1;
    System.out.println(function(arr, ent));

    System.out.println(function2(arr, ent));
  }

}
