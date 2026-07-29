package org.example.users;

import org.example.entities.response.UsersResponse;
import org.example.requests.Requests;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;

@Execution(ExecutionMode.CONCURRENT)
public class TestGetUsersResponse {

    static UsersResponse users;

    @BeforeAll
    public static void setUp() {

        users = new Requests().setSpecs().getUsers(2, 200);
    }

    @Test
    public void getUsersTotal() {

        Assertions.assertEquals("12", users.getTotal());
    }

    @Test
    public void getUsersPage() {

        Assertions.assertEquals("2", users.getPage());
    }

    @Test
    public void getUsersPerPage() {

        Assertions.assertEquals("6", users.getPer_page());
    }

    @Test
    public void getUsersTotalPages() {

        Assertions.assertEquals("2", users.getTotal_pages());
    }

    @Test
    public void getUsersDataEmails() {

        Assertions.assertTrue(users.getData().stream().allMatch(x -> x.getEmail().endsWith("@reqres.in")));
    }
}
