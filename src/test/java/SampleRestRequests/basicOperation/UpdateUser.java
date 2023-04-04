package SampleRestRequests.basicOperation;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.given;
public class UpdateUser {

    public static void main(String[] args) {

        RestAssured.baseURI = "https://reqres.in/";

        given().log().all()
                .header("Content-Type","application/json")
                .body("{\n" +
                        "    \"name\": \"Amol\",\n" +
                        "    \"job\": \"Test engg.\"\n" +
                        "}")
                .when().put("/api/users/2")
                .then().log().all().assertThat().statusCode(200);
    }
}
