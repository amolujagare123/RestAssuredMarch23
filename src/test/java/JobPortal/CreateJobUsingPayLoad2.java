package JobPortal;

import io.restassured.RestAssured;

import static PayLoad.JobPort.PLCreateUserJobPortal.getCreateJobPayLoad;
import static io.restassured.RestAssured.given;

public class CreateJobUsingPayLoad2 {

    public static void main(String[] args) {

        RestAssured.baseURI = "http://localhost:9897/";

        String jobTitle = "2 years exp. in Jva";
        String jobDescription = "Required 1+ years experience in java development";
        String[] projectTechnologies = {"Java","MySQL","WebServices"};

        given().log().all()
               // .contentType("application/json")
                .header("accept","application/json")
                .header("Content-Type","application/json")
                .body(getCreateJobPayLoad(jobTitle,jobDescription,projectTechnologies))
                .when().post("/normal/webapi/add")
                .then().log().all().assertThat().statusCode(201);
    }
}
