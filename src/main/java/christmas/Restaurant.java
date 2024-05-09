package christmas;

import customer.Customer;
import customer.VisitingDay;
import order.Orders;

public class Restaurant {

    public Restaurant() {
    }

    public void open(){
        Customer customer = new Customer();
        VisitingDay day = getReserveOf(customer);
        Orders orders = getOrderOf(customer);
    }

    private Orders getOrderOf(Customer customer) {
        Orders orders = null;
        while (orders == null) {
            // input view
            try {
                orders = customer.order();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return orders;
    }

    private VisitingDay getReserveOf(Customer customer) {
        VisitingDay day = null;
        while (day == null) {
            try {
                // input view
                day = customer.reserve();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return day;
    }
}
