package varios;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InstagramFollowersComparison {

    public static void  getResultFromJson (boolean whiteListBypass) throws IOException {
        // Cargar los archivos JSON
        ObjectMapper mapper = new ObjectMapper();

        // Leer y extraer lista de seguidores de src/main/resources/followers_1.json
        List<Map<String, Object>> followersList = mapper.readValue(
                new File("src/main/resources/followers_1.json"),
                new TypeReference<List<Map<String, Object>>>() {}
        );

        // Leer y extraer lista de seguidos
        List<String> following = extractUsernames(mapper.readTree(new File("src/main/resources/following.json")), "relationships_following");

        List<String> usernames = new ArrayList<>();
        for (Map<String, Object> follower : followersList) {
            List<Map<String, Object>> stringListData = (List<Map<String, Object>>) follower.get("string_list_data");
            if (stringListData != null && !stringListData.isEmpty()) {
                for (Map<String, Object> stringData : stringListData) {
                    String username = (String) stringData.get("value");
                    usernames.add(username);
                }
            }
        }

        // Convertir listas a conjuntos para facilitar las operaciones de conjunto
        Set<String> followersSet = new HashSet<>(usernames);
        Set<String> followingSet = new HashSet<>(following);

        System.out.println("followers: " + followersSet.size());
        System.out.println("following: " + followingSet.size());

        // Calcular quiénes te dejaron de seguir
        followingSet.removeAll(followersSet);

        if (whiteListBypass) {
            followingSet.removeAll(getWhiteListedFollowers());
        }

        // Mostrar los resultados
        if (followingSet.isEmpty()) {
            System.out.println("No tienes personas que te hayan dejado de seguir.");
        } else {
            System.out.println("Personas que te dejaron de seguir y que tú sigues:");
            int count = 1;
            for (String user : followingSet) {
                System.out.println(count++ + ". " + user);
            }
        }
    }

    private static List <String> getWhiteListedFollowers () {
        List <String> whiteListedFollowers = new ArrayList<>();
        //extract from txt file
        try (BufferedReader reader = new BufferedReader(new FileReader("src/main/resources/followingWhiteList.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                whiteListedFollowers.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return whiteListedFollowers;
    }

    private static List<String> extractUsernames(JsonNode rootNode, String key) {
        List <String> result = new ArrayList<>();
        JsonNode relationshipsFollowing = rootNode.path(key);

        // Iterar sobre cada elemento en "relationships_following"
        for (JsonNode followingNode : relationshipsFollowing) {
            // Obtener el array de "string_list_data"
            JsonNode stringListData = followingNode.path("string_list_data");

            // Iterar sobre cada elemento en "string_list_data"
            for (JsonNode stringData : stringListData) {
                // Extraer y imprimir el valor de "value"
                String value = stringData.path("value").asText();
                result.add(value);
            }
        }
        return result;
    }


    private static List<String> extractUsernamesFromHTML(String filePath) {
        List<String> usernames = new ArrayList<>();
        Pattern pattern = Pattern.compile("<a[^>]+>([^<]+)</a>");  // Adjust this pattern based on your HTML structure

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                Matcher matcher = pattern.matcher(line);
                while (matcher.find()) {
                    usernames.add(matcher.group(1).trim());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return usernames;
    }


    public static void getResultFromHtml () {
        // Provide the HTML files as input
        String followersFilePath = "src/main/resources/followers_1.html";
        String followingFilePath = "src/main/resources/following.html";

        // Extract usernames from the HTML files
        List<String> followers = extractUsernamesFromHTML(followersFilePath);
        List<String> following = extractUsernamesFromHTML(followingFilePath);

        // Identify who you follow but they don't follow you back
        Set<String> unfollowers = new HashSet<>(following);
        unfollowers.removeAll(followers);

        // Print the result
        System.out.println("followers: " + followers.size());
        System.out.println("following: " + following.size());
        System.out.println("People you follow but don't follow you back:");
        int count = 0;
        for (String user : unfollowers) {

            System.out.println(++count + ": " + user);
        }
    }

    public static void main(String[] args) throws IOException {
        getResultFromJson(false);
    }

}
