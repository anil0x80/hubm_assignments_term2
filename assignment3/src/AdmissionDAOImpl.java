import java.util.ArrayList;
import java.util.Collections;

public class AdmissionDAOImpl implements AdmissionDAO
{
    public AdmissionDAOImpl(String fileName)
    {
        this.fileName = fileName;
        admissionList = new ArrayList<Admission>();
        parseFile(fileName);
    }

    @Override
    public Admission getById(int id)
    {
        for (Admission admission: admissionList)
        {
            if (admission.getAdmissionId() == id)
            {
                return admission;
            }
        }

        return null;
    }

    @Override
    public boolean deleteById(int id)
    {
        for (Admission admission: admissionList)
        {
            if (admission.getAdmissionId() == id)
            {
                admissionList.remove(admission);
                updateFile();
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean add(Admission admission, boolean updateFile)
    {
        admissionList.add(admission);
        if (updateFile)
            updateFile();
        return false;
    }

    @Override
    public ArrayList<Admission> getAll() {
        return admissionList;
    }

    private void parseFile(String fileName)
    {
        String[] lines = ReadFromFile.readFile(fileName);
        if (lines != null)
        {
            boolean header = true;
            Admission admission = new Admission();
            int idx = 0;
            for(String line : lines)
            {
                header = line.charAt(0) != 'I' && line.charAt(0) != 'O';
                if (header)
                {
                    if (!admission.isEmpty())
                    {
                        admissionList.add(admission);
                        admission = new Admission();
                    }

                    String[] parts = line.split("\t");
                    int admissionId = Integer.parseInt(parts[0]);
                    int patientId = Integer.parseInt(parts[1]);
                    admission.setAdmissionId(admissionId);
                    admission.setPatientId(patientId);
                }
                else
                {
                    Examination examination = null;
                    String[] parts = line.split("\t");
                    if (parts[0].equals("Outpatient"))
                    {
                        examination = new Examination(false);
                    }
                    else
                    {
                        examination = new Examination(true);
                    }

                    String[] operations = parts[1].split(" ");
                    OperationDecorator operationDecorator = parseOperations(operations);

                    examination.addOperations(operationDecorator);

                    admission.addExamination(examination);
                    if (idx == lines.length - 1) // add immediately cuz of eof.
                        admissionList.add(admission);
                }
                idx++;
            }
        }

    }

    public OperationDecorator parseOperations(String[] operations)
    {
        OperationDecorator operationDecorator = new OperationDecorator();
        int i = 0;
        for (String operation: operations)
        {
            Operation decorator = null;
            if (i == operations.length - 1)
                decorator = new BaseOperation();
            switch(operation) //here i am using a custom add method to not write a lot of if-else
            {
                case "imaging":
                    operationDecorator.add(new Imaging(decorator));
                    break;
                case "measurements":
                    operationDecorator.add(new Measurements(decorator));
                    break;
                case "tests":
                    operationDecorator.add(new Tests(decorator));
                    break;
                case "doctorvisit":
                    operationDecorator.add(new DoctorVisit(decorator));
                    break;
            }
            i++;
        }

        return operationDecorator;
    }

    public boolean deleteByPatientId(int patientId)
    {
        for (Admission admission: admissionList)
        {
            if (admission.getPatientId() == patientId)
            {
                admissionList.remove(admission);
                updateFile();
                return true;
            }
        }
        return false;
    }

    public void updateFile() //overwrite patient file with new one
    {
        WriteToFile fileWriter = new WriteToFile(fileName);
        Collections.sort(admissionList, (o1, o2) -> o1.getAdmissionId().compareTo(o2.getAdmissionId()));
        int idx = 0;
        for (Admission admission : admissionList)
        {
            StringBuilder sb = new StringBuilder(admission.serialize());
            if (idx < admissionList.size() - 1)
            {
                sb.append("\n");
            }

            fileWriter.write(sb.toString());
            idx++;
        }
        fileWriter.end();
    }

    private ArrayList<Admission> admissionList;
    private String fileName;
}
