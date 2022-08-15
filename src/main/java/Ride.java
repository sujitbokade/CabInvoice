public class Ride {

    public enum Category{
        NORMAL_RIDE(10, 1, 5), PREMIUM_RIDE(15, 2, 20);

        public double costPerKm;
        public int costPerMinute;
        public double minimumFarePerRide;

        Category(double costPerKm, int costPerMinute, double minimumFarePerRide) {
            this.costPerKm = costPerKm;
            this.costPerMinute = costPerMinute;
            this.minimumFarePerRide = minimumFarePerRide;
        }
    }

    private double distance;
    private int time;
    private Category category;

    public Ride(Category category,double distance, int time) {
        this.category = category;
        this.distance = distance;
        this.time = time;
    }

    public double getDistance() {
        return distance;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }
}
