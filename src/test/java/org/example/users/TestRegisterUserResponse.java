package org.example.users;

import org.example.entities.RegisterUserResponse;
import org.example.requests.Requests;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestRegisterUserResponse {

    @Test
    public void testRegisterUser() {

        RegisterUserResponse registerUser = new Requests().setSpecs().postRegister(200);

        Assertions.assertAll("Проверка id и token пользователя",
                () -> assertEquals(registerUser.getId(), "4"),
                () -> assertEquals(registerUser.getToken(), "QpwL5tke4Pnpja7X4")
                );
    }

}
