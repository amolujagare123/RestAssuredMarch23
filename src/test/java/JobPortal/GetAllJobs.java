package JobPortal;

import io.restassured.RestAssured;

import static io.restassured.RestAssured.given;

public class GetAllJobs {

    public static void main(String[] args) {

        RestAssured.baseURI = "http://localhost:9897/";

        given().log().all()
               // .contentType("application/json")
                .header("accept","application/xml")
                .header("Content-Type","application/xml")
                .when().get("/normal/webapi/all")
                .then().log().all().assertThat().statusCode(200);
    }
}
