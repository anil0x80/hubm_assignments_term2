public class Security extends Personnel
{

    double getSalary()
    {
        double Salary = BaseSalary;
        for (int workedHoursPerWeek: WorkingHours)
        {
           if (workedHoursPerWeek < 30)
               continue; //no money this week
            int workHours = Math.min(workedHoursPerWeek, 54); //clamp it so its not bigger than maximum working hour.
            Salary += workHours * 10;
            Salary += AdditionalPayPerWeek;

        }
        Salary += getSeverancePay();
        return Salary;
    }

    int AdditionalPayPerWeek = 90; // 5 for transportation 10 for food, it is stupid to separate them
    //they have one day off per week, so 15*6 = 90 per week = 360 per month.

}


//***Consider the total working hours for the salary of the security.
// That is, if they worked less than 30 hours (total) in a week,
// they will not pay any salary including transportation (transMoney) and food (foodMoney) for that week.

//***Part-time Employees can work a minimum of 10 hours and a maximum of 20 hours a week and they are paid 18 TL per hour.
// That is, if they worked less than 10 hours in total in a week, they will not pay any salary for that week.