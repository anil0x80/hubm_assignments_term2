import java.util.Scanner;


public class Main {
    static void print(Object line) { //lazy
        System.out.println(line);
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Bus bus=new Bus("06 HUBM 06", 42);
        boolean run = true; //flag
        while(run){
            print("Plate: 06 HUBM 06, Total Seats: 42, Available Seats: " + (42 - bus.getPassengerCount()));
            print("1- Book a seat");
            print("2- Cancel booking");
            print("3- Print all passengers");
            print("4- Print all available seats");
            print("5- Print all seats");
            print("6- Search a passenger");
            print("7- Exit");

            System.out.print("Enter your choice: ");

            int choice =  scan.nextInt();

            switch(choice){
                case 1:
                    System.out.print("Choose seat ID (1-42): ");
                    int requested_seat =  scan.nextInt();
                    System.out.print("Enter your name: ");
                    String name = scan.next();
                    System.out.print("Enter your surname: ");
                    String surname = scan.next();
                    System.out.print("Enter your gender (E-K): ");
                    String gender = scan.next();
                    System.out.print("Enter phone country code: ");
                    String country_code = scan.next();
                    System.out.print("Enter phone code: ");
                    String code = scan.next();
                    System.out.print("Enter phone number: ");
                    String number = scan.next();
                    System.out.print("Enter phone type: ");
                    String type = scan.next();
                    if (bus.bookSeat(new Passenger(name, surname, gender, new Phone(country_code,code,number,type)), requested_seat))
                        print("Successfully booked seat with id: "+ requested_seat);
                    else
                        print("Sorry, this seat is already booked!");
                    break;
                case 2:
                    System.out.print("Please enter your seat ID to cancel booking: ");
                    int canceled_seat =  scan.nextInt();
                    if(bus.cancelBooking(canceled_seat))
                        print("Successfully canceled booking for seat id: "+ canceled_seat);
                    else
                        print("Sorry, no booking found for seat id: " + canceled_seat);
                    break;
                case 3:
                    bus.printAllPassengers();
                    break;
                case 4:
                    bus.printAllAvailableSeatIDs();
                    break;
                case 5:
                    bus.printAllSeats();
                    break;
                case 6:
                    System.out.print("Enter name to search: ");
                    String search_name = scan.next();
                    System.out.print("Enter surname to search: ");
                    String search_surname = scan.next();
                    Passenger found = bus.findPassenger(new Passenger(search_name, search_surname, "",null ));
                    if (found != null)
                    {
                        found.Display();
                    }
                    else
                        print("Passenger not found!");
                    break;
                case 7:
                    run = false;
                    break;
                default:
                    print("Please enter a valid number!");
                    break;
            }
            try
            {
                Thread.sleep(2000);
            }
            catch(InterruptedException ex)
            {
                Thread.currentThread().interrupt();
            }
        }

    }
}
