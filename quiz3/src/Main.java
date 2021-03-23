public class Main {
    public static void main(String[] args) {
        Client client = new Client();
        if(false)
        {
            System.out.println("User selected vendor1");
            client.setSelectedVendor(new Vendor1());
            //use vendor1 strategy
        }
        else
        {
            System.out.println("User selected vendor2");
            client.setSelectedVendor(new Vendor2());
            //use vendor2 strategy
        }

        client.printInfo();;
    }
}
