package eventhistory;

import java.util.LinkedList;
import java.util.List;

public class EventHistories {

    private final List<EventHistory> eventHistories;

    public EventHistories() {
        eventHistories = new LinkedList<>();
    }

    public void add(EventHistory history) {
        eventHistories.add(history);
    }

    public Integer sumOfDiscount() {
        Integer discount = 0;
        for (EventHistory history : eventHistories) {
            discount += history.getBenefitValue();
        }
        return discount;
    }
}
