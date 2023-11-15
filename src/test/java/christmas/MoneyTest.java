package christmas;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class MoneyTest {

    @DisplayName("Integer를 매개 변수로 하는 더하기 정상 작동 확인")
    @CsvSource({"0,1000,1000","231,343,574","10500,4020,14520"})
    @ParameterizedTest
    void checkIntegerAdd(Integer initAmount,Integer amount, Integer result){
        Money money = new Money(initAmount);
        money.add(amount);
        assertThat(money.getAmount()).isEqualTo(result);
    }

    @DisplayName("Money를 매개 변수로 하는 더하기 정상 작동 확인")
    @CsvSource({"0,500,500","100,300,400","10000,4000,14000"})
    @ParameterizedTest
    void checkMoneyAdd(Integer initAmount,Integer amount, Integer result){
        Money money = new Money(initAmount);
        money.add(new Money(amount));
        assertThat(money.getAmount()).isEqualTo(result);
    }

    @DisplayName("Integer를 매개 변수로 하는 빼기 정상 작동 확인")
    @CsvSource({"1000,1000,0","500,123,377","14520,4020,10500"})
    @ParameterizedTest
    void checkIntegerSubtract(Integer initAmount,Integer amount, Integer result){
        Money money = new Money(initAmount);
        money.subtract(amount);
        assertThat(money.getAmount()).isEqualTo(result);
    }

    @DisplayName("Money를 매개 변수로 하는 빼기 정상 작동 확인")
    @CsvSource({"1000,1000,0","500,123,377","14520,4020,10500"})
    @ParameterizedTest
    void checkMoneySubtract(Integer initAmount,Integer amount, Integer result){
        Money money = new Money(initAmount);
        money.subtract(new Money(amount));
        assertThat(money.getAmount()).isEqualTo(result);
    }


    @DisplayName("Money가 String으로 변환되는지 확인")
    @CsvSource({"500,'500'","1700,'1,700'","12000,'12,000'"})
    @ParameterizedTest
    void checkMoenyToString(Integer amount, String result){
        Money money = new Money(amount);
        assertThat(money.toString()).isEqualTo(result);
    }

}