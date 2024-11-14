package masmovilutils;

import org.apache.commons.text.StringEscapeUtils;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class jsonFormatter {
    public static void main(String[] args) {
        String inputFile = "src/main/resources/file.txt";
        String outputFile = "src/main/resources/file2.txt";
        String duplicatesFile = "src/main/resources/duplicates.txt";
        Map<String, Integer> entryCount = new HashMap<>();
        Map<String, String> entryDetails = new HashMap<>();
        StringBuilder jsonString = new StringBuilder();

        // Read the JSON string from file.txt
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                jsonString.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        String unescapedJsonString = StringEscapeUtils.unescapeJson(jsonString.toString());
        JSONArray jsonArray = new JSONArray(unescapedJsonString);

        // Write the rowIds to file2.txt
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                writer.write(jsonObject.toString());
                writer.newLine();  // Add a new line after each rowId
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


        // Read and process the file
        try (BufferedReader reader = new BufferedReader(new FileReader(outputFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Parse each line as a JSON object
                JSONObject jsonObject = new JSONObject(line);

                // Get the "comment" and "author" fields
                String comment = jsonObject.getString("comment");
                String author = jsonObject.getString("author");
                String rowId = jsonObject.getString("rowId");
                String date = jsonObject.getString("date");

                // Create a unique key based on "comment" and "author"
                String uniqueKey = date + "|" + rowId + "|" +comment + "|" + author;

                // Update the count for this unique key
                entryCount.put(uniqueKey, entryCount.getOrDefault(uniqueKey, 0) + 1);

                // Store the original JSON string (first occurrence)
                entryDetails.putIfAbsent(uniqueKey, line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Write the duplicates and their counts to the output file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(duplicatesFile))) {
            for (Map.Entry<String, Integer> entry : entryCount.entrySet()) {
                if (entry.getValue() > 1) {
                    writer.write("Duplicate found " + entry.getValue() + " times:");
                    writer.newLine();
                    writer.write(entryDetails.get(entry.getKey()));
                    writer.newLine();
                    writer.newLine();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
