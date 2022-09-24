package resources;

import com.api.pojo.Player;
import com.api.pojo.PlayerResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class Utils {

    public static final String path = System.getProperty("user.dir");
    public static RequestSpecification req;
    static Properties prop;

    private static ObjectMapper objectMapper;

    static {
        try {
            objectMapper = getObjectMapper();
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    public static String getGlobalValue(String key) throws IOException {
        prop = new Properties();
        FileInputStream fis =
                new FileInputStream(
                        path + "\\src\\test\\java\\resources\\globalProperties.properties");
        prop.load(fis);
        return prop.getProperty(key);
    }

    public static ObjectMapper getObjectMapper() throws JsonProcessingException {
        Player pl = new Player();
        pl.setName("Faf Du Plessis");
        pl.setCountry("South Africa");
        pl.setRole("Batsman");
        pl.getPriceInCrores(0.0);
        Player pl1 = new Player();
        pl1.setName("Virat Kohli");
        pl1.setCountry("India");
        pl1.setRole("Batsman");
        pl1.setPriceInCrores(15);
        Player pl2 = new Player();
        pl2.setName("Glenn Maxwell");
        pl2.setCountry("Australia");
        pl2.setRole("Batsman");
        pl2.setPriceInCrores(11);
        Player pl3 = new Player();
        pl3.setName("Mohammad Siraj");
        pl3.setCountry("India");
        pl3.setRole("Bowler");
        pl3.setPriceInCrores(7);
        Player pl4 = new Player();
        pl4.setName("Harshal Patel");
        pl4.setCountry("India");
        pl4.setRole("Bowler");
        pl4.setPriceInCrores(10.75);
        Player pl5 = new Player();
        pl5.setName("Wanindu Hasaranga");
        pl5.setCountry("Srilanka");
        pl5.setRole("Bowler");
        pl5.setPriceInCrores(10.75);
        Player pl6 = new Player();
        pl6.setName("Dinesh Karthik");
        pl6.setCountry("India");
        pl6.setRole("Wicket-keeper");
        pl6.setPriceInCrores(5.5);
        Player pl7 = new Player();
        pl7.setName("Shahbaz Ahmed");
        pl7.setCountry("India");
        pl7.setRole("All-Rounder");
        pl7.setPriceInCrores(2.4);
        Player pl8 = new Player();
        pl8.setName("Rajat Patidar");
        pl8.setCountry("India");
        pl8.setRole("Batsman");
        pl8.setPriceInCrores(0.20);
        Player pl9 = new Player();
        pl9.setName("Josh Hazlewood");
        pl9.setCountry("Australia");
        pl9.setRole("Bowler");
        pl9.setPriceInCrores(7.75);
        Player pl10 = new Player();
        pl10.setName("Mahipal Lomror");
        pl10.setCountry("India");
        pl10.setRole("Bowler");
        pl10.setPriceInCrores(7.75);

        List<Player> list = new ArrayList<>();
        list.add(pl);
        list.add(pl1);
        list.add(pl2);
        list.add(pl3);
        list.add(pl4);
        list.add(pl5);
        list.add(pl6);
        list.add(pl7);
        list.add(pl8);
        list.add(pl9);
        list.add(pl10);
        PlayerResponse player = new PlayerResponse("Royal Challengers Bangalore", "Bangalore", list);
        ObjectMapper objectMapper = new ObjectMapper();
        String con = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(player);
        return objectMapper;

    }

    public static JsonNode parse(String src) throws JsonProcessingException {
        return getObjectMapper().readTree(src);
    }

    public RequestSpecification requestSpecification() throws IOException {

        if (req == null) {
            PrintStream log = new PrintStream(new FileOutputStream("logging.txt"));
            req =
                    new RequestSpecBuilder()
                            .setBaseUri(getGlobalValue("baseUri"))
                            .addQueryParam("", "")
                            .addFilter(RequestLoggingFilter.logRequestTo(log))
                            .addFilter(ResponseLoggingFilter.logResponseTo(log))
                            .build();
            return req;
        }
        return req;
    }

    public String getJsonPath(Response response, String key) {
        String resp = response.asString();
        JsonPath js = new JsonPath(resp);
        return js.get(key).toString();
    }

    public static <A> A fromJson(JsonNode node, Class<A> clazz) throws JsonProcessingException {

        return objectMapper.treeToValue(node,clazz);

    }

}
