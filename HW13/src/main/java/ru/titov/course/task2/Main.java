package main.java.ru.titov.course.task2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        List<People> list = new ArrayList<>(
                Arrays.asList(new People("Вася", 16, Sex.MAN),
                        new People("Петя", 23, Sex.MAN),
                        new People("Елена", 42, Sex.WOMAN),
                        new People("Иван Иванович", 69, Sex.MAN)));

        list.stream().filter(people -> people.getAge() >= 18 && people.getAge()<27).forEach(System.out::println);
        System.out.println(list.stream().filter(people -> people.getSex().equals(Sex.MAN)).collect(Collectors.averagingInt(people -> people.getAge())));
        list.stream().filter(people -> people.getSex().equals(Sex.MAN) && people.getAge() >= 18 && people.getAge()<60 ||
                people.getSex().equals(Sex.WOMAN) && people.getAge() >= 18 && people.getAge()<55).forEach(System.out::println);


    }
}
