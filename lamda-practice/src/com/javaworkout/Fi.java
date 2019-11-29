package com.javaworkout;


@FunctionalInterface
interface Square {

    abstract int calculate(String w, int l);

    default int area(int l) {
        return l * l;
    }
    default int perimeter(int l) {
        return 4 * l;
    }
}


public class Fi implements Square{

    public int calculate(String w, int l) {
        if (w.equals("area")) {
            return area(l);
        } else if (w.equals("perimeter")) {
            return perimeter(l);
        }
        return 0;
    }

    public static void main(String args[]) {

        Fi fi = new Fi();
        int area = fi.calculate("area", 10);
        int perimeter = fi.calculate("perimeter", 10);

        System.out.println("Area: " + area + ". Perimeter: " + perimeter);

        new Thread(() -> System.out.println("New thread created.")).start();

    }
}
