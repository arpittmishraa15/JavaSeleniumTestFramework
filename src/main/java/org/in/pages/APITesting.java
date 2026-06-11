package org.in.pages;

import io.cucumber.java.Scenario;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.in.base.SeleniumComponents;
import org.in.utils.TestContext;
import org.junit.Assert;



public class APITesting extends SeleniumComponents {
    public static void triggerGetAPI() {

        Scenario scenario = TestContext.getScenario();

        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";

        Response response = APIRequests.getRequest("/posts/1");

        scenario.log("Response Code: " + response.getStatusCode());
        scenario.log("Response Body: \n" + response.asPrettyString());

        System.out.println("Response Code: " + response.getStatusCode());
        System.out.println(response.asPrettyString());
    }

    public static void triggerPostAPI() {

        Scenario scenario = TestContext.getScenario();

        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";

        String requestBody = """
                {
                  "title":"My First API Test",
                  "body":"Learning Rest Assured",
                  "userId":1
                }
                """;

        Response response = APIRequests.postRequest("/posts", requestBody);

        scenario.log("Response Code: " + response.getStatusCode());
        scenario.log("Response Body: \n" + response.asPrettyString());
        Assert.assertEquals(200, response.getStatusCode());
        System.out.println("Response Code: " + response.getStatusCode());
        System.out.println(response.asPrettyString());
    }
}