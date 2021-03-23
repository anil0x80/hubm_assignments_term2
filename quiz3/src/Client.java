public class Client {
    private Vendor SelectedVendor;

    void setSelectedVendor(Vendor newVendor)
    {
        SelectedVendor = newVendor;
    }


    void printInfo()
    {
        SelectedVendor.makeReservation();


        for (Route r : SelectedVendor.getRoutes())
        {
            r.Info();
        }
        //print route details
        System.out.println(SelectedVendor.hello());

    }
}
