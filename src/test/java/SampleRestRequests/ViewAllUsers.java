package SampleRestRequests;

import io.restassured.RestAssured;
import static  io.restassured.RestAssured.*;
public class ViewAllUsers {

    public static void main(String[] args) {

        RestAssured.baseURI = "https://reqres.in/";

        given().log().all().queryParam("page","2")
                .when().get("/api/users")
                .then().log().all().assertThat().statusCode(200);

    }
}
