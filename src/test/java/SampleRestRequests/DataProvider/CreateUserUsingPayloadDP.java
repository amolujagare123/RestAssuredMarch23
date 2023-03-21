package SampleRestRequests.DataProvider;

import io.restassured.RestAssured;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static PayLoad.SampleREST.PLCreateUserSampleRest.getCreateUserPayLoad;
import static io.restassured.RestAssured.given;

public class CreateUserUsingPayloadDP {

    @Test (dataProvider = "getData")
    public void createRequest(String name,String job) {

        RestAssured.baseURI = "https://reqres.in/";

         given().log().all()
                 .header("Content-Type","application/json")
                 .body(getCreateUserPayLoad(name,job))
                 .when().post("/api/users")
                 .then().log().all().assertThat().statusCode(201);

    }

    @DataProvider
    public Object[][] getData()
    {

        Object[][] data = new Object[4][2];

        data[0][0]= "Shruti";
        data[0][1]= "HR";

        data[1][0]= "Amit";
        data[1][1]= "Test Lead";

        data[2][0]= "Praveen";
        data[2][1]= "Manager";

        data[3][0]= "Saggurthi";
        data[3][1]= "Dev Lead";

        return data;
    }
}
