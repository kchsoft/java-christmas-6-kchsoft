package customer;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Objects;

public class VisitingDay {
    LocalDate day;

    public VisitingDay(Integer day) throws IllegalArgumentException{
        validate(day);
        this.day = LocalDate.of(2023,12,day);
    }

    private void validate(Integer day) throws IllegalArgumentException{
        checkDayArrange(day);
    }

    private void checkDayArrange(Integer day) throws IllegalArgumentException{
        if(day < 1 || day > 31)
            throw new IllegalArgumentException();
    }

    public Integer getDateValue() {
        return this.day.getDayOfMonth();
    }


    public DayOfWeek getDayOfWeek() {
        return day.getDayOfWeek();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VisitingDay that = (VisitingDay) o;
        return Objects.equals(day, that.day);
    }

    @Override
    public int hashCode() {
        return Objects.hash(day);
    }
}