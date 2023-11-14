package christmas;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.HashMap;

public class Order {
    private HashMap<Menu,Integer> sheet; // Menu name , Menu count
    private final LocalDate visitingDay;

    public Order(LocalDate visitingDay){
        this.sheet = new HashMap<>();
        this.visitingDay = visitingDay;
    }

    public DayOfWeek getDay(){
        return visitingDay.getDayOfWeek();
    }

    public Integer getDate(){
        return visitingDay.getDayOfMonth();
    }

    public Integer getNumberOfMenu(Menu menu) {
        if(sheet.containsKey(menu)){
            return sheet.get(menu);
        }
        return 0;
    }


    public void addMenu(Menu menu, Integer menuCount){
        sheet.put(menu, menuCount);
    }

}
