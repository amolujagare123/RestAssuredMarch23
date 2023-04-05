package ChatServer.SpecBuilderDemo;

import io.restassured.RestAssured;
import io.restassured.authentication.PreemptiveBasicAuthScheme;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class ViewAllUsers {

    @Test
    public void viewALlUsers()
    {
        /*RestAssured.baseURI = "http://localhost:80/chat/lhc_web/index.php/site_admin/";

        given().log().all()
                .auth().preemptive().basic("admin","admin123")
                .contentType("application/json")
                .accept("application/json")
                .when().get("/restapi/getusers")
                .then().log().all().statusCode(200);*/
                /*.header("Content-Type","application/json")
                .header("Connection","Upgrade, Keep-Alive");*/


        RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder();

        PreemptiveBasicAuthScheme auth = new PreemptiveBasicAuthScheme();
        auth.setUserName("admin");
        auth.setPassword("admin123");

        RequestSpecification requestSpecification
                = requestSpecBuilder.setBaseUri("http://localhost:80/chat8am/lhc_web/index.php/site_admin/")
                .setAuth(auth)
                .setContentType("application/json")
                .setAccept("application/json")
                .build();

        RequestSpecification request = given().log().all().spec(requestSpecification);

        ResponseSpecBuilder responseSpecBuilder = new ResponseSpecBuilder();

        ResponseSpecification responseSpecification
                = responseSpecBuilder.expectStatusCode(200).build();

        Response hitRequest = request.when().get("/restapi/getusers");

        String resp = hitRequest.then().log().all()
                .spec(responseSpecification).extract().asString();

        System.out.println(resp);

    }

}
