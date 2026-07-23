package org.example.users;

import io.qameta.allure.*;
import jdk.jfr.Description;
import org.example.PropertyReadHelper;
import org.example.entities.request.RegisterLoginRequestBody;
import org.example.entities.response.RegisterUserResponse;
import org.example.requests.Requests;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestRegisterUserResponse {

    @Test
    @DisplayName("Проверка ответа API: регистрвция пользователя")
    @Description("Тест отправляет POST-запрос с валидными данными к /register и проверяет корректность ответа")
    @Epic("API")
    @Feature("Авторизация")
    @Story("Регистрация")
    @Severity(SeverityLevel.BLOCKER)
    @Owner("AQA-1")
    public void testRegisterUser() {

        RegisterLoginRequestBody user_reg = RegisterLoginRequestBody.builder()
                .email(PropertyReadHelper.getPropertyCustom("API_EMAIL"))
                .password(PropertyReadHelper.getPropertyKey("API_REGISTRATION_PASSWORD"))
                .build();

        RegisterUserResponse registerUser = new Requests().setSpecs().postRegister(200, user_reg);

        Assertions.assertAll("Проверка id и token пользователя",
                () -> assertEquals(registerUser.getId(), "4"),
                () -> assertEquals(registerUser.getToken(), "QpwL5tke4Pnpja7X4")
                );
    }

}
