package org.example.users.api.regression;

import io.qameta.allure.*;
import org.example.api.entities.response.UsersResponse;
import org.example.api.extensions.FailureNotifier;
import org.example.api.requests.Requests;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(FailureNotifier.class)
public class TestGetUsersResponse {

    @Test
    @DisplayName("Проверка ответа API: получение списка пользователей")
    @Description("Тест отправляет GET-запрос с валидными данными к /users и проверяет корректность ответа")
    @Epic("API")
    @Feature("Пользователи")
    @Story("Пользователи")
    @Severity(SeverityLevel.MINOR)
    @Owner("AQA-1")
    public void getUsers() {

        UsersResponse users = Requests.builder()
                .setSpecs()
                .getUsers(2, 200);

        assertThat(users.getPage()).isEqualTo("2");
        assertThat(users.getTotal()).isEqualTo("12");
        assertThat(users.getPer_page()).isEqualTo("6");
        assertThat(users.getTotal_pages()).isEqualTo("2");
    }
}
