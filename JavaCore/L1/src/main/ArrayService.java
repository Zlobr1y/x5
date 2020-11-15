package main;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class ArrayService {

    public static String[] sortArray(String[] array){
        Comparator<String> comprator = (s1, s2) -> s1.length() - s2.length();
        Arrays.sort(array,comprator);
        return array;
    }

    public void matrix(){

    }

    public static String[] reverseArray(String[] array){
        Collections.reverse(Arrays.asList(array));
        return array;
    }
}

