package Event.Gift;

import Event.EventHistory;
import christmas.Menu;

public class GiftEventHistory implements EventHistory<Menu> {

    private final String eventName;
    private Menu gift;

    public GiftEventHistory(String eventName, Menu gift) {
        this.eventName = eventName;
        this.gift = gift;
    }

    @Override
    public String explainName() {
        return eventName;
    }

    @Override
    public String explainBenefit() {
        return gift.getName();
    }

    @Override
    public Menu getBenefit(){
        return gift;
    }
}
