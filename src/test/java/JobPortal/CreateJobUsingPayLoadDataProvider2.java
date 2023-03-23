package JobPortal;

import io.restassured.RestAssured;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;

import static PayLoad.JobPort.PLCreateUserJobPortal.getCreateJobPayLoad;
import static PayLoad.JobPort.PLCreateUserJobPortal.getCreateJobPayLoad2;
import static io.restassured.RestAssured.given;

public class CreateJobUsingPayLoadDataProvider2 {

    @Test (dataProvider = "getData")
    public void createJob(String jobTitle,String jobDescription,String technologies) {

        RestAssured.baseURI = "http://localhost:9897/";

        //String jobTitle = "2 years exp. in Jva";
        //String jobDescription = "Required 1+ years experience in java development";
        String[] projectTechnologies = technologies.split(",");

        given().log().all()
               // .contentType("application/json")
                .header("accept","application/json")
                .header("Content-Type","application/json")
                .body(getCreateJobPayLoad2(jobTitle,jobDescription,projectTechnologies))
                .when().post("/normal/webapi/add")
                .then().log().all().assertThat().statusCode(201);
    }

    @DataProvider
    public Object[][] getData() throws IOException {
        FileInputStream fis = new FileInputStream("Data/MyDataX.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet sheet = workbook.getSheet("Create Job 2");
        int rowCount = sheet.getPhysicalNumberOfRows();
        int colCount = sheet.getRow(0).getLastCellNum();
        Object[][] data = new Object[rowCount-1][colCount];

        for (int i=0;i<rowCount-1;i++)
        {

            XSSFRow row = sheet.getRow(i+1);

           /* data[i][0] = row.getCell(0).toString().trim();
            data[i][1] = row.getCell(1).toString().trim();
            data[i][2] = row.getCell(2).toString().trim();*/

            for (int j=0;j<colCount;j++)
                data[i][j] = row.getCell(j).toString().trim();
        }
        return data;
    }



}
