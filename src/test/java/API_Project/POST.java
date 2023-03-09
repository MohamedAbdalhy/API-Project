package API_Project;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;

import static  io.restassured.RestAssured.*;
import static    io.restassured.matcher.RestAssuredMatchers.*;
import static   org.hamcrest.Matchers.*;
public class POST {
    @Test
    public void test1_GET(){
        File body = new File("src/test/resources/add.json");

        given().baseUri("https://63d9b1142af48a60a7be0e95.mockapi.io/api/v1/")
                .contentType(ContentType.JSON)
                .body(body)
                .when().post("Tasks")
                .then().log().all()
                .assertThat().statusCode(201)
                .assertThat().body("[0].id",is(equalTo("15")),"name",hasItem("Mohamed Abdalhy"))
        ;
    }

}
