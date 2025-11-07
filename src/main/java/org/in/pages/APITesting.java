package org.in.pages;

import io.cucumber.java.Scenario;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.in.base.APIRequests;
import org.in.base.SeleniumComponents;
import org.in.utils.TestContext;

import static org.in.base.APIRequests.response1;
import static org.in.utils.TestContext.*;

public class APITesting extends SeleniumComponents {

    public static void triggerGetAPI(){
        Scenario scenario= TestContext.getScenario();
        RestAssured.baseURI ="https://jsonplaceholder.typicode.com" ;
        Response response= APIRequests.getRequest();
        System.out.println("=========="+response);
        System.out.println("GET Response: " + response.asPrettyString());

    }


    public static void triggerPOSTAPI(){
        RestAssured.baseURI ="https://jsonplaceholder.typicode.com" ;
        Response response= APIRequests.postRequest();
        System.out.println("=========="+response);
    }




}
