package SampleRestRequests.BasicOperationsWithSpeccBuilder;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.RestAssured.given;

public class CreateUser {

    public static void main(String[] args) {


        // 1. create Request spec builder class object
        RequestSpecBuilder requestSpecBuilder =  new RequestSpecBuilder();

        // using this object we set initial specification ( we call them as request specifications)
        RequestSpecification requestSpecification
                = requestSpecBuilder.setBaseUri("https://reqres.in/")
                .setContentType("application/json")
                .build();

        // 2. we use the request specification object with the given() method by calling spec method,
        // and we pass the above requestSpecification object
        RequestSpecification request = given().log().all().spec(requestSpecification);


        // 3 . we attach any uncommon things if there are to the above request object
        RequestSpecification createUserRequest = request.body("{\n" +
                "    \"name\": \"Amol\",\n" +
                "    \"job\": \"Tester\"\n" +
                "}");


        // 4. create ResponseSpecBuilder class object
        ResponseSpecBuilder responseSpecBuilder = new ResponseSpecBuilder();

        // using this object we will set some common assertions
        ResponseSpecification responseSpecification = responseSpecBuilder
                .expectStatusCode(200)
                .expectStatusCode(201)
                .build();

        // 5. we create hitResource object to hit the request using appropriate
        // method [post()] and resource ["/api/users"]
        Response hitResource = createUserRequest.when().post("/api/users");


        // 6. using hitResource object, we call then() method
        // again we call spec() method with then() method
        // and pass the response specification object that has common assertions predefined
        String resp = hitResource.then().log().all().spec(responseSpecification).extract().asString();


        System.out.println(resp);


        JsonPath js = new JsonPath(resp);

        System.out.println("name="+js.getString("name"));

    }
}
