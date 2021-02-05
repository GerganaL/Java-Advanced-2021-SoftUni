package Jar;

public class Main {
    public static void main(String[] args) {
        Jar<Integer> stack = new Jar<Integer>();
        stack.add(45);
        stack.add(12);
        stack.remove();
        System.out.println();
    }
}
