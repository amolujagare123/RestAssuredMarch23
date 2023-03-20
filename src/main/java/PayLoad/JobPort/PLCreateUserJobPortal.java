package PayLoad.JobPort;

public class PLCreateUserJobPortal {

    public static String getCreateJobPayLoad()
    {
        return "{\n" +
                "\t\"experience\": [\n" +
                "\t\t\"2 years in manual testing\",\n" +
                "\t\t\"1 year in automation Testing\"\n" +
                "\t],\n" +
                "\t\"jobDescription\": \"5-year experience with manual testing API testing selenium are required\",\n" +
                "\t\"jobId\": 12,\n" +
                "\t\"jobTitle\": \"Automation Test Enginner\",\n" +
                "\t\"project\": [\n" +
                "\t\t{\n" +
                "\t\t\t\"projectName\": \"Stock Management\",\n" +
                "\t\t\t\"technology\": [\n" +
                "\t\t\t\t\"php\",\n" +
                "\t\t\t\t\"mysql\",\n" +
                "\t\t\t\t\"java\"\n" +
                "\t\t\t]\n" +
                "\t\t}\n" +
                "\t]\n" +
                "}" ;
    }

    public static String getCreateJobPayLoad(String jobTitle,String JobDescription,String[] technologies)
    {
        return "{\n" +
                "\t\"experience\": [\n" +
                "\t\t\"2 years in manual testing\",\n" +
                "\t\t\"1 year in automation Testing\"\n" +
                "\t],\n" +
                "\t\"jobDescription\": \""+JobDescription+"\",\n" +
                "\t\"jobId\": 12,\n" +
                "\t\"jobTitle\": \""+jobTitle+"\",\n" +
                "\t\"project\": [\n" +
                "\t\t{\n" +
                "\t\t\t\"projectName\": \"Stock Management\",\n" +
                "\t\t\t\"technology\": [\n" +
                "\t\t\t\t\""+technologies[0]+"\",\n" +
                "\t\t\t\t\""+technologies[1]+"\",\n" +
                "\t\t\t\t\""+technologies[2]+"\"\n" +
                "\t\t\t]\n" +
                "\t\t}\n" +
                "\t]\n" +
                "}" ;
    }
}
