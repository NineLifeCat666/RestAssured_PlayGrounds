package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;

public class ReqResInTests extends TestBase {

    @Test
    @DisplayName("Проверка на наличие элемента в ответе List Users")
    void assertResponseElementInListUsersTest() {
        step("Поиск элемента в листе List User", () -> {
            steps.assertResponseElementInListUsersTest();
        });
    }

    @Test
    @DisplayName("Проверка наличия элемента равного проверямому через first() и equalTo")
    void assertResponseElementTest() {
        step("Поиск и проверка эдемента в List User", () -> {
            steps.assertResponseElementTest();
        });
    }

    @Test
    @DisplayName("Проверка элемента по findAll{condition} в List User")
    void assertResponseElementWithFindConditionTest() {
        step("Проверка наличия элемента через findAll{condition} Users", () -> {
            steps.assertResponseElementWithFindConditionTest();
        });
    }

    @Test
    @DisplayName("Проверка даты на нулевое значение List User")
    void dataContainsNotNullValueTest() {
        step("Дата содержит", () -> {
            steps.dataContainsNotNullValueTest();
        });
    }

    @Test
    @DisplayName("Проверка id  в Single User ")
    void singleUserAssertTest() {
        step("Проверка значения id в Single User", () -> {
            steps.singleUserAssertTest();
        });

    }

    @Test
    @DisplayName("Single User не найден")
    void singleUserNotFound() {
        step("Пользователь не найден", () -> {
            steps.singleUserNotFound();
        });
    }

    @Test
    @DisplayName("Проверка наличия элемента в List<Resource>")
    void assertResponseContainedInListResource() {
        step("Проверка наличия элемента в  List<Resource>", () -> {
            steps.assertResponseContainedInListResource();
        });
    }

    @Test
    @DisplayName("Создание пользователя - проверка id")
    void createUserAssertIdTest() {
        step("Создание нового пользовтеля, проверка ответа по id", () -> {
            steps.createUserAssertIdTest();
        });
    }

    @Test
    @DisplayName("Создание пользователя - проверка name, job")
    void createUserAssertNameTest() {
        step("Создание нового пользователя, проверка по name, job", () -> {
            steps.createUserAssertNameTest();
        });
    }

    @Test
    @DisplayName("Update user")
    void updateUserTest() {
        step("Update пользователя", () -> {
           steps.updateUserTest();
        });
    }

    @Test
    @DisplayName("Patch user")
    void patchUserTest() {
        step("Проверка patch запроса пользователя", () -> {
           steps.patchUserTest();
        });
    }

    @Test
    @DisplayName("Delete user")
    void deleteUserTest() {
        step("Удаление пользователя", () -> {
           steps.deleteUserTest();
        });
    }



}



//todo Можно сделать, например, предикат на проверку имени для модели, как я показывал на лекции:
//public Predicate<Employee> nameContains(String sequence) {
//        return employee -> employee.getName().contains(sequence);
//    }
//Тут мы делали фильтр по именам, которые содержат какую-то последовательность букв














