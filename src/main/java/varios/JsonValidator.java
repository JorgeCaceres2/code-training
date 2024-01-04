package varios;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonValidator {

  private static String jsonString1 =
      "{\"transitionId\": \"341\",\"incidentLocation\":\"Others\",\"responsibleForTheProblem\":\"Otros\",\"administrativeOfTheAffectedCircuit3Pp\":\"50190001242326\n"
          + "50190001242332\",\"3ppTicketCode\": \"20230140957752001\n"
          + "20230140957756001\" }";
  private static String jsonString2 = "\"{\"transitionId\": \"111\",\"external_system_name\":\"Orange\",\"external_system_info\":\"@Euskaltel\\nMarca K \t5504530\\nont no sincroniza\\nFicheros adjuntos recibidos\",\"external_system_category\":\"Instalación\",\"external_system_subcategory\":\"FTTH_INS_PUERTO SIN SINCRONISMO\",\"attachments_ids\":\"1426124\"}\"";
  private static String jsonString3 = "{\"transitionId\": \"31\",\"3pp_information\":\"\\nHola buenas tardes.\\n\\nTras revisar vemos que no enviáis la C_VLAN1 lo cual esta provocando el error.\\n\\napps/provision-ftth-2.5.0/classes/altaCorporateFTTH/alta_corporate_ftth_request_schema.json\\\\\\\\\\\\#\\\\\\\\\",\\\\\\\\\"pointer\\\\\\\\\":\\\\\\\\\"\\\\\\\\\"}\\\\n    instance: {\\\\\\\\\"pointer\\\\\\\\\":\\\\\\\\\"\\\\\\\\\"}\\\\n    domain: \\\\\\\\\"validation\\\\\\\\\"\\\\n    keyword: \\\\\\\\\"properties\\\\\\\\\"\\\\n    required: [\\\\\\\\\"C_VLAN_1\\\\\\\\\",\\\\\\\\\"S_VLAN\\\\\\\\\",\\\\\\\\\"id_ADMINISTRATIVO\\\\\\\\\"]\\\\n    missing: [\\\\\\\\\"C_VLAN_1\\\\\\\\\"]\\\\n\\\\n)\\\\\"\\n}\\n\\nPor favor relanzar el alta con la estructura de los datos correspondiente.\\n\\nUn saludo. closeOutNarr: FTTH_REVENTA_OTROS\",\"3pp_closure_category\":\"FTTH_REVENTA_OTROS\", \"comments\": [{\"body\":\"\\nHola buenas tardes.\\n\\nTras revisar vemos que no enviáis la C_VLAN1 lo cual esta provocando el error.\\n\\napps/provision-ftth-2.5.0/classes/altaCorporateFTTH/alta_corporate_ftth_request_schema.json\\\\\\\\\\\\#\\\\\\\\\",\\\\\\\\\"pointer\\\\\\\\\":\\\\\\\\\"\\\\\\\\\"}\\\\n    instance: {\\\\\\\\\"pointer\\\\\\\\\":\\\\\\\\\"\\\\\\\\\"}\\\\n    domain: \\\\\\\\\"validation\\\\\\\\\"\\\\n    keyword: \\\\\\\\\"properties\\\\\\\\\"\\\\n    required: [\\\\\\\\\"C_VLAN_1\\\\\\\\\",\\\\\\\\\"S_VLAN\\\\\\\\\",\\\\\\\\\"id_ADMINISTRATIVO\\\\\\\\\"]\\\\n    missing: [\\\\\\\\\"C_VLAN_1\\\\\\\\\"]\\\\n\\\\n)\\\\\"\\n}\\n\\nPor favor relanzar el alta con la estructura de los datos correspondiente.\\n\\nUn saludo. closeOutNarr: FTTH_REVENTA_OTROS\"}]}";


  public static JsonNode solution(String input) {
    JsonNode jsonNode;
    try {
      ObjectMapper objectMapper = new ObjectMapper();
      jsonNode = objectMapper.readTree(input);
    } catch (JsonProcessingException e) {
      throw new RuntimeException(e);
    }
    System.out.println("result: " + jsonNode.toString());
    return jsonNode;
  }

  public static void main(String[] args) {
    solution(jsonString1);
    solution(jsonString2);
    solution(jsonString3);

  }

}
