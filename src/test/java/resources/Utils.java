package resources;

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
import java.util.Properties;

public class Utils {

    public static final String path = System.getProperty("user.dir");
    public static RequestSpecification req;
    static Properties prop;

    public static String getGlobalValue(String key) throws IOException {
        prop = new Properties();
        FileInputStream fis =
                new FileInputStream(
                        path+"\\src\\test\\java\\resources\\globalProperties.properties");
        prop.load(fis);
        return prop.getProperty(key);
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
}
