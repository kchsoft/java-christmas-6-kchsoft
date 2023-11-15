package christmas;

import static christmas.Constant.MsgConstantPiece.DASH;

import christmas.Converter.Converter;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
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

    public void addMenus(List<String> orderMenus) throws IllegalArgumentException{
        for (String orderMenu : orderMenus) {
            List<String> nameAndNumber = Arrays.asList(orderMenu.split(DASH));
            Menu menu = Menu.findMenu(nameAndNumber.get(0));
            Integer number = Integer.valueOf(nameAndNumber.get(1));
            addMenu(menu, number);
        }
    }

    public Money sumPrice(){
        Integer totalPrice = 0;
        Integer menuCount = 0;
        for (Menu oneMenu : Menu.values()) {
            menuCount = countNumberOf(oneMenu);
            totalPrice += menuCount * oneMenu.getPriceValue();
        }
        return new Money(totalPrice);
    }

    public List<Menu> getMenus(){
        List<Menu> menus = new ArrayList<>();
        for (Menu oneMenu : Menu.values()) {
            if (sheet.containsKey(oneMenu)) {
                menus.add(oneMenu);
            }
        }
        return menus;
    }

}
