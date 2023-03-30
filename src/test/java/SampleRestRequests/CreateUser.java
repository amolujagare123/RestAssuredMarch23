package SampleRestRequests;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static  io.restassured.RestAssured.given;

public class CreateUser {

    public static void main(String[] args) {

        RestAssured.baseURI = "https://reqres.in/";

         String resp = given().log().all()
                 .header("Content-Type","application/json")
                 .body("{\n" +
                         "    \"name\": \"Amol\",\n" +
                         "    \"job\": \"Tester\"\n" +
                         "}")
                 .when().post("/api/users")
                 .then().log().all().assertThat().statusCode(201).extract().asString();

        System.out.println(resp);


        JsonPath js = new JsonPath(resp);

        System.out.println(js.getString("name"));

    }
}
