package SampleRestRequests;

import POJO.SampleUser.SampleRESTUser;
import io.restassured.RestAssured;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static io.restassured.RestAssured.given;

public class CreateUserUsingSerialization {

    public static void main(String[] args) throws IOException {

        RestAssured.baseURI = "https://reqres.in/";

        SampleRESTUser ob = new SampleRESTUser();
        ob.setName("Amol-POJO");
        ob.setJob("Tester-POJO");

         given().log().all()
                 .header("Content-Type","application/json")
                 .body(ob)
                 .when().post("/api/users")
                 .then().log().all().assertThat().statusCode(201);

    }
}
