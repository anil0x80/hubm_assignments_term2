public class Score
{
    public Score(int i, int k)
    {
        x = i;
        y = k;
    }
    int x;
    int y;

    public boolean Compare(int i, int k)
    {
        if(i == x && k == y)
            return true;
        return false;
    }

    public int getX()
    {
        return x;
    }

    public int getY()
    {
        return y;
    }
}
