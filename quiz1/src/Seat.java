public class Seat {

    public Seat(int SeatID, Passenger Passenger, boolean Status){
        m_SeatID = SeatID;
        m_Passenger = Passenger;
        m_Status = Status;
    }

    public String get_Status() {
        if(m_Status){
            return "Available";
        }
        else{
            return "Reserved";
        }
    }

    public int get_SeatID() {
        return m_SeatID;
    }

    public Passenger get_Passenger() {
        return m_Passenger;
    }

    public void set_Passenger(Passenger m_Passenger) {
        this.m_Passenger = m_Passenger;
    }

    public void set_SeatID(int m_SeatID) {
        this.m_SeatID = m_SeatID;
    }

    public void set_Status(boolean m_Status) {
        this.m_Status = m_Status;
    }

    public void Display(){
        System.out.println("Seat: " + m_SeatID + " Status: " + get_Status());
        m_Passenger.Display();
    }

    private int m_SeatID; //starts from 1
    private Passenger m_Passenger;
    private boolean m_Status; //available or reserved.
}
