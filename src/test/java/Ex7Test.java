import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

public class Ex7Test {

    @Test
    public void testRestAssured() {
        String redirect = "https://playground.learnqa.ru/api/long_redirect";
        int i = 0;
        int StatusCode;
        do {

            Response response = RestAssured
                    .given()
                    .redirects()
                    .follow(false)
                    .when()
                    .get(redirect)
                    .andReturn();

            redirect = response.getHeader("location");
            StatusCode = response.getStatusCode();
            i++;
        }
        while (StatusCode != 200);

        System.out.println(StatusCode);
        System.out.println("количество редиректов:" + i);
    }
}
