package steps;

import model.Data;
import model.User;
import spec.Request;
import utils.FileUtils;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class Steps {

    public void assertResponseElementInListUsersTest() {
        given()
                .spec(Request.spec())// это так принято выносить все?
                .when()
                .get("/users?page=2")
                .then()
                .statusCode(200)
                .log().body()
                .body("data.last_name", hasItem("Lawson"));

    }

    public void assertResponseElementTest() {
        given()
                .spec(Request.spec())
                .when()
                .get("/users?page=2")
                .then()
                .statusCode(200)
                .log().body()
                .body("data.first_name.first()", equalTo("Michael"));
    }

    public void assertResponseElementWithFindConditionTest() {
        given()
                .spec(Request.spec())
                .when()
                .get("/users")
                .then()
                .statusCode(200)
                .log().body()
                .body("data.findAll{it.email =~/.*?reqres.in/}.email.flatten()",
                        hasItem("emma.wong@reqres.in"));
    }

    public void dataContainsNotNullValueTest() {
        given()
                .spec(Request.spec())
                .log().uri()
                .when()
                .get("/users?page=2")
                .then()
                .statusCode(200)
                .body("data", notNullValue());
    }
    public void singleUserAssertTest() {
        given()
                .spec(Request.spec())
                .log().uri()
                .when()
                .get("/users/2")
                .then()
                .statusCode(200)
                .body("data.id", equalTo(2));
    }

    public void singleUserNotFound() {
        given()
                .spec(Request.spec())
                .log().uri()
                .when()
                .get("/users/23")
                .then()
                .statusCode(404);
    }

    public void assertResponseContainedInListResource() {
       Data data = given()
                    .spec(Request.spec())
                    .log().uri()
                .when()
                    .get("/unknown")
                .then()
                    .statusCode(200)
                    .body("data.color", hasItem("#C74375"))
                    .extract().
                    as(Data.class);
    }

    public void createUserAssertIdTest() {
        given()
                    .spec(Request.spec())
                    .log().uri()
               .when()
                    .post("/users")
               .then()
                    .statusCode(201)
                    .log().body()
                    .body("id", notNullValue());
    }

    public void createUserAssertNameTest() {
        User user = new User();
        user.setName("morpheus");
        user.setJob("leader");

        given()
                .spec(Request.spec())
                .body(user)
//                .body(user.getJob())
                .log().uri()
            .when()
                .post("/users")
            .then()
                .statusCode(201)
                .log().body()
                .body("name", equalTo("morpheus"))
                .body("job", equalTo("leader"));
    }

    public void updateUserTest() {
        given()
                .spec(Request.spec())
                .log().uri()
                .body(FileUtils.readFromFile("src/test/resources/updateUser.txt"))
            .when()
                .post("/users/2")
            .then()
                .statusCode(201)
                .log().body()
                .body("name", equalTo("morpheus"));
    }

    public void patchUserTest() {
        given()
                .spec(Request.spec())
                .log().uri()
                .body(FileUtils.readFromFile("src/test/resources/updateUser.txt"))
            .when()
                .patch("/users/2")
            .then()
                .statusCode(200)
                .log().body()
                .body("job", equalTo("zion resident"));
    }

    public void deleteUserTest() {
        given()
                .spec(Request.spec())
                .log().uri()
            .when()
                .delete("/users/2")
            .then()
                .statusCode(204);
    }

    public void registerUser() {
        User user = new User();
        user.setEmail("eve.holt@reqres.in");
        user.setPassword("pistol");

        given()
                .spec(Request.spec())
                //.contentType("application/json; charset=utf-8")
                .log().uri()
                .body(user)
            .when()
                .post("/register")
            .then()
                .statusCode(200)
                .log().body()
                .body("id", equalTo(4))
                .body("token", notNullValue());
    }

    public void unsuccessfulRegistrationUser() {
        User user = new User();
        user.setEmail("sydney@fife");

        given()
                .spec(Request.spec())
                .log().uri()
                .body(user)
            .when()
                .post("/register")
            .then()
                .statusCode(400);
    }

    public void loginUser() {
        User user = new User();
        user.setEmail("eve.holt@reqres.in");
        user.setPassword("cityslicka");

        given()
                .spec(Request.spec())
                .log().uri()
                .body(user)
            .when()
                .post("/login")
            .then()
                .statusCode(200)
                .body("token", notNullValue());
    }

    public void unsuccessfulLoginUser() {
        User user = new User();
        user.setEmail("peter@klaven");

        given()
                .spec(Request.spec())
                .log().uri()
                .body(user)
            .when()
                .post("/login")
            .then()
                .statusCode(400);
    }

    public void delayedResponse() {
        given()
                .spec(Request.spec())
                .log().uri()
            .when()
                .get("users?delay=3")
            .then()
                .statusCode(200)
                .body("data.email", hasItem("george.bluth@reqres.in"));
    }
}