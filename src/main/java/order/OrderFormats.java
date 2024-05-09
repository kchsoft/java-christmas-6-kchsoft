package order;

import java.util.LinkedList;
import java.util.List;

public class OrderFormats {
    private final List<OrderFormat> formats;

    public OrderFormats() {
        formats = new LinkedList<>();
    }

    public void add(OrderFormat format) {
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

    public OrderFormat get(int i) {
        return formats.get(i);
    }

}