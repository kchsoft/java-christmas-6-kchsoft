package customer;

import java.util.Objects;

public class VisitingDay {
    Integer day;

    public VisitingDay(Integer day) throws IllegalArgumentException{
        validate(day);
        this.day = day;
    }

    private void validate(Integer day) throws IllegalArgumentException{
        checkDayArrange(day);
    }

    private void checkDayArrange(Integer day) throws IllegalArgumentException{
        if(day < 1 || day > 31)
            throw new IllegalArgumentException();
    }

    public Integer getDayValue() {
        return this.day;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VisitingDay that = (VisitingDay) o;
        return getDayValue() == ((VisitingDay) o).getDayValue();
    }

    @Override
    public int hashCode() {
        return Objects.hash(day);
    }
}