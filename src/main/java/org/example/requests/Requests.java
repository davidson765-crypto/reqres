package org.example.requests;

import io.restassured.*;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.example.PropertyReadHelper;
import org.example.entities.response.RegisterUserResponse;
import org.example.entities.response.UserResponse;
import org.example.entities.response.UsersResponse;

import java.util.HashMap;

public class Requests {

    public String apiKey = PropertyReadHelper.getPropertyKey("api.key");

    public String BASE_URL = PropertyReadHelper.getPropertyCustom("api.baseUrl");

    public RequestSpecification requestSpecification;

    public Requests setSpecs() {

        requestSpecification = RestAssured.given()
                .header("Content-Type", "application/json")
                .header("x-api-key", apiKey)
                .baseUri(BASE_URL)
                .log()
                .all()
                .when();

        return this;
    }

    public UsersResponse getUsers(int page, int status_code) {

        return requestSpecification
                .queryParam("page", page)
                .get("/users")
                .then()
                .assertThat()
                .statusCode(status_code)
                .extract()
                .response()
                .as(UsersResponse.class);
    }

    public UserResponse getUser(String user_id, int status_code) {

        return requestSpecification
                .get("/users" + "/" + user_id)
                .then()
                .assertThat()
                .statusCode(status_code)
                .extract()
                .response()
                .as(UserResponse.class);
    }

    public RegisterUserResponse postRegister(int status_code) {

        HashMap<String, String> user_reg = new HashMap<>();

        user_reg.put("email", PropertyReadHelper.getPropertyCustom("api.email"));
        user_reg.put("password", PropertyReadHelper.getPropertyCustom("api.register_password"));

        return requestSpecification
                .body(user_reg)
                .post("/register")
                .then()
                .assertThat()
                .statusCode(status_code)
                .extract()
                .response()
                .as(RegisterUserResponse.class);
    }

    public Response postLogin(int status_code) {

        HashMap<String, String> user_log = new HashMap<>();

        user_log.put("email", PropertyReadHelper.getPropertyCustom("api.email"));
        user_log.put("password", PropertyReadHelper.getPropertyCustom("api.login_password"));

        return requestSpecification
                .body(user_log)
                .post("/login")
                .then()
                .assertThat()
                .statusCode(status_code)
                .extract()
                .response();
    }
}
