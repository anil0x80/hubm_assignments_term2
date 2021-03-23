import java.util.ArrayList;

public class Main
{
    public static void main(String[] args)
    {
        ArrayList<Personnel> Personnels = Parser.getPersonnels(args[0]);
        Parser.parseWorkingHours(Personnels, args[1]);

        for (Personnel e : Personnels)
        {
            WriteToFile file = new WriteToFile(e.getRegNumber() + ".txt");
            file.WriteLine(e.getInfo());
            file.End();
        }
    }
}
