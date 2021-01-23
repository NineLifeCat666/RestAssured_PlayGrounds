import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItem;

public class ReqresInTests {

    @BeforeAll
    @DisplayName("Setup settings for tests")
    static void setUp(){
        RestAssured.filters(new AllureRestAssured()); //зачем эта строка?
        RestAssured.baseURI = "https://reqres.in";
    }

    /*
    накидать сценарии,что можно тут проверить?
    при тестировании api RestAssured
    1. Что такой - то эдемент в data равен проверяемому
    2. Что такой - то элемент содержится в data +
    3. Что такой - то элемент не равен нулю
    4. извлечения значений после валидации (rest assured documentation)
     */

    @Test
    void successfulHasItemInlListUsersTest() {
        String contentType = "application/json; charset=utf-8";
        String cookie = "__cfduid=d13130dc652d8c9706f805b3da4628d481611168472; _ga=GA1.2.476192070.1611396245; _gid=GA1.2.1007837304.1611396245; _gat=1; _gat_gtag_UA_174008107_1=1; __stripe_mid=64a7ba76-7ef0-403a-8d6d-9f2e950f1fcd39b9c4; __stripe_sid=7486229b-e59f-4720-b237-381c502ec166d85208";

        given()
                .contentType(contentType)
                .cookie(cookie)
                .when()
                .get("/api/users?page=2")
                .then()
                .statusCode(200)
                .log().body()
                .body("data.last_name", hasItem("Lawson"));
    }
}
