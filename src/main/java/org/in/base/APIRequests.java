package org.in.base;



import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class APIRequests {


    public static String response1;
    // GET Request Example
    public static Response  getRequest() {
        System.out.println("---- GET Request ----");
        RestAssured.useRelaxedHTTPSValidation();
        Response response = given()
                .contentType(ContentType.JSON)
                .queryParam("userId", 1)
                .when()
                .get("/posts")
                .then()
                .statusCode(200)
                .body("size()", greaterThan(0))
                .extract().response();

        response1= String.valueOf(response);
        System.out.println("GET Response: " + response.asPrettyString());
        return response;
    }


    // ---------------------- POST ----------------------
    public static Response  postRequest() {
        System.out.println("\n---- POST Request ----");

        Map<String, Object> requestBody = new HashMap<>();
        requestBody.put("title", "Automation Post");
        requestBody.put("body", "This post is created via Rest Assured");
        requestBody.put("userId", 101);

        Response response = given()
                .relaxedHTTPSValidation()
                .contentType(ContentType.JSON)
                .body(requestBody)
                .log().all()
                .when()
                .post("/posts")
                .then()
                .log().all()
                .statusCode(201)
                .body("title", equalTo("Automation Post"))
                .extract().response();

        System.out.println("POST Response: " + response.asPrettyString());
        return response;
    }

    // ---------------------- PUT ----------------------
    public static Response  putRequest() {
        System.out.println("\n---- PUT Request ----");

        Map<String, Object> requestBody = new HashMap<>();
        requestBody.put("id", 1);
        requestBody.put("title", "Updated Post");
        requestBody.put("body", "This post is updated via PUT method");
        requestBody.put("userId", 1);

        Response response = given()
                .relaxedHTTPSValidation()
                .contentType(ContentType.JSON)
                .pathParam("id", 1)
                .body(requestBody)
                .log().all()
                .when()
                .put("/posts/{id}")
                .then()
                .log().all()
                .statusCode(200)
                .body("title", equalTo("Updated Post"))
                .extract().response();

        System.out.println("PUT Response: " + response.asPrettyString());
        return response;
    }

    // ---------------------- PATCH ----------------------
    public static Response  patchRequest() {
        System.out.println("\n---- PATCH Request ----");

        Map<String, Object> requestBody = new HashMap<>();
        requestBody.put("title", "Patched Title");

        Response response = given()
                .relaxedHTTPSValidation()
                .contentType(ContentType.JSON)
                .pathParam("id", 1)
                .body(requestBody)
                .log().all()
                .when()
                .patch("/posts/{id}")
                .then()
                .log().all()
                .statusCode(200)
                .body("title", equalTo("Patched Title"))
                .extract().response();

        System.out.println("PATCH Response: " + response.asPrettyString());
        return response;
    }

    // ---------------------- DELETE ----------------------
    public static Response  deleteRequest() {
        System.out.println("\n---- DELETE Request ----");

        Response response = given()
                .relaxedHTTPSValidation()
                .pathParam("id", 1)
                .log().all()
                .when()
                .delete("/posts/{id}")
                .then()
                .log().all()
                .statusCode(anyOf(is(200), is(204)))
                .extract().response();

        System.out.println("DELETE Response: " + response.asPrettyString());
        return response;
    }


}

