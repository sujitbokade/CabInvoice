public class CabInvoice {
    static final int COST_PER_DISTANCE = 10;
    static final int COST_PER_MINUTE = 1;

    public double calculateFare(double distance, int time) {
        double totalFare = distance * COST_PER_DISTANCE + time * COST_PER_MINUTE;
        if (totalFare <= 5)
            return 5;
        return totalFare;
    }

    public double calculateFare(Ride[] rides) {
        double totalFare = 0;
        for (Ride ride:rides) {
           double rideFare = calculateFare(ride.getDistance(),ride.getTime());
           totalFare+=rideFare;
        }
        return totalFare;
    }

    public Invoice generateInvoice(Ride[] rides){
       double totalFare = calculateFare(rides);
       int rideCount = rides.length;
       double avgFare = totalFare/rideCount;
       return new Invoice(rideCount,totalFare,avgFare);
    }
}
