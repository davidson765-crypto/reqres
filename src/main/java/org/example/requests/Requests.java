package org.example.requests;

import io.restassured.*;
import io.restassured.filter.log.ErrorLoggingFilter;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.specification.RequestSpecification;
import org.example.PropertyReadHelper;
import org.example.entities.request.RegisterLoginRequestBody;
import org.example.entities.response.RegisterUserResponse;
import org.example.entities.response.UserResponse;
import org.example.entities.response.UsersResponse;

public class Requests {

    public String apiKey = PropertyReadHelper.getPropertyKey("API_KEY");

    public String BASE_URL = PropertyReadHelper.getPropertyCustom("API_BASE_URL");

    public RequestSpecification requestSpecification;

    public static Requests builder() {

        return new Requests().setSpecs();
    }

    public Requests setSpecs() {

        requestSpecification = RestAssured.given()
                .header("Content-Type", "application/json")
                .header("x-api-key", apiKey)
                .filter(new RequestLoggingFilter())
                .filter(new ResponseLoggingFilter())
                .filter(new ErrorLoggingFilter())
                .baseUri(BASE_URL)
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

    public RegisterUserResponse postRegister(int status_code, RegisterLoginRequestBody user_reg) {

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

    public RegisterUserResponse postLogin(int status_code, RegisterLoginRequestBody user_log) {

        return requestSpecification
                .body(user_log)
                .post("/login")
                .then()
                .assertThat()
                .statusCode(status_code)
                .extract()
                .response()
                .as(RegisterUserResponse.class);
    }
}
