package listUtilities;

import java.util.Collections;
import java.util.List;

public class ListUtils {

    public static <T extends  Comparable<T>> T getMax(List<T> elements){
        enssuredException(elements);
        return Collections.max(elements);
    }


    public static <T extends Comparable<T>> T getMin(List<T> elements){
        enssuredException(elements);
        return Collections.min(elements);
    }

    private static <T extends  Comparable<T>> void enssuredException(List<T> elements) {
        if(elements.isEmpty()){
            throw  new IllegalArgumentException();
        }
    }
}
