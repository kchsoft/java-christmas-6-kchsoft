package christmas;

import customer.Reservation;
import food.Food;
import food.FoodType;

import java.util.List;

public class EventWarning {

    private static final Integer MIN_EVENT_APPLICATION_COST = 10000;
    private static final Integer MAX_ORDER_AMOUNT = 20;

    public static void check(Reservation reservation) throws IllegalArgumentException{
        isCostMoreThan10000(reservation.getTotalCost());
        isNotOnlyBeverageOrder(reservation);
        isAllOrderAmountLessThan20(reservation);
    }

    private static void isCostMoreThan10000(Integer totalCost) throws IllegalArgumentException {
        if(totalCost >= MIN_EVENT_APPLICATION_COST)
            return;
        throw new IllegalArgumentException();
        // need to change EventApplyException
    }

    private static void isNotOnlyBeverageOrder(Reservation reservation) throws IllegalArgumentException{
       List<Food> foods = reservation.getFoods();
        for (Food food : foods) {
            if (food.getFoodType() != FoodType.BEVERAGE) {
                return;
            }
        }
        throw new IllegalArgumentException("[ERROR] 음료만 주문 시, 주문할 수 없습니다.");
        // FoodOrderException
    }

    private static void isAllOrderAmountLessThan20(Reservation reservation) throws IllegalArgumentException {
        if (reservation.getTotalAmount() < MAX_ORDER_AMOUNT) {
            return;
        }
        throw new IllegalArgumentException("[ERROR] 메뉴는 한 번에 최대 20개까지만 주문할 수 있습니다.");
        // FoodOrderException
    }

}
