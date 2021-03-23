import java.util.ArrayList;

import static java.lang.String.valueOf;

public class Main
{
    public static void main(String[] args)
    {
        String[] lines = ReadFromFile.readFile(args[0]);
        WriteToFile writeToFile = new WriteToFile("octal.txt");

        ArrayList<Integer> numbers = new ArrayList<Integer>();
        for(String line : lines)
        {
            numbers.add(Integer.parseInt(line));
        }

        int idx = 0;
        for (int decimalNumber: numbers)
        {
            MyStack stack = new MyStack();
            while (decimalNumber != 0)
            {
                stack.push(decimalNumber % 8); //push reminder
                decimalNumber /= 8;
            }

            StringBuilder octal = new StringBuilder();
            while (!stack.isEmpty())
            {
                octal.append(valueOf(stack.pop()));
            }
            writeToFile.write(octal.toString());
            if (idx != numbers.size() - 1)
            {
                writeToFile.write("\n");
            }
            idx++;
        }
        writeToFile.end(); //i wish java had destructors
    }
}
