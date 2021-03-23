import java.util.ArrayList;

interface PatientDAO
{
    Patient getById(int id);
    Patient deleteById(int id);
    boolean add(Patient patient);
    ArrayList<Patient> getAll();
}
