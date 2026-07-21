package org.example.requests;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import java.util.HashMap;

public class Specification {

    public static RequestSpecification requestsSpec(String url, String apiKey) {

        HashMap<String, String> headers = new HashMap<>();
        headers.put("Content-Type", "application/json");
        headers.put("x-api-key", apiKey);

        return new RequestSpecBuilder().addHeaders(headers).setBaseUri(url).build();
    }

    public static ResponseSpecification requestsSpecExpectedStatusCode(int status_code) {

        return new ResponseSpecBuilder().expectStatusCode(status_code).build();
    }

    public static void setSpecs(RequestSpecification request, ResponseSpecification response) {

        RestAssured.requestSpecification = request;
        RestAssured.responseSpecification = response;
    }
}
