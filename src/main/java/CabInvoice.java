public class CabInvoice {
    public static double calculateFare(double distance, int time) {
        double totalFare = distance * Ride.Category.NORMAL_RIDE.costPerKm + time * Ride.Category.NORMAL_RIDE.costPerMinute;
        if (totalFare <= Ride.Category.NORMAL_RIDE.minimumFarePerRide)
            return Ride.Category.NORMAL_RIDE.minimumFarePerRide;
        return totalFare;
    }

    public static double calculateFare(Ride.Category category, double distance, int time) {
        if (category.equals(Ride.Category.PREMIUM_RIDE)) {
            double totalFare = distance * category.costPerKm+ time * category.costPerMinute;
            if (totalFare <= category.minimumFarePerRide)
                return category.minimumFarePerRide;
            return totalFare;
        } else if(category.equals(Ride.Category.NORMAL_RIDE)) {
            double totalFare = distance * category.costPerKm + time * category.costPerMinute;
            if (totalFare <= category.minimumFarePerRide)
                return category.minimumFarePerRide;
            return totalFare;
        } else
            return 0;
    }

    public static double calculateFare(Ride[] rides) {
        double totalFare = 0;
        for (Ride ride : rides) {
            double rideFare = calculateFare(ride.getCategory(), ride.getDistance(), ride.getTime());
            totalFare += rideFare;
        }
        return totalFare;
    }


    public static Invoice generateInvoice(Ride[] rides) {
        double totalFare = calculateFare(rides);
        int ridesCount = rides.length;
        double avgFare = totalFare / ridesCount;
        return new Invoice(ridesCount, totalFare, avgFare);
    }
}
