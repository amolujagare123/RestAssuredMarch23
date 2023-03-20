package SampleRestRequests;

import io.restassured.RestAssured;

import static PayLoad.SampleREST.PLCreateUserSampleRest.getCreateUserPayLoad;
import static io.restassured.RestAssured.given;

public class CreateUserUsingPayload2 {

    public static void main(String[] args) {

        RestAssured.baseURI = "https://reqres.in/";

         given().log().all()
                 .header("Content-Type","application/json")
                 .body(getCreateUserPayLoad("Shruti","HR"))
                 .when().post("/api/users")
                 .then().log().all().assertThat().statusCode(201);

    }
}
