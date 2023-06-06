package main;

import java.util.List;


	
 public class BusInfo {
    public static <T> void generics(T object) {
        // Prints the type and value of the object
        System.out.println("Object Type: " + object.getClass().getSimpleName());
        System.out.println("Object Value: " + object.toString());
    }

    public static <T> T getFirstElement(List<T> list) {
        // Checks if the list is null or empty, and returns the first element
        if (list == null || list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    public static <T, U> void processPair(T first, U second) {
        // Prints the first and second elements
        System.out.println("First Element: " + first.toString());
        System.out.println("Second Element: " + second.toString());
    }
}

	
