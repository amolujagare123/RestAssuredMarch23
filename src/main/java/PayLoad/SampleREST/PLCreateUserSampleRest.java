package PayLoad.SampleREST;

public class PLCreateUserSampleRest {


    public static String getCreateUserPayLoad()
    {
        return "{\n" +
                "    \"name\": \"Amol\",\n" +
                "    \"job\": \"Tester\"\n" +
                "}";
    }
    public static String getCreateUserPayLoad(String name,String job)
    {
        return "{\n" +
                "    \"name\": \""+name+"\",\n" +
                "    \"job\": \""+job+"\"\n" +
                "}";
    }
}













