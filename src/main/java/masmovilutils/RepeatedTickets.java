package masmovilutils;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import org.json.JSONArray;
import org.json.JSONObject;
import java.util.*;

public class RepeatedTickets {


  public static Map<String, Integer> getRepeatedList() {
    Map<String, Integer> map = new HashMap<>();
    int ticketsCount = 0;

    try (BufferedReader bufferedReader = new BufferedReader(new FileReader("src/main/resources/DuplicatedTicketList.json"))) {
      StringBuilder jsonString = new StringBuilder();

      String line;

      while ((line = bufferedReader.readLine()) != null) {
        jsonString.append(line).append("\n");
      }

      JSONArray pages = new JSONArray(jsonString.toString());

      // Process each JSON object in the array
      for (int i = 0; i < pages.length(); i++) {
        JSONArray ticketArray = pages.getJSONObject(i).getJSONArray("tickets");

        for (Object ticket : ticketArray) {
          JSONObject ticketObject = (JSONObject) ticket;
          String key = ticketObject.getString("key");
          map.put(key, map.getOrDefault(key, 0) + 1);
          ticketsCount++;
        }
      }

    } catch (
        IOException e) {
      e.printStackTrace();
    }

    Map<String, Integer> duplicatedTicketsMap = map
        .entrySet()
        .stream()
        .filter(entry -> entry.getValue() > 1)
        .collect(Collectors.toMap(Entry::getKey, Entry::getValue));
    duplicatedTicketsMap.forEach((k, v) -> System.out.println("key: " + k + " ---> value: " + v));
    System.out.println("Processed tickets: " + ticketsCount);

    return duplicatedTicketsMap;
  }


  public static void main(String[] args) {
    getRepeatedList();
  }


}
