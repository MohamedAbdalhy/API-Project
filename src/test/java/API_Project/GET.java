package API_Project;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import static  io.restassured.RestAssured.*;
import static    io.restassured.matcher.RestAssuredMatchers.*;
import static   org.hamcrest.Matchers.*;
public class GET {
    @Test
    public void test1_GET(){
        //Basic
        given().baseUri("https://63d9b1142af48a60a7be0e95.mockapi.io/api/v1/")
                .when().get("Tasks")
                .then().log().all()
                .assertThat().statusCode(200)
                .assertThat().body("[0].name",is(equalTo("Ms. Amber Torphy")),"name",hasItem("Jaime Windler"))
        ;
    }
    @Test
    public void test2_GET(){
        //With Has Items
        given().baseUri("https://63d9b1142af48a60a7be0e95.mockapi.io/api/v1/")
                .when().get("Tasks")
                .then().log().all().assertThat().statusCode(200)
                .assertThat().body("name",hasItems("Michelle Berge","Edgar Stoltenberg","Gerardo Pfeffer"))
        ;
    }
    @Test
    public void test3_GET(){
        //With Not
        given().baseUri("https://63d9b1142af48a60a7be0e95.mockapi.io/api/v1/")
                .when().get("Tasks")
                .then().log().all().assertThat().statusCode(200)
                .assertThat().body("name",not(hasItem("Mohamed Abdalhy")))
        ;
    }
    @Test
    public void test4_GET(){
        //With Contains "Must the same order and number of data" and containsInAnyOrder
        given().baseUri("https://63d9b1142af48a60a7be0e95.mockapi.io/api/v1/")
                .when().get("Tasks")
                .then().log().all().assertThat().statusCode(200)
                .assertThat().body("name",contains("Ms. Amber Torphy","Lance Runte","Jaime Windler"),"name"
                ,containsInAnyOrder("Lance Runte","Jaime Windler","Ms. Amber Torphy")
                )

        ;
    }
    @Test
    public void test5_GET(){
        // With not empty and hasSize
        given().baseUri("https://63d9b1142af48a60a7be0e95.mockapi.io/api/v1/")
                .when().get("Tasks")
                .then().log().all().assertThat().statusCode(200)
                .assertThat().body("name",is(not(empty())),"name",hasSize(10))
        ;
    }
    @Test
    public void test6_GET(){
        // With extract and show specific item
        Response r1 =
        given().baseUri("https://63d9b1142af48a60a7be0e95.mockapi.io/api/v1/")
                .when().get("Tasks")
                .then().extract().response()
        ;
        System.out.println(r1.asString());
        String r2 = r1.path("[0].name");
        System.out.println(r2);

                ;
    }
    @Test
    public void test7_GET(){
        // With logging in response

                given().baseUri("https://63d9b1142af48a60a7be0e95.mockapi.io/api/v1/")
                        .when().get("Tasks")
                        .then().log().status()
                ;

    }
    @Test
    public void test8_GET(){
        // With logging in request and response

        given().baseUri("https://63d9b1142af48a60a7be0e95.mockapi.io/api/v1/").log().body()
                .when().get("Tasks")
                .then().log().status()
        ;

    }
    @Test
    public void test9_GET(){
        // With logging if we have error

        given().baseUri("https://63d9b1142af48a60a7be0e5.mockapi.io/api/v1/").log().body()
                .when().get("Tasks")
                .then().log().ifError()
        ;
    }




}
