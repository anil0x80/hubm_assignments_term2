import java.util.ArrayList;

public class Personnel
{
    public Personnel()
    {
        WorkingHours = new ArrayList<Integer>();
    }

    public String getInfo()
    {
        String out = "Name : " + Name + "\n";
        out += "Surname : " + Surname + "\n";
        out += "Registration Number : " + RegNumber + "\n";
        out += "Position : " + Position + "\n";
        out += "Year of Start : " + StartDate + "\n";
        out += "Total Salary : " + getSalary() + "0 TL";
        return out;
    }

    double getSeverancePay()
    {
        return (2020 - Integer.parseInt(StartDate)) * 20 * 0.8;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setSurname(String surname) {
        Surname = surname;
    }

    public void setRegNumber(String regNumber) {
        RegNumber = regNumber;
    }

    public void setPosition(String position) {
        Position = position;
    }

    public void setStartDate(String startDate) {
        StartDate = startDate;
    }

    private String Name;
    private String Surname;
    private String RegNumber;
    private String Position;
    private String StartDate;

    //below will be set at subclasses, so they are "protected"
    protected ArrayList<Integer> WorkingHours;
    protected int DefaultWorkHours;
    protected int BaseSalary;
    protected int SpecialServiceBenefits;
    protected int MaximumAdditionalHours;
    protected int PayPerAdditionalHour;

    public String getName()
    {
        return Name;
    }

    public String getSurname()
    {
        return Surname;
    }

    public String getRegNumber()
    {
        return RegNumber;
    }

    public String getPosition()
    {
        return Position;
    }

    public String getStartDate()
    {
        return StartDate;
    }

    public ArrayList<Integer> getWorkingHours()
    {
        return WorkingHours;
    }

    double getSalary()
    {
        double Salary = BaseSalary + SpecialServiceBenefits;
        for (int workedHoursPerWeek: WorkingHours)
        {
            if(workedHoursPerWeek > DefaultWorkHours)
            {
                //if he worked extra, add it.
                int Extra = Math.min(workedHoursPerWeek - DefaultWorkHours, MaximumAdditionalHours);
                Salary += Extra * PayPerAdditionalHour;
            }
        }

        Salary += getSeverancePay();
        return Salary;
    }

}
