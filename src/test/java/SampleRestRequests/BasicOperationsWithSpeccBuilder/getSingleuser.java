package SampleRestRequests.BasicOperationsWithSpeccBuilder;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.RestAssured.given;

public class getSingleuser {

    public static void main(String[] args) {

       /* RestAssured.baseURI = "https://reqres.in/";

        given().log().all()
                .when().get("/api/users/2")
                .then().log().all().assertThat()
                .statusCode(200);*/

        RequestSpecBuilder requestSpecBuilder  = new RequestSpecBuilder();
        RequestSpecification requestSpecification
                = requestSpecBuilder.setBaseUri("https://reqres.in/")
                .setContentType("application/json")
                .setAccept("application/json")
                .build();

        RequestSpecification request = given().log().all().spec(requestSpecification);

        ResponseSpecBuilder responseSpecBuilder = new ResponseSpecBuilder();

        ResponseSpecification responseSpecification
                =
        responseSpecBuilder.expectStatusCode(204)
                .expectStatusCode(201)
                .expectStatusCode(200)
                .build();

        Response hitRequest = request.when().get("/api/unknown/2");

        String resp = hitRequest.then().log().all().spec(responseSpecification).extract().asString();

        System.out.println(resp);
    }
}
