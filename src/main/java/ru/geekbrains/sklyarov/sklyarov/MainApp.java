package ru.geekbrains.sklyarov.sklyarov;

import org.jetbrains.annotations.NotNull;

import java.util.*;

public class MainApp {
    public static void main(String[] args) {

    }

    public static Integer[] getArray1(@NotNull Integer[] arr) {
        if (arr.length == 0) {
            throw new IllegalArgumentException("The array must not be empty");
        }
        List<Integer> l = new ArrayList<>(Arrays.asList(arr));
        int lastIndex = l.lastIndexOf(4);

        if (lastIndex == -1) {
            throw new RuntimeException("No number 4");
        }

        l.subList(0, lastIndex + 1).clear();

        Integer[] result = new Integer[l.size()];
        l.toArray(result);

        return result;
    }
    public static boolean checkArray(Integer[] arr){
        Set<Integer> integerSet = new HashSet<>(Arrays.asList(arr));
        Integer[] mask = {1,4};
        if (integerSet.size() == 2){
            return integerSet.containsAll(Arrays.asList(mask));
        }
        return false;
    }
}
