import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;

import java.util.HashMap;
import java.util.Map;

public class Ex5Test {
    @Test
    public void testRestAssured(){
        Map<String, String> params = new HashMap<>();
        params.put("name", "Maria");

        JsonPath response = RestAssured
                .given()
                .queryParams(params)
                .get("https://playground.learnqa.ru/api/get_json_homework")
                .jsonPath();
        response.prettyPrint();

        ArrayList<JsonPath> messages = new ArrayList<JsonPath>(response.get("messages"));
        JsonPath message2 = messages.get(1);
        String message2text = message2.get("message");
        System.out.println(message2text);

    }
}
