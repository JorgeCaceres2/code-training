package utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class TicketFormatter {

  static void formatString() {
    int batchSize = 50; // Number of strings in each batch

    String outputString = "key in (%s)";

    StringBuilder resultBuilder = new StringBuilder();
    int count = 0;

    try (BufferedReader reader = new BufferedReader(new FileReader("src/main/resources/ticketList.txt"))) {
        String line = null;
      while ((line = reader.readLine()) != null) {
        //System.out.println("result: \n" + line.replace(",", "\n").replace("\"",""));
        String modifiedLine = "\"" + line + "\"";
        resultBuilder.append(modifiedLine).append(",");
        count++;

        if (count % batchSize == 0) {
          String result = resultBuilder.toString();
          result = result.substring(0, result.length() - 1); // Remove the trailing comma
          //System.out.println("Batch[" + idx++ + "]: " + result);
          System.out.printf((outputString) + "%n",result);
          resultBuilder.setLength(0); // Clear the StringBuilder for the next batch
        }
      }

      // Print the remaining strings if any
      if (resultBuilder.length() > 0) {
        String result = resultBuilder.toString();
        result = result.substring(0, result.length() - 1); // Remove the trailing comma
        //System.out.println("Batch[" + idx++ + "]: " + result);
        System.out.printf((outputString) + "%n",result);
      }

    
    } catch (FileNotFoundException e) {
      throw new RuntimeException(e);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }


  }

  static void formatString2() {
    int batchSize = 50; // Number of strings in each batch

    String outputString = "%s";

    StringBuilder resultBuilder = new StringBuilder();
    int count = 0;

    try (BufferedReader reader = new BufferedReader(new FileReader("src/main/resources/ticketList.txt"))) {
      String line = null;
      while ((line = reader.readLine()) != null) {

        String modifiedLine = "\"" + line + "\"";
        resultBuilder.append(modifiedLine).append(" OR ");
        count++;

        if (count % batchSize == 0) {
          String result = resultBuilder.toString();
          result = result.substring(0, result.length() - 4); // Remove the trailing comma
          //System.out.println("Batch[" + idx++ + "]: " + result);
          System.out.printf((outputString) + "%n",result);
          resultBuilder.setLength(0); // Clear the StringBuilder for the next batch
        }
      }

      // Print the remaining strings if any
      if (resultBuilder.length() > 0) {
        String result = resultBuilder.toString();
        result = result.substring(0, result.length() - 4); // Remove the trailing comma
        //System.out.println("Batch[" + idx++ + "]: " + result);
        System.out.printf((outputString) + "%n",result);
      }


    } catch (FileNotFoundException e) {
      throw new RuntimeException(e);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }


  }

  public static void main(String[] args) {
    formatString();
    //formatString2();
  }
}
