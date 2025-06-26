package org.in.base;



import io.restassured.RestAssured;
import io.restassured.config.SSLConfig;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.Map;
public class APIRequests {

    public enum HttpMethod {
        GET, POST, PUT, DELETE, PATCH
    }

    public static Response hitApi(String url,
                                  HttpMethod method,
                                  Map<String, String> headers,
                                  Map<String, String> queryParams,
                                  String bodyJson) {

        //  Apply relaxed HTTPS validation
        RestAssured.useRelaxedHTTPSValidation();

        // Optional: Apply SSL config to skip certificate validation
        RestAssured.config = RestAssured.config()
                .sslConfig(SSLConfig.sslConfig().relaxedHTTPSValidation());

        RequestSpecification request = RestAssured
                .given()
                .contentType("application/json");

        if (headers != null) request.headers(headers);
        if (queryParams != null) request.queryParams(queryParams);
        if (bodyJson != null && !bodyJson.isEmpty()) request.body(bodyJson);

        return switch (method) {
            case GET -> request.get(url);
            case POST -> request.post(url);
            case PUT -> request.put(url);
            case DELETE -> request.delete(url);
            case PATCH -> request.patch(url);
            default -> throw new IllegalArgumentException("Invalid HTTP method: " + method);
        };
    }
}

