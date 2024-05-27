package restaurant;

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
        Reception reception = null;

        while(reception == null){
            Orders orders = getOrderOf(customer);
            reception = watier.confirm(new Reservation(day,orders));
        }

        OutputView.showReservationResult(reception);
    }

    private Orders getOrderOf(Customer customer) {
        Orders orders = null;
        while (orders == null) {
            try {
                InputView.guideOrder();
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
                InputView.guideVisitingDay();
                day = customer.selectDay();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return day;
    }
}
