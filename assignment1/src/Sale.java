import java.util.*;

public class Sale //holds information about sales, who bought them, which membership, etc.
{
    public Sale(String customer, String membership, Date date, String productname, int quantity)
    {
        m_Customer = customer;
        m_MembershipUsed = membership;
        m_Date = date;
        m_ProductName = productname;
        m_Quantity = quantity;
    }

    public String getCustomer()
    {
        return m_Customer;
    }

    public void calculatePrices(ArrayList<Price> prices)
    {
        for(Price price : prices)
        {
            if (!price.get_ProductName().equals(m_ProductName))
                continue;
            if (!price.get_Membership().equals(m_MembershipUsed))
                continue;
            if (price.get_StartDate().compareTo(m_Date) > 0) //price start date is after our date.
                continue;
            if (price.get_EndDate().compareTo(m_Date) < 0) //price end date is before our date.
                continue;

            m_OnePrice = price.get_Price();
            m_TotalPrice = m_OnePrice * m_Quantity;
            return;
        }
    }

    public int get_Quantity()
    {
        return m_Quantity;
    }

    public float get_TotalPrice()
    {
        return m_TotalPrice;
    }

    public float get_OnePrice()
    {
        return m_OnePrice;
    }

    private String m_Customer;
    private String m_MembershipUsed;
    private Date m_Date;
    private String m_ProductName;
    private int m_Quantity;

    private float m_TotalPrice;
    private float m_OnePrice;

    public String get_ProductName()
    {
        return m_ProductName;
    }

    public Date get_Date()
    {
        return m_Date;
    }
}
