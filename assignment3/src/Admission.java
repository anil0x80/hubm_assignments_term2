import java.util.ArrayList;

public class Admission
{
    public Admission()
    {
        examinations = new ArrayList<Examination>();
    }

    public Admission(int admissionId, int patientId)
    {
        examinations = new ArrayList<Examination>();
        this.admissionId = admissionId;
        this.patientId = patientId;
    }
    public void addExamination(Examination examination)
    {
        examinations.add(examination);
    }

    public boolean isEmpty()
    {
        return examinations.isEmpty();
    }

    public void setAdmissionId(int admissionId) {
        this.admissionId = admissionId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public String serialize()
    {
        StringBuilder sb = new StringBuilder();
        sb.append(admissionId + "\t" + patientId + '\n');
        for (Examination examination : examinations)
        {
            sb.append(examination.serialize());
            sb.append("\n");
        }
        sb.setLength(sb.length() - 1); //remove last unneeded newline

        return sb.toString();
    }
    public ArrayList<Examination> getExaminations() {

        return examinations;
    }

    public Integer getAdmissionId()
    {
        return admissionId;
    }

    public int getPatientId() {
        return patientId;
    }

    public int getTotalCost()
    {
        int totalCost = 0;
        for (Examination examination:examinations)
        {
            totalCost += examination.cost();
        }
        return totalCost;
    }
    private int admissionId;
    private int patientId;
    private ArrayList<Examination> examinations;
}
