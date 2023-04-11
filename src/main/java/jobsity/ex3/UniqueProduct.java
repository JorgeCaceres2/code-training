package jobsity.ex3;

import java.util.HashMap;
import java.util.Map;

public class UniqueProduct {

  public static String firstUniqueProduct(String[] products) {
    Map<String, Integer> productMap = new HashMap<>();

    for (String product : products) {
      productMap.put(product, productMap.getOrDefault(product, 0) + 1);
    }

    for (String product : products) {
      if (productMap.get(product) == 1) {
        return product;
      }
    }

    return null;
  }

}
