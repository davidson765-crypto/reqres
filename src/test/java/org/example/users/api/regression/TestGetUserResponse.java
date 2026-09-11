package org.example.users.api.regression;

import io.qameta.allure.*;
import org.example.api.entities.response.UserResponse;
import org.example.api.extensions.FailureNotifier;
import org.example.api.requests.Requests;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.ParameterizedTest;

@ExtendWith(FailureNotifier.class)
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

        UserResponse.UserData user_actual = Requests.builder()
                .setSpecs()
                .getUser(id, 200)
                .getData();

        assertThat(user_actual.getId()).isEqualTo(id);
        assertThat(user_actual.getEmail()).isEqualTo(email);
        assertThat(user_actual.getFirst_name()).isEqualTo(first_name);
        assertThat(user_actual.getLast_name()).isEqualTo(last_name);
        assertThat(user_actual.getAvatar()).isEqualTo(avatar);
    }
}
