public class PartTimeEmployee extends Employee
{
    double getSalary()
    {
        double Salary = 0;
        for (int workedHoursPerWeek: WorkingHours)
        {
            if (workedHoursPerWeek < 10)
                continue; //no money this week
            int workHours = Math.min(workedHoursPerWeek, 20); //clamp it so its not bigger than maximum working hour.
            Salary += workHours * 18;
        }
        Salary += getSeverancePay();
        return Salary;
    }
}
