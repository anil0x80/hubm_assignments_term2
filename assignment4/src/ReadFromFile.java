import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ReadFromFile // reads text files.
{
    public static String[] readFile(String Path)
    {
        try
        {
            int i = 0;
            int length = Files.readAllLines(Paths.get(Path)).size();
            String[] results = new String[length];
            for (String line : Files.readAllLines(Paths.get(Path)))
            {
                results[i++] = line;
            }
            return results;
        }
        catch(IOException e)
        {
            e.printStackTrace();
            return null;
        }
    }
}
