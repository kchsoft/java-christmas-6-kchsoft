package christmas;

import Event.EventHistory;
import java.util.ArrayList;
import java.util.List;

public class Receipt {
    private Order order;
    private List<EventHistory> history;

    public Receipt(Order order){
        this.order = order;
        history = new ArrayList<>();
    }

    public void addHistory(EventHistory eventHistory){
        history.add(eventHistory);
    }

}
