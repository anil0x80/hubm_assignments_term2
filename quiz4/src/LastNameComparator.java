import java.util.Comparator;

public class LastNameComparator implements Comparator<Contact>
{
    @Override
    public int compare(Contact firstPlayer, Contact secondPlayer) {
        return (firstPlayer.getLastName().compareTo(secondPlayer.getLastName()));
    }
}
