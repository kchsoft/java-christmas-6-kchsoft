package order;

import food.Food;
import money.UnmodifiedMoney;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

class OrdersTest {

    Orders orders;
    Integer amount1 = 2;
    Integer amount2 = 1;
    Integer amount3 = 3;
    Integer amount4 = 5;

    @BeforeEach
    void createOrders() {
        orders = new Orders();
        orders.add(new Order(Food.BBQ_RIB,amount1));
        orders.add(new Order(Food.RED_WINE,amount2));
        orders.add(new Order(Food.CAESAR_SALAD,amount3));
        orders.add(new Order(Food.ICE_CREAM,amount4));
    }

    @Test
    @DisplayName("중복된 음식 주문시 에러 발생")
    void duplicationOrderError() {
        assertThrows(IllegalArgumentException.class,
                () -> orders.add(new Order(Food.ICE_CREAM, amount1)));
    }

    @Test
    @DisplayName("새로운 음식 주문시 성공")
    void addSuccess() {
        assertDoesNotThrow(
                () -> orders.add(new Order(Food.T_BONE_STEAK, amount1)));
    }

    @Test
    @DisplayName("음식 조회 성공")
    void getFoodsSuccess() {
        List<Food> foods = orders.getFoods();
        assertThat(foods.get(0)).isEqualTo(Food.BBQ_RIB);
        assertThat(foods.get(1)).isEqualTo(Food.RED_WINE);
        assertThat(foods.get(2)).isEqualTo(Food.CAESAR_SALAD);
        assertThat(foods.get(3)).isEqualTo(Food.ICE_CREAM);
    }

    @Test
    @DisplayName("주문 총비용 조회 성공")
    void getTotalCostSuccess() {
        UnmodifiedMoney total = orders.getTotalCost();
        Integer compare = Food.BBQ_RIB.getIntCost() * amount1
                + Food.RED_WINE.getIntCost() * amount2
                + Food.CAESAR_SALAD.getIntCost() * amount3
                + Food.ICE_CREAM.getIntCost() * amount4;
        assertThat(total).isEqualTo(compare);
    }

    @Test
    @DisplayName("주문 총비용 조회 성공")
    void getTotalAmountSuccess() {
        Integer total = orders.getTotalAmount();
        Integer compare = amount1 + amount2 + amount3 + amount4;
        assertThat(total).isEqualTo(compare);
    }

}