import java.util.ArrayList;
import java.util.Arrays;

public class RunCommand
{
    static public void parseAndRun(String fileName) //todo output to file instead of console..
    {
        PatientDAOImpl patientDAO = new PatientDAOImpl("patient.txt");
        AdmissionDAOImpl admissionDAO = new AdmissionDAOImpl("admission.txt");
        WriteToFile fileWriter = new WriteToFile("output.txt");

        String[] lines = ReadFromFile.readFile(fileName);
        if (lines != null)
        {
            for(String line : lines)
            {
                String[] parts = line.split(" ");
                String command = parts[0];

                switch(command)
                {
                    case "AddPatient":
                    {
                        System.out.println("AddPatient");
                        String[] addressWords = Arrays.copyOfRange(parts, 5, parts.length);
                        String fullAddress = "Address: " + String.join(" ", addressWords);

                        Patient patient = new Patient(Integer.parseInt(parts[1]), parts[2], parts[3], parts[4], fullAddress);
                        patientDAO.add(patient);
                        fileWriter.write("Patient " + parts[1] + " " + parts[2] + " added\n");
                        break;
                    }
                    case "RemovePatient":
                    {
                        System.out.println("RemovePatient");
                        Patient removed = patientDAO.deleteById(Integer.parseInt(parts[1]));
                        admissionDAO.deleteByPatientId(Integer.parseInt(parts[1]));
                        fileWriter.write("Patient " + parts[1] + " " + removed.getName() + " removed\n");
                        break;
                    }

                    case "CreateAdmission":
                    {
                        System.out.println("CreateAdmission");
                        int admissionId = Integer.parseInt(parts[1]);
                        int patientId = Integer.parseInt(parts[2]);
                        Admission admission = new Admission(admissionId, patientId);
                        admissionDAO.add(admission, false);
                        fileWriter.write("Admission " + admissionId + " created\n");
                        break;
                    }
                    case "AddExamination":
                    {
                        System.out.println("AddExamination");
                        //AddExamination 7 Inpatient tests doctorvisit
                        int admissionId = Integer.parseInt(parts[1]);
                        boolean isInPatient = parts[2].equals("Inpatient");
                        String[] operations = Arrays.copyOfRange(parts, 3, parts.length);
                        OperationDecorator operationDecorator = admissionDAO.parseOperations(operations);
                        Examination examination = new Examination(isInPatient);
                        examination.addOperations(operationDecorator);
                        admissionDAO.getById(admissionId).addExamination(examination);

                        admissionDAO.updateFile();

                        fileWriter.write(parts[2] + " examination added to admission " + admissionId + "\n");
                        break;
                    }
                    case "TotalCost":
                    {
                        //TotalCost 7
                        System.out.println("TotalCost");
                        int admissionId = Integer.parseInt(parts[1]);
                        Admission admission = admissionDAO.getById(admissionId);
                        ArrayList<Examination> examinations = admission.getExaminations();
                        fileWriter.write("Total cost for admission " + admissionId + "\n");
                        for (Examination examination : examinations)
                        {
                            fileWriter.write("\t" + examination.serialize().replace("\t", " ")
                                    + " " + examination.cost() + "$\n");
                        }
                        fileWriter.write("\tTotal: " + admission.getTotalCost() + "$\n");
                        break;
                    }

                    case "ListPatients":
                    {
                        System.out.println("ListPatients");
                        fileWriter.write("Patient List:\n");
                        ArrayList<Patient> patientList = patientDAO.getAll();
                        for (Patient patient: patientList)
                        {
                            fileWriter.write(patient.serialize().replace("\t", " "));
                            if (patientList.indexOf(patient) < patientList.size() - 1)
                                fileWriter.write("\n");
                        }
                        break;
                    }

                }
            }
        }

        fileWriter.end();
    }
}
