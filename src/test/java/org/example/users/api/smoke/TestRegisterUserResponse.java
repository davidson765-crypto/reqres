package org.example.users.api.smoke;

import Base.mock.WireMockHost;
import com.github.tomakehurst.wiremock.client.WireMock;
import io.qameta.allure.*;
import org.example.api.entities.request.RegisterLoginRequestBody;
import org.example.api.entities.response.RegisterUserResponse;
import org.example.api.extensions.FailureNotifier;
import org.example.api.extensions.UserExtension;
import org.example.api.requests.Requests;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtendWith;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith({FailureNotifier.class, UserExtension.class})
public class TestRegisterUserResponse extends WireMockHost{

    @Step("Настраиваем мок успешного ответа регистрации")
    public void mockSetUp() {


        stubFor(post(urlEqualTo("/register"))
                .withHeader("Content-Type", WireMock.matching("application/json"))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Content-Type", "application/json")
                        .withBody("""
                                {
                                "id": 4,
                                "token": "QpwL5tke4Pnpja7X4"
                                }
                                """)));
    }

    @Test
    @DisplayName("Проверка ответа API: регистрация пользователя")
    @Description("Тест отправляет POST-запрос с валидными данными к /register и проверяет корректность ответа")
    @Epic("API")
    @Feature("Авторизация")
    @Story("Регистрация")
    @Severity(SeverityLevel.BLOCKER)
    @Owner("AQA-1")
    public void testRegisterUser(RegisterLoginRequestBody user) {

        mockSetUp();

        RegisterUserResponse registerUser = Requests.builder()
                .setSpecsMock()
                .addBaseUrl(baseUrl)
                .postRegister(200, user);

        Assertions.assertAll("Проверка id и token пользователя",
                () -> assertEquals("4", registerUser.getId()),
                () -> assertEquals("QpwL5tke4Pnpja7X4", registerUser.getToken())
                );
    }

}
