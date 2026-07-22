package org.example.users;

import org.example.entities.UsersResponse;
import org.example.requests.Requests;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestGetUsersResponse {

    static UsersResponse users;

    @BeforeClass
    public static void setUp() {

        users = new Requests().setSpecs().getUsers(2, 200);
    }

    @Test
    public void getUsersTotal() {

        Assert.assertEquals("12", users.getTotal());
    }

    @Test
    public void getUsersPage() {

        Assert.assertEquals("2", users.getPage());
    }

    @Test
    public void getUsersPerPage() {

        Assert.assertEquals("6", users.getPer_page());
    }

    @Test
    public void getUsersTotalPages() {

        Assert.assertEquals("2", users.getTotal_pages());
    }

    @Test
    public void getUsersDataEmails() {

        Assert.assertTrue(users.getData().stream().allMatch(x -> x.getEmail().endsWith("@reqres.in")));
    }
}
