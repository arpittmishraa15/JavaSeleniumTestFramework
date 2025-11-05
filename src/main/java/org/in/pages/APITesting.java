package org.in.pages;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.in.base.APIRequests;
import org.in.base.SeleniumComponents;

public class APITesting extends SeleniumComponents {

    public static void triggerGetAPI(){
        RestAssured.baseURI ="https://jsonplaceholder.typicode.com" ;
        Response response= APIRequests.getRequest();
        System.out.println("=========="+response);
    }


    public static void triggerPOSTAPI(){
        RestAssured.baseURI ="https://jsonplaceholder.typicode.com" ;
        Response response= APIRequests.postRequest();
        System.out.println("=========="+response);
    }




}
