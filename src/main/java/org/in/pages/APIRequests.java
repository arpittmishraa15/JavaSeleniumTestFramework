package org.in.pages;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class APIRequests {
    public static Response getRequest(String endpoint) {

        return RestAssured
                .given()
                .log().all()
                .when()
                .get(endpoint)
                .then()
                .log().all()
                .extract()
                .response();
    }

    public static Response postRequest(String endpoint, String requestBody) {

        return RestAssured
                .given()
                .contentType(ContentType.JSON)
                .body(requestBody)
                .log().all()
                .when()
                .post(endpoint)
                .then()
                .log().all()
                .extract()
                .response();
    }

}
