package order;

import java.util.LinkedList;
import java.util.List;

public class OrderInfos {
    List<String> infos;

    public OrderInfos() {
        this.infos = new LinkedList<>();
    }

    public String get(int i) {
        return infos.get(i);
    }

    public void add(String info) {
        infos.add(info);
    }

    public Integer size() {
        return infos.size();
    }
}
