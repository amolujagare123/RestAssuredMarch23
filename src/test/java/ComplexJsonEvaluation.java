import io.restassured.path.json.JsonPath;
import org.testng.Assert;
import org.testng.annotations.Test;

import static PayLoad.SampleComplexJson.sampleJson;

public class ComplexJsonEvaluation {

    @Test
    public void jsonTest()
    {
        String resp = sampleJson();
        JsonPath jsonPath = new JsonPath(resp);

        // 1. Print No of courses returned by response

       int totalCourses =  jsonPath.getInt("courses.size()");
       System.out.println("totalCourses="+totalCourses);

       // 2. Print Purchase Amount
        int purchaseAmount = jsonPath.getInt("dashboard.purchaseAmount");
        System.out.println("purchaseAmount="+purchaseAmount);

        // 3. Print Title of the first course
        String courseTitle = jsonPath.getString("courses[0].title");
        System.out.println("courseTitle="+courseTitle);

        // 4. Print All course titles and their respective Prices


        for (int i=0;i<totalCourses;i++)
        {
            String title = jsonPath.getString("courses["+i+"].title");
            String price = jsonPath.getString("courses["+i+"].price");

            System.out.println("Title = "+title+", Price="+price);
        }

        // 5. Print no of copies sold by RPA Course
        for (int i=0;i<totalCourses;i++)
        {
            String title = jsonPath.getString("courses[" + i + "].title");
            if(title.equalsIgnoreCase("RPA")) {

                String copies = jsonPath.getString("courses[" + i + "].copies");
                System.out.println("RPA copies = "+copies);
            }

        }


        // 6. Verify if Sum of all Course prices matches with Purchase Amount

        int expectedTotalPrice = jsonPath.getInt("dashboard.purchaseAmount");

        int totalPrice = 0;
        for (int i=0;i<totalCourses;i++)
        {
            int price = jsonPath.getInt("courses["+i+"].price");
            int copies = jsonPath.getInt("courses["+i+"].copies");

            totalPrice = totalPrice + (price * copies);
        }
        System.out.println("totalPrice = "+totalPrice);

        Assert.assertEquals(totalPrice,expectedTotalPrice,"values does not match");

    }
}
