import java.util.*;

public class Main
{
    public static void main(String[] args)
    {
        ContactsDAOImpl contactsDAO = new ContactsDAOImpl("contacts.txt");
        ArrayList<Contact> asArrayList = contactsDAO.getAllAsArrayList();
        HashSet<Contact> asHashSet = contactsDAO.getAllAsHashSet();
        TreeSet<Contact> asTreeSet = contactsDAO.getAllAsTreeSet();
        TreeSet<Contact> asTreeSetSortedByLastName = contactsDAO.getAllAsTreeSetSortedByLastName();
        HashMap<String,Contact> asHashMap = contactsDAO.getAllAsHashMap();

        contactsDAO.writeIterableToFile("contactsArrayList.txt", asArrayList);

        LastNameComparator lastNameComparator = new LastNameComparator();
        Collections.sort(asArrayList, lastNameComparator);
        contactsDAO.writeIterableToFile("contactsArrayListOrderByLastName.txt", asArrayList);

        contactsDAO.writeIterableToFile("contactsHashSet.txt", asHashSet);
        contactsDAO.writeIterableToFile("contactsTreeSet.txt", asTreeSet);
        contactsDAO.writeIterableToFile("contactsTreeSetOrderByLastName.txt", asTreeSetSortedByLastName);
        contactsDAO.writeIterableToFile("contactsHashMap.txt", asHashMap.values());
    }
}
