public class Phone
{
    public Phone(String CountryCode, String Code, String Number, String Type)
    {
        m_CountryCode = CountryCode;
        m_Code = Code;
        m_Number = Number;
        m_Type = Type;
    }

    public Phone(String Code, String Number, String Type)
    {
        m_CountryCode = "+90";
        m_Code = Code;
        m_Number = Number;
        m_Type = Type;
    }

    public String get_Code() {
        return m_Code;
    }

    public String get_CountryCode() {
        return m_CountryCode;
    }

    public String get_Number() {
        return m_Number;
    }

    public String get_Type() {
        return m_Type;
    }

    public void set_CountryCode(String m_CountryCode) {
        this.m_CountryCode = m_CountryCode;
    }

    public void set_Code(String m_Code) {
        this.m_Code = m_Code;
    }

    public void set_Number(String m_Number) {
        this.m_Number = m_Number;
    }

    public void set_Type(String m_Type) {
        this.m_Type = m_Type;
    }

    public void Display(){
        System.out.println(m_Type + " Phone:" + m_Code + " " + m_CountryCode + " " + m_Number);
    }

    private String m_CountryCode; //+90
    private String m_Code; //TR
    private String m_Number;
    private String m_Type; //mobile
}
