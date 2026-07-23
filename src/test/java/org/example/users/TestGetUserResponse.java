package org.example.users;

import io.qameta.allure.*;
import org.example.entities.response.UserResponse;
import org.example.requests.Requests;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.ParameterizedTest;

public class TestGetUserResponse {

    @ParameterizedTest
    @CsvFileSource(resources = "/users.csv", numLinesToSkip = 1)
    @DisplayName("Проверка ответа API: полчение пользователя")
    @Description("Тест отправляет GET-запрос с валидными данными к /users/id и проверяет корректность ответа")
    @Epic("API")
    @Feature("Пользователи")
    @Story("Пользователь")
    @Severity(SeverityLevel.MINOR)
    @Owner("AQA-1")
    public void testGetUser(String id, String email, String first_name, String last_name, String avatar) {

        UserResponse.UserData user_actual = new Requests()
                .setSpecs()
                .getUser(id, 200)
                .getData();

        UserResponse.UserData user_expected = UserResponse.UserData.builder()
                .first_name(first_name)
                .last_name(last_name)
                .email(email)
                .avatar(avatar)
                .id(id)
                .build();

        Assertions.assertEquals(user_actual, user_expected);
    }
}
