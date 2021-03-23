import java.util.ArrayList;

public class Main
{
    public static void main(String[] args)
    {
        ArrayList<Team> allTeams = Team.getAllTeams(args[0]);
        ArrayList<Sport> allLeagues = Sport.getAllLeagues(allTeams);

       for (Sport League : allLeagues)
       {
           League.CalculatePoints();
           League.WriteOutput();
       }

    }
}
