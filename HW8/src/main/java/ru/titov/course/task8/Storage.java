package main.java.ru.titov.course.task8;

import java.util.HashMap;

public class Storage {
    private HashMap<Thread, Integer> harvesterCount;

    public Storage() {
        harvesterCount = new HashMap<>();
    }

    public void setHarvesterCount(Thread thread, int count) {
        this.harvesterCount.put(thread, count);
    }

    public HashMap<Thread, Integer> getHarvesterCount() {
        return this.harvesterCount;
    }
}
