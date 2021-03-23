import java.util.*;

public class Customer //defines Customer class, which is people who bought things.
{
    static ArrayList<Customer> getCustomers(ArrayList<Sale> allSales, ArrayList<Price> allPrices)
    {
        ArrayList<Customer> allCustomers = new ArrayList<Customer>();
        for (Sale sale : allSales)
        {
            sale.calculatePrices(allPrices);
            Customer customer = new Customer(sale.getCustomer());
            customer.addSale(sale);
            if (!allCustomers.contains(customer))
            {
                allCustomers.add(customer);
            }
            else // it already contains.
            {
                allCustomers.get(allCustomers.indexOf(customer)).addSale(sale);
            }
        }
        return allCustomers;
    }
    public Customer(String name)
    {
        m_Name = name;
        m_Products = new ArrayList<Sale>();
    }

    public void addSale(Sale sale)
    {
        m_Products.add(sale);
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        if (!m_Products.isEmpty() && !((Customer) o).m_Products.isEmpty())
        {
            Date d1 = m_Products.get(0).get_Date();
            Date d2 = ((Customer) o).m_Products.get(0).get_Date();
            return Objects.equals(m_Name, customer.m_Name) && Objects.equals(d1, d2);
        }
        return Objects.equals(m_Name, customer.m_Name);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(m_Name);
    }

    private String m_Name;
    private ArrayList<Sale> m_Products;

    public ArrayList<Sale> get_Products()
    {
        return m_Products;
    }

    public String get_Name()
    {
        return m_Name;
    }
}
