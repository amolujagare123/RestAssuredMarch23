package SampleRestRequests.DataProvider;

import io.restassured.RestAssured;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;

import static PayLoad.SampleREST.PLCreateUserSampleRest.getCreateUserPayLoad;
import static io.restassured.RestAssured.given;

public class CreateUserUsingPayloadDPxlsx {

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
    public Object[][] getData() throws IOException {
        // 1 . read the file
        FileInputStream fis = new FileInputStream("Data/MyDataX.xlsx");

        // 2. covert file object into workbook object
        XSSFWorkbook workbook = new XSSFWorkbook(fis);

        // 3. choose sheet
        XSSFSheet sheet = workbook.getSheet("Sheet1");

        //4. count the active rows
        int rowCount = sheet.getPhysicalNumberOfRows();

        Object[][] data = new Object[rowCount][2];

        for (int i=0;i<rowCount;i++)
        {
            XSSFRow row = sheet.getRow(i);

            data[i][0] = row.getCell(0).toString().trim();
            data[i][1] = row.getCell(1).toString().trim();
        }

      /*  data[0][0]= "Shruti";
        data[0][1]= "HR";

        data[1][0]= "Amit";
        data[1][1]= "Test Lead";

        data[2][0]= "Praveen";
        data[2][1]= "Manager";

        data[3][0]= "Saggurthi";
        data[3][1]= "Dev Lead";*/

        return data;
    }
}
