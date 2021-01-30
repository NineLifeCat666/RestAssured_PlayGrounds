package tests;

import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;
import steps.Steps;

public class TestBase {
    static Steps steps;

    @BeforeAll
    public static void init() {
        steps = new Steps();
        RestAssured.filters(new AllureRestAssured());
    }
}
