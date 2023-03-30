package ChatServer;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class ViewAllUsers {

    @Test
    public void viewALlUsers()
    {
        RestAssured.baseURI = "http://localhost:80/chat8am/lhc_web/index.php/site_admin/";

        given().log().all()
                .auth().preemptive().basic("admin","admin123")
                .contentType("application/json")
                .accept("application/json")
                .when().get("/restapi/getusers")
                .then().log().all().statusCode(200);
                /*.header("Content-Type","application/json")
                .header("Connection","Upgrade, Keep-Alive");*/
    }

}
