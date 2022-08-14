import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class CabInvoiceTest {

    static CabInvoice cabInvoice;

    @BeforeAll
    static void initialise() {
        cabInvoice = new CabInvoice();
    }

    @Test
    void givenDistanceAndTimeShouldReturnFare() {
        CabInvoice cabInvoice = new CabInvoice();
        double totalFare = cabInvoice.calculateFare(10, 5);
        Assertions.assertEquals(105.0, totalFare);
    }

    @Test
    void givenDistanceAndTimeShouldReturnMinFare() {
        CabInvoice cabInvoice = new CabInvoice();
        double totalFare = cabInvoice.calculateFare(0.2, 1);
        Assertions.assertEquals(5, totalFare);
    }

    @Test
    void givenMultipleRideShouldReturnAggregateTotalFare() {
        Ride ride1 = new Ride(10, 6);
        Ride ride2 = new Ride(12, 8);
        Ride ride3 = new Ride(0.2, 1);
        Ride[] rides = {ride1, ride2, ride3};
        double totalFare = cabInvoice.calculateFare(rides);
        Assertions.assertEquals(239.0, totalFare);
    }

    @Test
    void givenMultipleRideShouldReturnInvoice() {
        Ride ride1 = new Ride(10, 6);
        Ride ride2 = new Ride(12, 8);
        Ride ride3 = new Ride(0.2, 1);
        Ride[] rides = {ride1, ride2, ride3};
        Invoice actualInvoice = cabInvoice.generateInvoice(rides);
        Invoice expectedInvoice = new Invoice(3, 239.0, (239.0 / 3));
        Assertions.assertEquals(expectedInvoice, actualInvoice);

    }
}
