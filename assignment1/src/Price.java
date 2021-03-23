import java.util.*;
public class Price  //this class holds an items's price, membership and dates at time.
{
    public Price(String productname, String membership, Date start, Date end, float price)
    {
        m_ProductName = productname;
        m_Price = price;
        m_StartDate = start;
        m_EndDate = end;
        m_Membership = membership;
    }

    private String m_ProductName;
    private float m_Price;
    private Date m_StartDate;
    private Date m_EndDate;
    private String m_Membership;

    public String get_ProductName()
    {
        return m_ProductName;
    }

    public float get_Price()
    {
        return m_Price;
    }

    public Date get_StartDate()
    {
        return m_StartDate;
    }

    public Date get_EndDate()
    {
        return m_EndDate;
    }

    public String get_Membership()
    {
        return m_Membership;
    }
}
