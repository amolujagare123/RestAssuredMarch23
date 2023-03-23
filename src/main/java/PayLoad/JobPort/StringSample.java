package PayLoad.JobPort;

public class StringSample {

    public static void main(String[] args) {

        String str = "Java,MySQL,WebServices";
        String[] technologies = str.split(",");

        String allTechnologies = "";
        for (int i=0;i<technologies.length;i++) {
            System.out.println(allTechnologies);
            if (i!=technologies.length-1)
                allTechnologies = allTechnologies + technologies[i]+ "\",\"";
            else
                allTechnologies = "\""+allTechnologies + technologies[i]+"\"";
        }

        System.out.println(allTechnologies);
        System.out.println(str);
    }
}
