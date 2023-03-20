package JobPortal;

import io.restassured.RestAssured;

import static PayLoad.JobPort.PLCreateUserJobPortal.getCreateJobPayLoad;
import static io.restassured.RestAssured.given;

public class CreateJobUsingPayLoad {

    public static void main(String[] args) {

        RestAssured.baseURI = "http://localhost:9897/";

        given().log().all()
               // .contentType("application/json")
                .header("accept","application/json")
                .header("Content-Type","application/json")
                .body(getCreateJobPayLoad())
                .when().post("/normal/webapi/add")
                .then().log().all().assertThat().statusCode(201);
    }
}
