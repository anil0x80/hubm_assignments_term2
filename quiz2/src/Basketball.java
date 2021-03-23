public class Basketball extends Sport
{
    public Basketball()
    {
        super(0, 1, 2);
    }

    @Override
    public String getOutputFile()
    {
        return "basketball.txt";
    }
}
