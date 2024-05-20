package restaurant;

import customer.Reservation;
import exception.EventApplyException;
import exception.FoodOrderException;
import food.Food;
import food.FoodType;
import money.Cost;
import money.UnmodifiedMoney;

import java.util.List;

public class EventWarning {

    private static final UnmodifiedMoney MIN_EVENT_APPLICATION_COST = new Cost(10000);
    private static final Integer MAX_ORDER_AMOUNT = 20;

    public static void check(Reservation reservation) throws IllegalArgumentException{
        isCostMoreThan10000(reservation.getTotalCost());
        isNotOnlyBeverageOrder(reservation);
        isAllOrderAmountLessThan20(reservation);
    }

    private static void isCostMoreThan10000(UnmodifiedMoney totalCost) throws EventApplyException {

        if(totalCost.getIntValue() >= MIN_EVENT_APPLICATION_COST.getIntValue())
            return;
        throw new EventApplyException();
    }

    private static void isNotOnlyBeverageOrder(Reservation reservation) throws FoodOrderException{
       List<Food> foods = reservation.getFoods();
        for (Food food : foods) {
            if (food.getFoodType() != FoodType.BEVERAGE) {
                return;
            }
        }
        throw new FoodOrderException("[ERROR] 음료만 주문 시, 주문할 수 없습니다.");
    }

    private static void isAllOrderAmountLessThan20(Reservation reservation) throws FoodOrderException {
        if (reservation.getTotalAmount() <= MAX_ORDER_AMOUNT) {
            return;
        }
        throw new FoodOrderException("[ERROR] 메뉴는 한 번에 최대 20개까지만 주문할 수 있습니다.");
    }

}
