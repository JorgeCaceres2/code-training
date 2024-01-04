package luxoft;

import static org.junit.jupiter.api.Assertions.*;

import io.vertx.core.json.JsonObject;
import java.util.Objects;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class TestHelper {

  @Test
  void cualquier2 () {
    JsonObject elm = new JsonObject();
    JsonObject contractor = elm.getJsonObject("contactor");
    var contractorName = contractor.getString("name");
    String[] name = contractorName.split(" ");
    if (name.length < 2) {
      System.out.println("ok");
    }
    Assertions.assertTrue(true);
  }

  @Test
  void cualquier () {
    String jsonStr = """
        {
          "code" : "200",
          "message" : "Ok",
          "contactor" : {
            "id" : "4",
            "name" : "Contrata OBREMO"
          }}""";
    JsonObject elm = new JsonObject(jsonStr);
    JsonObject contractor = elm.getJsonObject("contactor");
    if (Objects.isNull(contractor)) {
      Assertions.fail();
    }

    var contractorName = contractor.getString("name");
    if (Objects.isNull(contractorName)) {
      Assertions.fail();
    }

    String[] name = contractorName.split(" ");
    if (name.length < 2) {
      Assertions.fail();
    }
    Assertions.assertTrue(true);
  }

}