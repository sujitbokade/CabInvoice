import java.util.Objects;

public class Invoice {

    private int rideCount;
    private double totalFare;
    private double avgFare;

    public Invoice(){

    }

    public Invoice(int rideCount, double totalFare, double avgFare) {
        this.rideCount = rideCount;
        this.totalFare = totalFare;
        this.avgFare = avgFare;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Invoice invoice = (Invoice) o;
        return rideCount == invoice.rideCount && Double.compare(invoice.totalFare, totalFare) == 0 && Double.compare(invoice.avgFare, avgFare) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(rideCount, totalFare, avgFare);
    }

    @Override
    public String toString() {
        return "Invoice{" +
                "rideCount=" + rideCount +
                ", totalFare=" + totalFare +
                ", avgFare=" + avgFare +
                '}';
    }
}
