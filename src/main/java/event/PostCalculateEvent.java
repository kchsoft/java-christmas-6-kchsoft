package event;

import eventhistory.EventHistories;
import eventhistory.EventHistory;

public interface PostCalculateEvent {

    public EventHistory apply(EventHistories histories);

}