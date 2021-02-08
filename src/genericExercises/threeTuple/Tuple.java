package genericExercises.threeTuple;

public class Tuple <K, V, E>{
    private K firstElement;
    private V secondElement;
    private E thirdElement;

    public Tuple(K firstElement, V secondElement, E thirdElement){
        this.firstElement = firstElement;
        this.secondElement = secondElement;
        this.thirdElement = thirdElement;
    }

    @Override
    public String toString() {
        return String.format("%s -> %s -> %s",this.firstElement,this.secondElement,this.thirdElement);
    }
}
