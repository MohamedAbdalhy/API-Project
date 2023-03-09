package API_Project;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import static  io.restassured.RestAssured.*;
import static    io.restassured.matcher.RestAssuredMatchers.*;
import static   org.hamcrest.Matchers.*;
public class DELETE {
    @Test
    public void test1(){

    given().baseUri("https://63d9b1142af48a60a7be0e95.mockapi.io/api/v1/")
                .when().delete("/Tasks/:id/:5")
                .then().log().all()
                .assertThat().statusCode(200)
                .assertThat().body("[0].name",is(equalTo("Ms. Amber Torphy")),"name",hasItem("Jaime Windler"))
    ;
}
}
