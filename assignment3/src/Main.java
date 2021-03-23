public class Main
{
    public static void main(String[] args)
    {
        RunCommand.parseAndRun("input.txt");


        Operation operation = new Imaging(new Measurements(new BaseOperation())); //create a operation
        operation.cost(); //returns cost of imaging + measurements.
    }
}
