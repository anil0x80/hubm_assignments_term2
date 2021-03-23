import java.util.ArrayList;

public class Parser //this class reads input files, understands them.
{
    static ArrayList<Personnel> getPersonnels(String path)
    {
        ArrayList<Personnel> Personnels = new ArrayList<Personnel>();
        String[] Lines = ReadFromFile.readFile(path);
        if (Lines != null)
        {
            for (String Line : Lines)
            {
                Personnel personnel = new Personnel();
                String[] Parts = Line.split("\t");
                String[] FullName = Parts[0].split(" ");
                String Position = Parts[2];
                if (Position.equals("OFFICER"))
                    personnel = new Officer();
                if (Position.equals("FACULTY_MEMBER"))
                    personnel = new FacultyMember();
                if (Position.equals("SECURITY"))
                    personnel = new Security();
                if (Position.equals("RESEARCH_ASSISTANT"))
                    personnel = new ResearchAssistant();
                if (Position.equals("CHIEF"))
                    personnel = new Chief();
                if (Position.equals("WORKER"))
                    personnel = new Worker();
                if (Position.equals("PARTTIME_EMPLOYEE"))
                    personnel = new PartTimeEmployee();


                personnel.setName(FullName[0]);
                personnel.setSurname(FullName[1]);
                personnel.setRegNumber(Parts[1]);
                personnel.setPosition(Position);
                personnel.setStartDate(Parts[3]);
                Personnels.add(personnel);
            }
        }

        return Personnels;
    }

    static void parseWorkingHours(ArrayList<Personnel> Personnels, String path)
    {
        String[] Lines = ReadFromFile.readFile(path);
        for (String Line : Lines)
        {
            String[] Parts = Line.split("\t");
            String RegNumber = Parts[0];
            for (Personnel p : Personnels)
            {
                if (p.getRegNumber().equals(RegNumber))
                {
                    for (int i = 1; i < 5; i++)
                    {
                        p.getWorkingHours().add(Integer.parseInt(Parts[i]));
                    }

                }
            }
        }

    }

}
