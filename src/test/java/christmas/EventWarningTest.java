package christmas;

import customer.Reservation;
import customer.VisitingDay;
import exception.EventApplyException;
import exception.FoodOrderException;
import food.Food;
import order.Order;
import order.Orders;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import restaurant.EventWarning;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

class EventWarningTest {

    Reservation reservation;
    VisitingDay day;
    Orders orders;

    @BeforeEach
    void createReservation() {
        orders = new Orders();
        day = new VisitingDay(10);
    }

    @Test
    @DisplayName("10,000원 이상 주문시 이벤트 적용 가능")
    void eventApplySuccess() {
        orders.add(new Order(Food.ICE_CREAM, 5));
        orders.add(new Order(Food.ZERO_COLA, 5));
        reservation = new Reservation(day, orders);
        assertDoesNotThrow(
                () -> EventWarning.check(reservation));
    }

    @Test
    @DisplayName("10,000원 미만 주문시 이벤트 적용 불가")
    void eventApplyFail() {
        orders.add(new Order(Food.ICE_CREAM, 1));
        orders.add(new Order(Food.ZERO_COLA, 1));
        reservation = new Reservation(day, orders);
        assertThrows(EventApplyException.class,
                () -> EventWarning.check(reservation));
    }

    @Test
    @DisplayName("음료와 음식 주문시 주문 성공")
    void orderSuccess() {
        orders.add(new Order(Food.ICE_CREAM, 5));
        orders.add(new Order(Food.ZERO_COLA, 5));
        reservation = new Reservation(day, orders);
        assertDoesNotThrow(
                () -> EventWarning.check(reservation));
    }

    @Test
    @DisplayName("음료만 주문시 주문 실패")
    void orderFail() {
        orders.add(new Order(Food.ZERO_COLA, 5));
        orders.add(new Order(Food.RED_WINE, 5));
        reservation = new Reservation(day, orders);
        assertThrows(FoodOrderException.class,
                () -> EventWarning.check(reservation));
    }

    @Test
    @DisplayName("주문 수량 20개 이하시 주문 성공")
    void orderAmountSuccess() {
        orders.add(new Order(Food.ICE_CREAM, 5));
        orders.add(new Order(Food.ZERO_COLA, 5));
        orders.add(new Order(Food.T_BONE_STEAK, 5));
        orders.add(new Order(Food.TAPAS, 5));
        reservation = new Reservation(day, orders);
        assertDoesNotThrow(
                () -> EventWarning.check(reservation));


    }

    @Test
    @DisplayName("주문 수량 20개 초과시 주문 실패")
    void orderAmountFail() {
        orders.add(new Order(Food.ICE_CREAM, 10));
        orders.add(new Order(Food.ZERO_COLA, 10));
        orders.add(new Order(Food.TAPAS, 1));
        reservation = new Reservation(day, orders);
        assertThrows(FoodOrderException.class,
                () -> EventWarning.check(reservation));
    }

}