package genericExercises.countMethods;

import java.util.ArrayList;
import java.util.List;

public class Box<T extends Comparable<T>> {
    private List<T> values;

    public Box() {
        this.values = new ArrayList<>();
    }

    public void addValue(T value) {
        this.values.add(value);
    }

    public long countElements(T compare) {
        return this.values.stream().filter(e -> e.compareTo(compare) > 0).count();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (T value : values) {
            sb.append(String.format("%s: %s", value.getClass().getName(), value))
                    .append(System.lineSeparator());
        }
        return sb.toString().trim();
    }
}
