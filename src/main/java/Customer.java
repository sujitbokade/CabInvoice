public class Customer {
    private int userId;
    private Ride[] rides;

    public Customer(int userId, Ride[] rides) {
        this.userId = userId;
        this.rides = rides;
    }

    public Customer() {
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Ride[] getRides() {
        return rides;
    }

    public void setRides(Ride[] rides) {
        this.rides = rides;
    }
}
