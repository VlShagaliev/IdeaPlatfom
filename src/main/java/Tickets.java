public class Tickets {
    private String origin;
    private String origin_name;
    private String destination;
    private String destination_name;
    private String departure_date;
    private String departure_time;
    private String arrival_date;
    private String arrival_time;
    private String carrier;
    private int stops;
    private int price;

    public String getOrigin() {
        return origin;
    }

    public int getPrice() {
        return price;
    }

    public int getStops() {
        return stops;
    }

    public String getArrival_date() {
        return arrival_date;
    }

    public String getArrival_time() {
        return arrival_time;
    }

    public String getCarrier() {
        return carrier;
    }

    public String getDeparture_date() {
        return departure_date;
    }

    public String getDeparture_time() {
        return departure_time;
    }

    public String getDestination() {
        return destination;
    }

    public String getDestination_name() {
        return destination_name;
    }

    public String getOrigin_name() {
        return origin_name;
    }

    public void setArrival_date(String arrival_date) {
        this.arrival_date = arrival_date;
    }

    public void setArrival_time(String arrival_time) {
        this.arrival_time = arrival_time;
    }

    public void setCarrier(String carrier) {
        this.carrier = carrier;
    }

    public void setDeparture_date(String departure_date) {
        this.departure_date = departure_date;
    }

    public void setDeparture_time(String departure_time) {
        this.departure_time = departure_time;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public void setDestination_name(String destination_name) {
        this.destination_name = destination_name;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public void setOrigin_name(String origin_name) {
        this.origin_name = origin_name;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setStops(int stops) {
        this.stops = stops;
    }
    @Override
    public String toString(){
        return  "origin: " + this.origin + '\n'
                + "origin_name: " + this.origin_name + '\n'
                + "destination: " + this.destination + '\n'
                + "destination_name: " + this.destination_name + '\n'
                + "departure_date: " + this.departure_date + '\n'
                + "departure_time: " + this.departure_time + '\n'
                + "arrival_date: " + this.arrival_date + '\n'
                + "arrival_time: " + this.arrival_time+ '\n'
                + "carrier: " + this.carrier + '\n'
                + "stops: " + this.stops + '\n'
                + "price: " + this.price;
    }
}
