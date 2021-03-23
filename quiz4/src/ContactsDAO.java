import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.TreeSet;

public interface ContactsDAO
{
    ArrayList<Contact> getAllAsArrayList();
    HashSet<Contact> getAllAsHashSet();
    TreeSet<Contact> getAllAsTreeSet();
    TreeSet<Contact> getAllAsTreeSetSortedByLastName();
    HashMap<String,Contact> getAllAsHashMap();

    void writeIterableToFile(String fileName, Iterable iterable);
}
