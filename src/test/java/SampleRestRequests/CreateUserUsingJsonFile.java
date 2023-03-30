package SampleRestRequests;

import io.restassured.RestAssured;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static PayLoad.SampleREST.PLCreateUserSampleRest.getCreateUserPayLoad;
import static io.restassured.RestAssured.given;

public class CreateUserUsingJsonFile {

    public static void main(String[] args) throws IOException {

        RestAssured.baseURI = "https://reqres.in/";

        String body = new String(Files.readAllBytes(Paths.get("JsonFiles/SampleCreateUser.json")));

         given().log().all()
                 .header("Content-Type","application/json")
                 .body(body)
                 .when().post("/api/users")
                 .then().log().all().assertThat().statusCode(201);

    }
}
