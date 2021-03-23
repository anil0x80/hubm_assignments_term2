public class MatchResult
{
    public MatchResult(String Line)
    {
        String[] Parts = Line.split("\t");
        Type = Parts[0];
        FirstTeam = Parts[1];
        SecondTeam = Parts[2];
        String[] Result = Parts[3].split(":");
        FirstTeamGoals = Integer.parseInt(Result[0]);
        SecondTeamGoals = Integer.parseInt(Result[1]);
    }


    String Type;
    String FirstTeam;
    String SecondTeam;

    int FirstTeamGoals;
    int SecondTeamGoals;

    public String getType()
    {
        return Type;
    }

    public String getFirstTeamName()
    {
        return FirstTeam;
    }

    public String getSecondTeamName()
    {
        return SecondTeam;
    }

    public int getFirstTeamGoals()
    {
        return FirstTeamGoals;
    }

    public int getSecondTeamGoals()
    {
        return SecondTeamGoals;
    }

    public Team getFirstTeam()
    {
        return new Team(Type, FirstTeam);
    }

    public Team getSecondTeam()
    {
        return new Team(Type, SecondTeam);
    }
}
