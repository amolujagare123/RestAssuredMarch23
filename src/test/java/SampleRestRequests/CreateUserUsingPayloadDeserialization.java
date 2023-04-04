package SampleRestRequests;

import io.restassured.RestAssured;

import static PayLoad.SampleREST.PLCreateUserSampleRest.getCreateUserPayLoad;
import static io.restassured.RestAssured.given;
import POJO.SampleUser.*;


public class CreateUserUsingPayloadDeserialization {

    public static void main(String[] args) {

        RestAssured.baseURI = "https://reqres.in/";

        SampleCreateUserResponse responseObject = given().log().all()
                .header("Content-Type", "application/json")
                .body(getCreateUserPayLoad())
                .when().post("/api/users")
                .then().log().all().assertThat().statusCode(201)
                .extract().as(SampleCreateUserResponse.class);


        System.out.println("name="+responseObject.getName());
        System.out.println("job="+responseObject.getJob());
        System.out.println("id="+responseObject.getId());
        System.out.println("createdAT="+responseObject.getCreatedAt());

    }
}
