package org.example.users;

import io.qameta.allure.*;
import org.example.PropertyReadHelper;
import org.example.entities.request.RegisterLoginRequestBody;
import org.example.entities.response.RegisterUserResponse;
import org.example.requests.Requests;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;

@Execution(ExecutionMode.CONCURRENT)
public class TestLoginUserResponse {

    @Test
    @DisplayName("Проверка ответа API: авторизация пользователя")
    @Description("Тест отправляет POST-запрос с валидными данными к /login и проверяет корректность ответа")
    @Epic("API")
    @Feature("Авторизация")
    @Story("Авторизация")
    @Severity(SeverityLevel.BLOCKER)
    @Owner("AQA-1")
    public void testLoginUserResponse() {

        RegisterLoginRequestBody user_log = RegisterLoginRequestBody.builder()
                .email(PropertyReadHelper.getPropertyCustom("API_EMAIL"))
                .password(PropertyReadHelper.getPropertyKey("API_REGISTRATION_PASSWORD"))
                .build();

        RegisterUserResponse loginUser = Requests.builder()
                .setSpecs()
                .postLogin(200, user_log);

        Assertions.assertEquals(loginUser.getToken(), "QpwL5tke4Pnpja7X4");
    }
}
