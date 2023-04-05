package ChatServer.SpecBuilderDemo;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class ViewSingleUsersCaptureRessponse {

    @Test
    public void viewALlUsers()
    {
        RestAssured.baseURI = "http://localhost:80/chat/lhc_web/index.php/site_admin/";

        String response = given().log().all()
                .auth().preemptive().basic("admin", "admin123")
                .contentType("application/json")
                .accept("application/json")
                .when().get("/restapi/user/225")
                .then().statusCode(200).extract().asString();

        System.out.println(response);



    }

}
