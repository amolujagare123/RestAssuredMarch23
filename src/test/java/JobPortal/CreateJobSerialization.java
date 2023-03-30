package JobPortal;

import POJO.JobPortal.POJOJObPortal;
import POJO.JobPortal.Project;
import io.restassured.RestAssured;

import java.util.ArrayList;

import static io.restassured.RestAssured.given;

public class CreateJobSerialization {

    public static void main(String[] args) {

        RestAssured.baseURI = "http://localhost:9897/";

        POJOJObPortal ob = new POJOJObPortal();
        ob.setJobDescription("Software testers with API Testing experience");
        ob.setJobId(567);
        ob.setJobTitle("Automation Test Engineer");

        ArrayList<String> exp = new ArrayList<>();
        exp.add("Manual Testing");
        exp.add("Automation Testing");
        exp.add("API Testing");

        ob.setExperience(exp);

        Project project1 = new Project();
        project1.setProjectName("Stock Management");
        ArrayList<String> tech1 = new ArrayList<>();
        tech1.add("Java");
        tech1.add("MySQL");
        project1.setTechnology(tech1);

        Project project2 = new Project();
        project2.setProjectName("HR Management");
        ArrayList<String> tech2 = new ArrayList<>();
        tech2.add("ASP.Net");
        tech2.add("MSSQL");
        project2.setTechnology(tech2);

        ArrayList<Project> proj = new ArrayList<>();
        proj.add(project1);
        proj.add(project2);

        ob.setProject(proj);




        given().log().all()
               // .contentType("application/json")
                .header("accept","application/json")
                .header("Content-Type","application/json")
                .body(ob)
                .when().post("/normal/webapi/add")
                .then().log().all().assertThat().statusCode(201);
    }
}
