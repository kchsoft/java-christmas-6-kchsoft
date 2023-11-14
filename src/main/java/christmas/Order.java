package christmas;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

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

    public Integer countNumberOf(Menu menu) {
        if(sheet.containsKey(menu)){
            return sheet.get(menu);
        }
        return 0;
    }

    public List<Menu> getMenusOfType(String type){
        List<Menu> menus = new ArrayList<>();
        for (Menu oneMenu : Menu.values()) {
            if (oneMenu.getType() == type) {
                menus.add(oneMenu);
            }
        }
        return menus;
    }


    public void addMenu(Menu menu, Integer menuCount){
        sheet.put(menu, menuCount);
    }

    public Money sumOrderPrice(){
        Integer totalPrice = 0;
        Integer menuCount = 0;
        for (Menu oneMenu : Menu.values()) {
            menuCount = countNumberOf(oneMenu);
            totalPrice += menuCount * oneMenu.getPrice();
        }
        return new Money(totalPrice);
    }
}
