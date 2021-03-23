import java.text.ParseException;
import java.util.*;
import java.text.SimpleDateFormat;
public class Parser // this class reads input files and extracts information from them.
{
    private static Date toDate(String str)
    {
        try
        {
            return new SimpleDateFormat("dd.MM.yyyy").parse(str);
        }
        catch (ParseException e)
        {
            e.printStackTrace();
            return null;
        }
    }
    public static ArrayList<Price> parsePrices(String path)
    {
        ArrayList<Price> Prices = new ArrayList<Price>();
        String[] lines = ReadFromFile.readFile(path);
        if (lines != null)
        {
            for (String line: lines)
            {
                String[] parts = line.split("\t");
                Prices.add(new Price(parts[0], parts[1], toDate(parts[2]), toDate(parts[3]), Float.parseFloat(parts[4])));
            }
        }
        return Prices;
    }

    public static ArrayList<Sale> parseSales(String path)
    {
        ArrayList<Sale> Sales = new ArrayList<Sale>();
        String[] lines = ReadFromFile.readFile(path);
        if (lines != null)
        {
            for (String line: lines)
            {
                String[] parts = line.split("\t");
                String customer = parts[0];
                String membership = parts[1];
                Date date = toDate(parts[2]);
                String productname = null;
                boolean product = true;
                for (int i = 3; i < parts.length; i++) //read product&quantity
                {
                    if (product)
                    {
                        productname = parts[i];
                        product = false;
                    }
                    else
                    {
                        int quantity = Integer.parseInt(parts[i]);
                        product = true;
                        Sales.add(new Sale(customer, membership, date, productname, quantity));
                    }
                }
            }
        }
        return Sales;
    }

}

/*
bill:
name


 */
