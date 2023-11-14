package christmas;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.HashMap;

public class Order {
    private HashMap<FoodMenu,Integer> sheet; // foodName , foodNumber
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

    public Integer getNumberOfMenu(FoodMenu foodMenu) {
        if(sheet.containsKey(foodMenu)){
            return sheet.get(foodMenu);
        }
        return 0;
    }

    public void addFood(FoodMenu foodMenu,Integer menuCount){
        sheet.put(foodMenu, menuCount);
    }

}
