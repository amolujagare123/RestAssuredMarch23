package JobPortal;

import POJO.JobPortal.POJOJObPortal;
import io.restassured.RestAssured;

import static PayLoad.JobPort.PLCreateUserJobPortal.getCreateJobPayLoad;
import static io.restassured.RestAssured.given;

public class CreateJobUsingPayLoad {

    public static void main(String[] args) {

        RestAssured.baseURI = "http://localhost:9897/";

        POJOJObPortal responseObject = given().log().all()
                // .contentType("application/json")
                .header("accept", "application/json")
                .header("Content-Type", "application/json")
                .body(getCreateJobPayLoad())
                .when().post("/normal/webapi/add")
                .then().log().all().assertThat().statusCode(201)
                .extract().as(POJOJObPortal.class);


        System.out.println("Job title="+responseObject.getJobTitle());
        System.out.println("Job description="+responseObject.getJobDescription());
        System.out.println("Technology="+responseObject.getExperience());

        System.out.println("Project name="+responseObject.getProject().get(0).getProjectName());
         System.out.println("Technology="+responseObject.getProject().get(0).getTechnology());

        responseObject.getProject().get(1).getProjectName();
        responseObject.getProject().get(1).getTechnology();


    }
}
