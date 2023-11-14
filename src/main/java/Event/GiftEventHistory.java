package Event;

import christmas.Menu;
import java.util.List;

public class GiftEventHistory implements EventHistory{

    private final String eventName;
    private Menu gift;

    public GiftEventHistory(String eventName, Menu gifts) {
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

    public Menu getGift(){
        return gift;
    }
}
