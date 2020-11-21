package L2.task2;

import java.util.HashMap;
import java.util.Map;

public class Main {
    static HashMap<Integer, Sportsman> sportsmanHashMap;

    public static void main(String[] args) {
        initMap();
        System.out.println("Есть ли спортсмен под номером 5: " + inMap(5));
        System.out.println("Есть ли спортсмен под номером 10: " + inMap(10));
        System.out.println(getCountSameSportsmen(new Sportsman("Сергей", false, true)));

    }

    public static boolean inMap(Integer number) {
        return sportsmanHashMap.containsKey(number);
    }

    public static int getCountSameSportsmen(Sportsman sportsmen) {
        int counter = 0;
        for (Map.Entry<Integer, Sportsman> man : sportsmanHashMap.entrySet()) {
            if (man.getValue().equals(sportsmen)) {
                counter++;
            }
        }
        return counter;
    }


    static void initMap() {
        sportsmanHashMap = new HashMap<Integer, Sportsman>();
        sportsmanHashMap.put(0, new Sportsman("Ваня", false, false));
        sportsmanHashMap.put(1, new Sportsman("Вася", true, false));
        sportsmanHashMap.put(2, new Sportsman("Дима", false, true));
        sportsmanHashMap.put(3, new Sportsman("Денис", true, true));
        sportsmanHashMap.put(4, new Sportsman("Гоша", false, true));
        sportsmanHashMap.put(5, new Sportsman("Лёша", true, false));
        sportsmanHashMap.put(6, new Sportsman("Ратмир", false, true));

    }
}
