package org.example.users;

import io.qameta.allure.*;
import org.example.entities.request.RegisterLoginRequestBody;
import org.example.entities.response.RegisterUserResponse;
import org.example.extensions.FailureNotifier;
import org.example.extensions.UserExtension;
import org.example.requests.Requests;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Execution(ExecutionMode.CONCURRENT)
@ExtendWith({FailureNotifier.class, UserExtension.class})
public class TestRegisterUserResponse {

    @Test
    @DisplayName("Проверка ответа API: регистрвция пользователя")
    @Description("Тест отправляет POST-запрос с валидными данными к /register и проверяет корректность ответа")
    @Epic("API")
    @Feature("Авторизация")
    @Story("Регистрация")
    @Severity(SeverityLevel.BLOCKER)
    @Owner("AQA-1")
    public void testRegisterUser(RegisterLoginRequestBody user) {

        RegisterUserResponse registerUser = Requests.builder()
                .setSpecs()
                .postRegister(200, user);

        Assertions.assertAll("Проверка id и token пользователя",
                () -> assertEquals(registerUser.getId(), "4"),
                () -> assertEquals(registerUser.getToken(), "QpwL5tke4Pnpja7X4")
                );
    }

}
