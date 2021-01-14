package main.java.ru.titov.course.task1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {


        List<Integer> list = new ArrayList<>(Arrays.asList(1, 1, 2, 3, 4, 510, 32, 25, 74));

        System.out.println(list.stream().filter(integer -> integer==1).count());
//        System.out.println(list.stream().filter(integer -> integer==100).findAny().orElseThrow(IllegalArgumentException::new));
        list.stream().skip(1).limit(2).forEach(x -> System.out.println(x));
        list.stream().skip(2).limit(1).forEach(x -> System.out.println(x));


    }
}
