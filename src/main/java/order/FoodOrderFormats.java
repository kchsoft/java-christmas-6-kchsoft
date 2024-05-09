package order;

import java.util.LinkedList;
import java.util.List;

public class FoodOrderFormats {
    private final List<FoodOrderFormat> formats;

    public FoodOrderFormats() {
        formats = new LinkedList<>();
    }

    public void add(FoodOrderFormat format) {
        formats.add(format);
    }

    public Integer size() {
        return formats.size();
    }

    public String getName(int i) {
        return formats.get(i).getName();
    }

    public String getAmount(int i) {
        return formats.get(i).getAmount();
    }

    public FoodOrderFormat get(int i) {
        return formats.get(i);
    }

}