import java.util.Collections;
import java.util.Comparator;

public class Volleyball extends Sport //automatically calls super(), default constructor for sport.
{
    public void CalculatePoints()
    {
        for (Team team: Table)
        {
            int totalPoints = 0;
            for(Score score: team.getScores())
            {
                if (score.Compare(3,0) || score.Compare(3,1))
                    totalPoints += 3;
                else if (score.Compare(3,2))
                    totalPoints += 2;
                else if (score.Compare(2,3))
                    totalPoints += 1;
            }
            team.setTotalPoints(totalPoints);
        }

        SortLeague();
    }

    @Override
    public String getOutputFile()
    {
        return "volleyball.txt";
    }
}
