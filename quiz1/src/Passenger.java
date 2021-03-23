import java.util.Objects;

public class Passenger {
    public Passenger(String Name, String Surname, String Gender, Phone Phone){
        m_Name = Name;
        m_Surname = Surname;
        m_Gender = Gender;
        m_Phone = Phone;
    }

    public Phone get_Phone() {
        return m_Phone;
    }

    public String get_Gender() {
        return m_Gender;
    }

    public String get_Name() {
        return m_Name;
    }

    public String get_Surname() {
        return m_Surname;
    }

    public void set_Gender(String m_Gender) {
        this.m_Gender = m_Gender;
    }

    public void set_Name(String m_Name) {
        this.m_Name = m_Name;
    }

    public void set_Phone(Phone m_Phone) {
        this.m_Phone = m_Phone;
    }

    public void set_Surname(String m_Surname) {
        this.m_Surname = m_Surname;
    }

    public void Display()
    {
        System.out.println(m_Name + " " + m_Surname + " (" + m_Gender + ")");
        m_Phone.Display();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Passenger passenger = (Passenger) o;
        return m_Name.equals(passenger.m_Name) &&
                m_Surname.equals(passenger.m_Surname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(m_Name, m_Surname);
    }

    private String m_Name;
    private String m_Surname;
    private String m_Gender; //K or E
    private Phone m_Phone;
}
