import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Sport //all sport classes should inherit from this.
{
    static ArrayList<Sport> getAllLeagues(ArrayList<Team> allTeams)
    {
        ArrayList<Sport> allLeagues = new ArrayList<Sport>();
        Basketball basketball = new Basketball();
        Handball handball = new Handball();
        IceHockey icehockey = new IceHockey();
        Volleyball volleyball = new Volleyball();
        allLeagues.add(basketball);
        allLeagues.add(handball);
        allLeagues.add(icehockey);
        allLeagues.add(volleyball);
        for (Team team: allTeams)
        {
            switch(team.getType())
            {
                case "B":
                    basketball.addTeam(team);
                    break;
                case "H":
                    handball.addTeam(team);
                    break;
                case "V":
                    volleyball.addTeam(team);
                    break;
                case "I":
                    icehockey.addTeam(team);
                    break;
                default:
                    System.out.println("Unknown game specifier: " + team.getType());
            }
        }
        return allLeagues;
    }

    public Sport()
    {
        Table = new ArrayList<Team>(); //initialize
    }
    public Sport(int draw, int lose, int winner)
    {
        PointForDraw = draw;
        PointForLoser = lose;
        PointForWinner = winner;
        Table = new ArrayList<Team>(); //initialize
    }

    public String getOutputFile()
    {
        //this will be overridden, no implementation necessary.
        return "";
    }

    public void WriteOutput()
    {
        WriteToFile file = new WriteToFile(getOutputFile());
        int index = 1;
        for (Team team : Table)
        {
            file.WriteLine(index + ".\t" + team.getName() + "\t" + team.getMatchesPlayed() + "\t"
                    + team.getMatchesWon() + "\t" + team.getMatchesDrawn() + "\t" + team.getMatchesLost() + "\t"
                    + team.getGoalsScored() + ":" + team.getGoalsConceded() + "\t" + team.TotalPoints);
            if (Table.indexOf(team) != Table.size() - 1) //not needed new line at last item.
                file.WriteLine("\n");
            index++;
        }
        file.End();
    }

    public void SortLeague()
    {
        Comparator<Team> comparator = Comparator.comparing(team -> team.TotalPoints);
        comparator = comparator.thenComparing(Comparator.comparing(Team::getAverage));
        Table.sort(comparator);
        Collections.reverse(Table);
    }

    public void addTeam(Team team)
    {
        Table.add(team);
    }

    public void CalculatePoints()
    {
        for (Team team: Table)
        {
            int p1 = PointForWinner * team.getMatchesWon();
            int p2 = PointForDraw * team.getMatchesDrawn();
            int p3 = PointForLoser * team.getMatchesLost();
            team.setTotalPoints(p1 + p2 + p3);
        }

        SortLeague();
    }

    int PointForDraw;
    int PointForLoser;
    int PointForWinner;
    ArrayList<Team> Table; //holds team objects in order.
}
