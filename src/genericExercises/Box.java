package genericExercises;

public class Box<T> {
    private T value;

    public Box (T name){
        this.value = name;
    }

    @Override
    public String toString() {
        return String.format("%s: %s",this.value.getClass().getName(),this.value);
    }
}
