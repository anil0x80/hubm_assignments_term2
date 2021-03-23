import java.io.*;

public class WriteToFile
{
    public WriteToFile(String Path)
    {
        try
        {
            fileObject = new File(Path);
            if (fileObject.createNewFile())
                System.out.println("File created: " + Path);
            else
                System.out.println("File already exists, overwriting: " + Path);

            writerObject = new FileWriter(Path);
        }
        catch (IOException e)
        {
            System.out.println("Error occurred opening file!");
            e.printStackTrace();
        }


    }
    public void WriteLine(String Line)
    {
        try
        {
            writerObject.write(Line);
        }
        catch (IOException e)
        {
            System.out.println("Error occurred in WriteLine!");
            e.printStackTrace();
        }
    }

    public void End()
    {
        try
        {
            writerObject.close();
        }
        catch (IOException e)
        {
            System.out.println("Error occurred in End()!");
            e.printStackTrace();
        }
    }

    File fileObject;
    FileWriter writerObject;
}