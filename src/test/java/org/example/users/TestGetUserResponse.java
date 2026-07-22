package org.example.users;

import org.example.entities.UserResponse;
import org.example.requests.Requests;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.ParameterizedTest;

public class TestGetUserResponse {

    @ParameterizedTest
    @CsvFileSource(resources = "/users.csv", numLinesToSkip = 1)
    public void testGetUser(String id, String email, String first_name, String last_name, String avatar) {

        UserResponse.UserData user_actual = new Requests().setSpecs().getUser(id, 200).getData();

        UserResponse.UserData user_expected = new UserResponse.UserData()
                .setId(id)
                .setEmail(email)
                .setAvatar(avatar)
                .setFirst_name(first_name)
                .setLast_name(last_name);

        Assertions.assertEquals(user_actual, user_expected);
    }
}
