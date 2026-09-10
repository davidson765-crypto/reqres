package org.example.users.api.smoke;

import Base.WireMockHost;
import com.github.tomakehurst.wiremock.client.WireMock;
import io.qameta.allure.*;
import org.example.entities.request.RegisterLoginRequestBody;
import org.example.entities.response.LoginUserResponse;
import org.example.extensions.FailureNotifier;
import org.example.extensions.UserExtension;
import org.example.requests.Requests;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;

import static com.github.tomakehurst.wiremock.client.WireMock.*;

@Execution(ExecutionMode.CONCURRENT)
@ExtendWith({FailureNotifier.class, UserExtension.class})
public class TestLoginUserResponse extends WireMockHost{

    @Step("Настраиваем мок успешного ответа авторизации")
    public void mockSetUp() {

        stubFor(post(urlEqualTo("/login"))
                .withHeader("Content-Type", WireMock.matching("application/json"))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Content-Type", "application/json")
                        .withBody("""
                                {
                                "token": "QpwL5tke4Pnpja7X4"
                                }
                                """)));
    }

    @Test
    @DisplayName("Проверка ответа API: авторизация пользователя")
    @Description("Тест отправляет POST-запрос с валидными данными к /login и проверяет корректность ответа")
    @Epic("API")
    @Feature("Авторизация")
    @Story("Авторизация")
    @Severity(SeverityLevel.BLOCKER)
    @Owner("AQA-1")
    public void testLoginUserResponse(RegisterLoginRequestBody user) {

        mockSetUp();

        LoginUserResponse loginUser = Requests.builder()
                .setSpecsMock()
                .addBaseUrl(baseUrl)
                .postLogin(200, user);

        Assertions.assertEquals(loginUser.getToken(), "QpwL5tke4Pnpja7X4");
    }
}
