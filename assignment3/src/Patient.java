public class Patient
{
    //todo maybe add deserialize idk if its needed tho. would look cute .

    public Patient(int id, String name, String surname, String phoneNumber, String address)
    {

        int[][] ar = new int[3][3];
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getAddress() {
        return address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String serialize()
    {
        return Integer.toString(id) + "\t" + name + " " + surname + "\t" + phoneNumber + "\t" + address;
    }

    private int id;
    private String name;
    private String surname;
    private String address;
    private String phoneNumber;
}
