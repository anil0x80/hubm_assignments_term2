public class Contact implements Comparable<Contact>
{
    public String getSocialSecurityNumber() {
        return socialSecurityNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public Contact(String phoneNumber, String firstName, String lastName, String socialSecurityNumber)
    {
        this.socialSecurityNumber = socialSecurityNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
    }

    public String serialize()
    {//614-22-4216 Arnold Bennett 703-4430-2393
        return socialSecurityNumber + " " + firstName + " " + lastName + " " + phoneNumber;
    }

    private final String socialSecurityNumber;
    private final String firstName;
    private final String lastName;
    private final String phoneNumber;

    @Override
    public int compareTo(Contact contact) {
        return this.phoneNumber.compareTo(contact.getPhoneNumber());
    }
}
