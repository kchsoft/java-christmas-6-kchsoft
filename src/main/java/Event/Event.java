package Event;

 public interface Event<T> {
     EventHistory apply(T eventObject);
}