package genericExercises.customList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CustomList<T extends Comparable<T>> {
    private List<T> data;

    public CustomList() {
        this.data = new ArrayList<>();
    }

    public void add(T value) {
        this.data.add(value);
    }

    public void swap(int index1, int index2) {
        T first = this.data.get(index1);
        this.data.set(index1, this.data.get(index2));
        this.data.set(index2, first);


    }

    public T remove(int index) {
        return this.data.remove(index);
    }

    public boolean contains(T element) {
        return this.data.contains(element);
    }

    public void sort(){
        Collections.sort(this.data);
    }
    public T get(int index){
        return this.data.get(index);
    }

    public int size(){
        return this.data.size();
    }

    public T getMax() {
        T maxElement = null;
        /*if (!this.data.isEmpty()) {*/
            maxElement = this.data.get(0);
            for (T datum : data) {
                if (datum.compareTo(maxElement) > 0) {
                    maxElement = datum;
                }
           // }
        }

        return maxElement;
    }

    public T getMin() {
        T minElement = null;
       /* if (!this.data.isEmpty()) {*/
            minElement = this.data.get(0);
            for (T datum : data) {
                if (datum.compareTo(minElement) < 0) {
                    minElement = datum;
                }
           // }
        }

        return minElement;
    }

    public long countGreaterThan(T compare) {
        return this.data.stream().filter(e -> e.compareTo(compare) > 0).count();
    }


    public String print() {
        StringBuilder sb = new StringBuilder();
        for (T value : data) {
            sb.append(value.toString())
                    .append(System.lineSeparator());
        }
        return sb.toString().trim();
    }
}
