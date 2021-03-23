import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.TreeSet;

public class ContactsDAOImpl implements ContactsDAO
{
    public ContactsDAOImpl(String fileName)
    {
        this.fileName = fileName;
        contactArrayList = new ArrayList<Contact>();
        contactsHashSet = new HashSet<Contact>();
        contactsTreeSet = new TreeSet<Contact>();
        contactsTreeSetLastName = new TreeSet<Contact>(new LastNameComparator());
        contactsHashMap = new HashMap<String, Contact>();
        parseFile(fileName);
    }

    private void parseFile(String fileName)
    {
        String[] lines = ReadFromFile.readFile(fileName);
        if (lines != null)
        {
            for(String line : lines)
            {
                String[] parts = line.split(" ");
                String phoneNumber = parts[0];
                String name = parts[1];
                String surname = parts[2];
                String socialSecurityNumber = parts[3];

                Contact contact = new Contact(phoneNumber, name, surname, socialSecurityNumber);
                contactArrayList.add(contact);
                contactsHashSet.add(contact);
                contactsTreeSet.add(contact);
                contactsTreeSetLastName.add(contact);
                contactsHashMap.put(contact.getPhoneNumber(), contact);
            }
        }
    }

    @Override
    public ArrayList<Contact> getAllAsArrayList() {
        return contactArrayList;
    }

    @Override
    public HashSet<Contact> getAllAsHashSet() {
        return contactsHashSet;
    }

    @Override
    public TreeSet<Contact> getAllAsTreeSet() {
        return contactsTreeSet;
    }

    @Override
    public TreeSet<Contact> getAllAsTreeSetSortedByLastName() {
        return contactsTreeSetLastName;
    }

    @Override
    public HashMap<String, Contact> getAllAsHashMap() {
        return contactsHashMap;
    }


    @Override
    public void writeIterableToFile(String fileName, Iterable iterable)
    {
        WriteToFile fileWriter = new WriteToFile(fileName);

        for (Object contact : iterable)
        {
            fileWriter.write(((Contact)contact).serialize() + "\n");
        }

        fileWriter.end();
    }


    private String fileName;
    private ArrayList<Contact> contactArrayList;
    private HashSet<Contact> contactsHashSet;
    private TreeSet<Contact> contactsTreeSet;
    private TreeSet<Contact> contactsTreeSetLastName;
    private HashMap<String, Contact> contactsHashMap;
}