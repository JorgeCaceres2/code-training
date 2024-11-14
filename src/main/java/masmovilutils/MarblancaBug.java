package masmovilutils;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class MarblancaBug {

  public static void findNumber () {

    try (BufferedReader bufferedReader = new BufferedReader(new FileReader("src/main/resources/marblanca2.json"))) {
      StringBuilder jsonString = new StringBuilder();
      String line;

      while ((line = bufferedReader.readLine()) != null) {
        jsonString.append(line).append("\n");
      }

      JSONObject jsonObject = new JSONObject(jsonString.toString());

      JSONArray jsonArray = jsonObject.getJSONArray("workorderservices");
      for (Object obj : jsonArray) {
        JSONObject body = (JSONObject) obj;
        Integer result = getIntegerOrNull(body, "daddphonenumber");
        String serviceType = body.getString("workorderservicetype");
        System.out.println("workorderservicetype: " + serviceType + "daddphonenumber: " + result);
      }


    } catch (
        IOException e) {
      e.printStackTrace();
    }



  }

  private static Integer getIntegerOrNull(JSONObject jsonObject, String fieldName) {
    try {
      int result = jsonObject.getInt(fieldName);
      return result;
    } catch (JSONException e) {
      System.out.println("JsonException");
    }
    return null;
  }

  public static void main(String[] args) {
   findNumber();
  }

}
