package com.learn;


import io.restassured.response.Response;
import org.testng.annotations.Test;
 import static  io.restassured.RestAssured.*;
import static    io.restassured.matcher.RestAssuredMatchers.*;
import static   org.hamcrest.Matchers.*;

public class LearnTestApi {
 @Test
    public void test1(){
    given().baseUri("https://qacart-academy-api.herokuapp.com")
             .when().get("/api/v1/info/courses")
             .then().log().all();


 }


}
