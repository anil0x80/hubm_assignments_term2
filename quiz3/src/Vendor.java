public interface Vendor {
    String hello();
    void makeReservation();
    Route[] getRoutes();

}

class Vendor1 implements Vendor
{
    @Override
    public String hello() {
        return "BiletAl.com'a hoş geldiniz!, bütün uçaklar sizin olsun!";
    }

    @Override
    public void makeReservation() {

    }

    @Override
    public Route[] getRoutes() {
        Route[] routes = new Route[5];
        routes[0] = new Route("Asti", "Airport", 80, "Rent A Car");
        routes[1] = new Route("Asti", "Airport", 100, "Taxi Service");
        routes[2] = new Route("Home", "Airport", 315, "Shuttle Service");
        routes[3] = new Route("Kizilay", "Airport", 305, "Limousine");
        routes[4] = new Route("YHT", "Airport", 160, "City Bus");

        return routes;
    }
}

class Vendor2 implements Vendor
{

    @Override
    public String hello() {
        return "azdim.xxx'e hoş geldiniz!, bütün orospular sizin olsun!";
    }

    @Override
    public void makeReservation() {

    }

    @Override
    public Route[] getRoutes() {
        Route[] routes = new Route[5];
        routes[0] = new Route("Asti", "Airport", 65, "Rent A Car");
        routes[1] = new Route("Asti", "Airport", 85, "Taxi Service");
        routes[2] = new Route("Home", "Airport", 240, "Shuttle Service");
        routes[3] = new Route("Kizilay", "Airport", 65, "Limousine");
        routes[4] = new Route("YHT", "Airport", 130, "City Bus");

        return routes;
    }
}