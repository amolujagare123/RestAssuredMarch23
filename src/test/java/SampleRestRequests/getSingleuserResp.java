package SampleRestRequests;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class getSingleuserResp {

    @Test
    public void myUserTest() {

        RestAssured.baseURI = "https://reqres.in/";

        String resp = given().log().all()
                .when().get("/api/users/2")
                .then().log().all().assertThat()
                .statusCode(200).extract().asString();

        System.out.println(resp);

        String expectedName = "Janet";

        JsonPath js = new JsonPath(resp);

        String fName = js.get("data.first_name");
        String fName1 = js.getString("data.first_name");
        String id = ""+js.get("data.id");
        int id2 = js.get("data.id");
        int id3 = js.getInt("data.id");

        System.out.println(fName);
        System.out.println(fName1);

        //  data.first_name

        System.out.println(id);
        System.out.println(id2);
        System.out.println(id3);



        String actualName = js.get("data.first_name");

        Assert.assertEquals(actualName,expectedName,"Wrong name");

    }
}
