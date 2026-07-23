package org.example.users;

import org.example.PropertyReadHelper;
import org.example.entities.request.RegisterLoginRequestBody;
import org.example.entities.response.RegisterUserResponse;
import org.example.requests.Requests;
import org.junit.Assert;
import org.junit.Test;

public class TestLoginUserResponse {

    @Test
    public void testLoginUserResponse() {

        RegisterLoginRequestBody user_log = RegisterLoginRequestBody.builder()
                .email(PropertyReadHelper.getPropertyCustom("API_EMAIL"))
                .password(PropertyReadHelper.getPropertyKey("API_REGISTRATION_PASSWORD"))
                .build();

        RegisterUserResponse loginUser = new Requests().setSpecs().postLogin(200, user_log);

        Assert.assertEquals(loginUser.getToken(), "QpwL5tke4Pnpja7X4");
    }
}
