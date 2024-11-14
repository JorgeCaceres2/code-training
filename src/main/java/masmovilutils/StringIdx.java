package masmovilutils;

public class StringIdx {

  public static void main(String[] args) {
    int idx = 143;
    String input = "{\"transitionId\": \"341\",\"incidentLocation\":\"Others\",\"responsibleForTheProblem\":\"Otros\",\"administrativeOfTheAffectedCircuit3Pp\":\"50190001242326\n"
        + "50190001242332\",\"3ppTicketCode\": \"20230140957752001\n"
        + "20230140957756001\"}";
    System.out.println("Result: " + input.substring(143));
  }

}
