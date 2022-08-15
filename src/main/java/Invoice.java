import java.util.Objects;

public class Invoice {

    private int ridesCount;
    private double totalFare;
    private double avgFare;


    public Invoice(int ridesCount, double totalFare, double avgFare) {
        this.ridesCount = ridesCount;
        this.totalFare = totalFare;
        this.avgFare = avgFare;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Invoice invoice = (Invoice) o;
        return ridesCount == invoice.ridesCount && Double.compare(invoice.totalFare, totalFare) == 0 && Double.compare(invoice.avgFare, avgFare) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(ridesCount, totalFare, avgFare);
    }

    @Override
    public String toString() {
        return "Invoice{" +
                "ridesCount=" + ridesCount +
                ", totalFare=" + totalFare +
                ", avgFare=" + avgFare +
                '}';
    }
}
