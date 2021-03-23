import java.util.*;

public class Team  //defines a team for any sport type.
{
    static ArrayList<Team> getAllTeams(String Path)
    {
        String[] Lines = ReadFromFile.readFile(Path);
        ArrayList<Team> allTeams = new ArrayList<Team>();
        if (Lines != null)
        {
            for (String Line : Lines)
            { //todo maybe some tidying up.
                MatchResult result = new MatchResult(Line); // line is parsed inside matchresult
                Team firstTeam = result.getFirstTeam();
                Team secondTeam = result.getSecondTeam();
                if (!allTeams.contains(firstTeam))
                    allTeams.add(firstTeam);

                allTeams.get(allTeams.indexOf(firstTeam)).Update(result.getFirstTeamGoals(), result.getSecondTeamGoals());

                if (!allTeams.contains(secondTeam))
                    allTeams.add(secondTeam);

                allTeams.get(allTeams.indexOf(secondTeam)).Update(result.getSecondTeamGoals(),result.getFirstTeamGoals());
            }
        }
        return allTeams;
    }

    public Team(String type, String name)
    {
        Scores = new ArrayList<Score>();
        Type = type;
        Name = name;
    }

    public void Update(int scored, int conceded)
    {
        Scores.add(new Score(scored, conceded)); //for volleyball games, used for point calculation.
        MatchesPlayed++;
        if (scored > conceded)
            MatchesWon++;
        else if (scored < conceded)
            MatchesLost++;
        else
            MatchesDrawn++;

        GoalsScored += scored;
        GoalsConceded += conceded;
    }
    String Type; //I : hockey, H : handball, V : volleyball, B : basketball
    String Name;

    public ArrayList<Score> getScores()
    {
        return Scores;
    }

    ArrayList<Score> Scores;
    int MatchesPlayed;
    int MatchesDrawn;
    int MatchesLost;
    int MatchesWon;

    int GoalsScored;
    int GoalsConceded;

    int TotalPoints;

    //below overrides equals and hashcode so i can compare these objects only by their name&type;
    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Team team = (Team) o;
        return Objects.equals(Type, team.Type) &&
                Objects.equals(Name, team.Name);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(Type, Name);
    }

    public String getType()
    {
        return Type;
    }

    public String getName()
    {
        return Name;
    }

    public int getMatchesPlayed()
    {
        return MatchesPlayed;
    }

    public int getMatchesDrawn()
    {
        return MatchesDrawn;
    }

    public int getMatchesLost()
    {
        return MatchesLost;
    }

    public int getMatchesWon()
    {
        return MatchesWon;
    }

    public int getGoalsScored()
    {
        return GoalsScored;
    }

    public int getGoalsConceded()
    {
        return GoalsConceded;
    }

    public int getAverage()
    {
        return GoalsScored - GoalsConceded;
    }

    public void setTotalPoints(int totalPoints)
    {
        TotalPoints = totalPoints;
    }
}
