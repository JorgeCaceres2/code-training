package masmovilutils;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import org.json.JSONArray;
import org.json.JSONObject;

public class TicketErrorListFormatter {

  public static void getTicketKeys() {

    try (BufferedReader bufferedReader = new BufferedReader(new FileReader("src/main/resources/ticketErrorList.json"))) {
      StringBuilder jsonString = new StringBuilder();
      StringBuilder result = new StringBuilder();
      int n = 0;
      String line;

      while ((line = bufferedReader.readLine()) != null) {
        jsonString.append(line).append("\n");
      }

      JSONObject jsonObject = new JSONObject(jsonString.toString());


      JSONArray jsonArray = new JSONArray(jsonObject.getJSONArray("errorList"));
      for (Object obj : jsonArray) {
        JSONObject body = (JSONObject) obj;
        result.append(body.get("Key")).append(", ");
        n ++;
      }

      System.out.println("Results:" + n + ", List: " +result.substring(0, result.toString().length() - 2));

    } catch (
        IOException e) {
      e.printStackTrace();
    }
  }


  public static void main(String[] args) {
   getTicketKeys();
  }

}
