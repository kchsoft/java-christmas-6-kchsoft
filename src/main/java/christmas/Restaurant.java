package christmas;

import customer.Customer;
import customer.Reservation;
import customer.VisitingDay;
import order.Orders;
import view.InputView;
import view.OutputView;

public class Restaurant {

    private final Watier watier;

    public Restaurant() {
        watier = new Watier();
    }

    public void open(){
        InputView.welcome();
        Customer customer = new Customer();
        VisitingDay day = getVisitingDayOf(customer);
        Orders orders = getOrderOf(customer);
        Reservation reservation = new Reservation(day,orders);
        Reception reception = watier.confirm(reservation);
        OutputView.showBenefitHistory(reception);
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

    private VisitingDay getVisitingDayOf(Customer customer) {
        VisitingDay day = null;
        while (day == null) {
            try {
                // input view
                day = customer.selectDay();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return day;
    }
}
