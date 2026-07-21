package org.example.users;

import org.example.entities.UserResponse;
import org.example.requests.Requests;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.ParameterizedTest;

import java.util.HashMap;

public class TestGetUserResponse {

    @ParameterizedTest
    @CsvFileSource(resources = "/users.csv", numLinesToSkip = 1)
    public void testGetUser(String id, String email, String first_name, String last_name, String avatar) {

        UserResponse.UserData userData = new Requests().setSpecs().getUser(id, 200).getData();

        HashMap<String, String> userBodyExpected = new HashMap<>();

        userBodyExpected.put("id", id);
        userBodyExpected.put("email", email);
        userBodyExpected.put("first_name", first_name);
        userBodyExpected.put("last_name", last_name);
        userBodyExpected.put("avatar", avatar);

        HashMap<String, String> userBodyActual = new HashMap<>();

        userBodyActual.put("id", userData.getId());
        userBodyActual.put("email", userData.getEmail());
        userBodyActual.put("first_name", userData.getFirst_name());
        userBodyActual.put("last_name", userData.getLast_name());
        userBodyActual.put("avatar", userData.getAvatar());

        Assertions.assertEquals(userBodyActual, userBodyExpected);
    }
}
