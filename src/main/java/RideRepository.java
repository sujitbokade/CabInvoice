import java.util.ArrayList;
import java.util.List;

public class RideRepository {
    static List<Customer> customerList = new ArrayList<>();

    static Invoice generateInvoiceByUserId(int userId) {
        for (Customer customer : customerList) {
            if (customer.getUserId() == userId) {
                return CabInvoice.generateInvoice(customer.getRides());
            }
        }
        return null;
    }
}
