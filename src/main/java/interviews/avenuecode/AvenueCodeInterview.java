package interviews.avenuecode;

import java.net.URI;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class AvenueCodeInterview {


  public static int numDevices(String statusQuery, int threshold, String dateStr) {
    int numDevices = 0;
    LocalDateTime localDateTimeParam = null;
    Double thresholdDouble = (double) threshold;
    try {
      Date dataParam = new SimpleDateFormat("MM-yyyy").parse(dateStr);
      localDateTimeParam = dataParam.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
    } catch (ParseException e) {
      e.printStackTrace();
    }

    //assuming that the objective is not to know first the number of pages,
    // and then call the endpoint after getting the number of pages

    JSONArray jsonArray = getResultPerPages(statusQuery, 1);
    jsonArray.putAll(getResultPerPages(statusQuery, 2));
    jsonArray.putAll(getResultPerPages(statusQuery, 3));

    for (int i = 0; i < jsonArray.length(); i++) {
      JSONObject jsonObject = jsonArray.getJSONObject(i);
      double rootThreshold = jsonObject.getJSONObject("operatingParams").getDouble("rootThreshold");
      Date jsonDate = new Date(jsonObject.getLong("timestamp"));
      LocalDateTime jsonDateTime = jsonDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
      if (jsonDateTime.getMonth().equals(localDateTimeParam.getMonth())
          && jsonDateTime.getYear() == localDateTimeParam.getYear()
          && thresholdDouble >= rootThreshold) {
//        System.out.println("param: " +localDateTimeParam + ", matchedDate: "+ jsonDateTime);
//        System.out.println("Matched device: " + jsonObject);
        numDevices ++;
      }


    }

    return numDevices;
  }

  private static JSONArray getResultPerPages(String query, int pageNumber) {
    String uriStr = String.format("https://jsonmock.hackerrank.com/api/iot_devices/search?status=%s&page=%d",
        query, pageNumber);
    RestTemplate restTemplate = new RestTemplate();
    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.APPLICATION_JSON);
    RequestEntity requestEntity = new RequestEntity(headers, HttpMethod.GET, URI.create(uriStr));
    ResponseEntity<String> responseEntity = restTemplate.exchange(requestEntity, String.class);
    JSONObject jsonObject = new JSONObject(responseEntity.getBody());
    JSONArray jsonArray = jsonObject.getJSONArray("data");
    return jsonArray;

  }

  public static void main(String[] args) {
    numDevices("STOPPED", 45, "04-2019");
  }
}
