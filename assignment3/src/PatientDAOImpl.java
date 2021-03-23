import java.util.ArrayList;
import java.util.Collections;

public class PatientDAOImpl implements PatientDAO
{
    public PatientDAOImpl(String fileName)
    {
        this.fileName = fileName;
        patientList = new ArrayList<Patient>();
        parseFile(fileName);
    }

    @Override
    public Patient getById(int id)
    {
        for (Patient patient: patientList)
        {
            if (patient.getId() == id)
                return patient;
        }

        return null;
    }

    @Override
    public Patient deleteById(int id)
    {
        for (Patient patient: patientList)
        {
            if (patient.getId() == id)
            {
                patientList.remove(patient);
                updateFile();
                return patient;
            }
        }
        return null;
    }

    @Override
    public boolean add(Patient patient)
    {
        patientList.add(patient);
        updateFile();
        return true;
    }

    @Override
    public ArrayList<Patient> getAll() {
        return patientList;
    }

    private void parseFile(String fileName)
    {
        String[] lines = ReadFromFile.readFile(fileName);
        if (lines != null)
        {
            for(String line : lines)
            {
                String[] parts = line.split("\t");
                int id = Integer.parseInt(parts[0]);
                String name = parts[1].split(" ")[0];
                String surname = parts[1].split(" ")[1];
                String phoneNumber = parts[2];
                String address = parts[3];

                patientList.add(new Patient(id, name, surname, phoneNumber, address));
            }
        }

    }

    private void updateFile() //overwrite patient file with new one.
    {
        WriteToFile fileWriter = new WriteToFile(fileName);
        Collections.sort(patientList, (o1, o2) -> o1.getId().compareTo(o2.getId()));
        int idx = 0;
        for (Patient patient : patientList)
        {
            StringBuilder line = new StringBuilder(patient.serialize());
            if (idx < patientList.size() - 1)
            {
                line.append("\n");
            }

            fileWriter.write(line.toString());
            idx++;
        }
        fileWriter.end();
    }


    private String fileName;
    private ArrayList<Patient> patientList;
}
