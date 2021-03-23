import java.util.*;
public class Main  // contains main function
{
    public static void main(String[] args)
    {
        ArrayList<Price> allPrices = Parser.parsePrices(args[1]);
        ArrayList<Sale> allSales = Parser.parseSales(args[0]);
        ArrayList<Customer> allCustomers = Customer.getCustomers(allSales, allPrices);

        for(Customer customer: allCustomers)
        {
            System.out.println("---" + customer.get_Name() + "---");
            float total = 0;
            for (Sale s : customer.get_Products())
            {
                System.out.println(s.get_ProductName() + "\t"
                        + String.format(java.util.Locale.US,"%.1f", s.get_OnePrice()) + "\t"
                        + s.get_Quantity()+ "\t"
                        + String.format(java.util.Locale.US,"%.1f", s.get_TotalPrice()));
                total += s.get_TotalPrice();
            }
            System.out.println("Total\t" + String.format(java.util.Locale.US,"%.1f",total));
        }


    }
}

