package tests;

import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;
import steps.Steps;

public class TestBase {
    static Steps steps; //что это за тип в java Steps?

    @BeforeAll
    public static void init() { //init это просто название метода?
        steps = new Steps();
        RestAssured.filters(new AllureRestAssured()); //зачем эта строка?
    }
}
