public class Route {
    public Route(String origin, String destination, int minutesElapsed, String type)
    {
        this.origin = origin;
        this.destination = destination;
        this.minutesElapsed = minutesElapsed;
        this.type = type;
    }

    String origin;
    String destination;
    int minutesElapsed;

    String type;

    void Info()
    {
        System.out.println(origin + " - " + destination + " - " + minutesElapsed + " minutes. " + type + ".");
    }
}
