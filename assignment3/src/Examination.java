public class Examination
{
    public Examination(boolean isInPatient)
    {
        this.isInPatient = isInPatient;
    }

    public void addOperations(OperationDecorator operations)
    {
        this.operations = operations;
    }

    public int cost()
    {
        if (isInPatient)
            return operations.cost() + 10;
        else
            return operations.cost() + 15; //outpatient
    }

    public String serialize()
    {
        StringBuilder sb = new StringBuilder();
        if (isInPatient)
            sb.append("Inpatient\t");
        else
            sb.append("Outpatient\t");

        sb.append(operations.serialize());
        sb.setLength(sb.length() - 1); //delete last blank
        return sb.toString();
    }

    public boolean isInPatient() {
        return isInPatient;
    }

    private OperationDecorator operations;
    private boolean isInPatient;
}
