package genericArrayCreator;

public class Main {
    public static void main(String[] args) {



        Integer [] array = ArrayCreator.create(13,13);
        String [] strings = ArrayCreator.create(13,"Java");

        String[] ar = ArrayCreator.create(String.class,13,"gigi");

    }
}
