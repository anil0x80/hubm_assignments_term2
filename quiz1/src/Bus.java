public class Bus {
    public Bus(String Plate, int SeatCount){
        m_Plate = Plate;
        m_SeatCount = SeatCount;
        m_Seats = new Seat[m_SeatCount]; //allocate memory
    }

    public int get_SeatCount() {
        return m_SeatCount;
    }

    public Seat[] get_Seats() {
        return m_Seats;
    }

    public String get_Plate() {
        return m_Plate;
    }

    public boolean bookSeat(Passenger p,  int seatID){
        if(seatID <= 0 || seatID > m_SeatCount || m_Seats[seatID -1] != null) //todo inform user about out of bound entries, not already booked.
            return false; //already booked
        m_Seats[seatID -1] = new Seat(seatID, p, false);
        return true;
    }

    public void printAllPassengers()
    {
        for (Seat m_seat : m_Seats) {
            if (m_seat != null) {
                m_seat.Display();
            }
        }
    }

    public void printAllAvailableSeatIDs(){
        for(int i=0; i< m_Seats.length; i++)
        {
            if(m_Seats[i] == null){
                System.out.println("Available Seat: " + (i + 1));
            }
        }

    }

    public boolean cancelBooking(int SeatID){
        for(int i=0; i< m_Seats.length; i++)
        {
            if(m_Seats[i] != null && m_Seats[i].get_SeatID() == SeatID){
                m_Seats[i] = null;
                return true;
            }
        }
        return false;
    }

    public void printAllSeats(){
        for(int i=0; i< m_Seats.length; i++)
        {
            if(m_Seats[i] == null){
                System.out.println("Available Seat: " + (i + 1));
            }
            else
            {
                m_Seats[i].Display();
            }
        }

    }

    public int getPassengerCount(){
        int count = 0;
        for (Seat m_seat : m_Seats) {
            if (m_seat != null) {
                count++;
            }
        }
        return count;
    }

    public Passenger findPassenger(Passenger toSearch)
    {
        for (Seat m_seat : m_Seats) {
            if (m_seat != null && m_seat.get_Passenger().equals(toSearch)) {
                return m_seat.get_Passenger();
            }
        }

        return null;
    }

    private String m_Plate; //06 HUBM 06
    private int m_SeatCount;
    private Seat[] m_Seats;

}
