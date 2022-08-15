import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class CabInvoiceTest {

    @Test
    void givenDistanceAndTimeShouldReturnFare(){
        double totalFare = CabInvoice.calculateFare(10,5);
        Assertions.assertEquals(105.0,totalFare);
    }

    @Test
    void givenDistanceAndTimeShouldReturnMinFare(){
        double totalFare = CabInvoice.calculateFare(0.2,1);
        Assertions.assertEquals(5.0,totalFare);
    }

    @Test
    void givenMultipleRidesShouldReturnAggregateTotalFare(){
        Ride ride1 = new Ride(Ride.Category.NORMAL_RIDE,10,6);
        Ride ride2 = new Ride(Ride.Category.NORMAL_RIDE,15,8);
        Ride ride3 = new Ride(Ride.Category.NORMAL_RIDE,0.2,1);
        Ride[] rides = {ride1,ride2,ride3};
        double totalFare = CabInvoice.calculateFare(rides);
        Assertions.assertEquals(269.0,totalFare);
    }

    @Test
    void givenMultipleRideShouldReturnInvoice(){
        Ride ride1 = new Ride(Ride.Category.NORMAL_RIDE,10,6);
        Ride ride2 = new Ride(Ride.Category.NORMAL_RIDE,15,8);
        Ride ride3 = new Ride(Ride.Category.NORMAL_RIDE,0.2,1);
        Ride[] rides = {ride1,ride2,ride3};
        Invoice actualInvoice = CabInvoice.generateInvoice(rides);
        Invoice expectedInvoice = new Invoice(3,269.0,(269.0/3));
        Assertions.assertEquals(expectedInvoice,actualInvoice);
    }

    @Test
    void givenUserIdShouldReturnTheInvoice(){
        Ride ride1 = new Ride(Ride.Category.NORMAL_RIDE,10,6);
        Ride ride2 = new Ride(Ride.Category.NORMAL_RIDE,15,8);
        Ride ride3 = new Ride(Ride.Category.NORMAL_RIDE,0.2,1);
        Ride[] rides1 = {ride1,ride2,ride3};
        Ride ride4 = new Ride(Ride.Category.PREMIUM_RIDE,8,4);
        Ride ride5 = new Ride(Ride.Category.PREMIUM_RIDE,6,3);
        Ride ride6 = new Ride(Ride.Category.PREMIUM_RIDE,0.2,1);
        Ride[] rides2 = {ride4,ride5,ride6};
        Customer customer1 = new Customer(1,rides1);
        Customer customer2 = new Customer(2,rides2);
        RideRepository.customerList.add(customer1);
        RideRepository.customerList.add(customer2);
        Invoice actualInvoice = RideRepository.generateInvoiceByUserId(1);
        Invoice expectedInvoice = new Invoice(3,269.0,(269.0/3));
        Assertions.assertEquals(expectedInvoice,actualInvoice);
    }

    @Test
    void givenUserIdShouldReturnTheInvoiceForRespectiveRides(){
        Ride ride1 = new Ride(Ride.Category.NORMAL_RIDE,10,6);
        Ride ride2 = new Ride(Ride.Category.NORMAL_RIDE,15,8);
        Ride ride3 = new Ride(Ride.Category.NORMAL_RIDE,0.2,1);
        Ride[] rides1 = {ride1,ride2,ride3};
        Ride ride4 = new Ride(Ride.Category.PREMIUM_RIDE,8,4);
        Ride ride5 = new Ride(Ride.Category.PREMIUM_RIDE,6,3);
        Ride ride6 = new Ride(Ride.Category.PREMIUM_RIDE,0.2,1);
        Ride[] rides2 = {ride4,ride5,ride6};
        Customer customer1 = new Customer(1,rides1);
        Customer customer2 = new Customer(2,rides2);
        RideRepository.customerList.add(customer1);
        RideRepository.customerList.add(customer2);
        Invoice actualInvoice= RideRepository.generateInvoiceByUserId(2);
        Invoice expectedInvoice = new Invoice(3,244.0,(244.0/3));
        Assertions.assertEquals(expectedInvoice,actualInvoice);
    }
}
