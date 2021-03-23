import java.util.ArrayList;

public interface AdmissionDAO
{
    Admission getById(int id);
    boolean deleteById(int id);
    boolean add(Admission admission, boolean updateFile);
    ArrayList<Admission> getAll();
}
