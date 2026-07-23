package org.example.users;

import org.example.PropertyReadHelper;
import org.example.entities.request.RegisterLoginRequestBody;
import org.example.entities.response.RegisterUserResponse;
import org.example.requests.Requests;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestRegisterUserResponse {

    @Test
    public void testRegisterUser() {

        RegisterLoginRequestBody user_reg = RegisterLoginRequestBody.builder()
                .email(PropertyReadHelper.getPropertyCustom("api.email"))
                .password(PropertyReadHelper.getPropertyKey("API_REGISTRATION_PASSWORD"))
                .build();

        RegisterUserResponse registerUser = new Requests().setSpecs().postRegister(200, user_reg);

        Assertions.assertAll("Проверка id и token пользователя",
                () -> assertEquals(registerUser.getId(), "4"),
                () -> assertEquals(registerUser.getToken(), "QpwL5tke4Pnpja7X4")
                );
    }

}
