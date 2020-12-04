package L3.task6;

import java.util.concurrent.ConcurrentLinkedQueue;

public class Kitchen {

    private ConcurrentLinkedQueue breads = new ConcurrentLinkedQueue();
    private ConcurrentLinkedQueue meats = new ConcurrentLinkedQueue();

    public Object getBread() {
        return breads.poll();
    }

    public Object getMeat() {
        return meats.poll();
    }

    public void addBread(Object bread) {
        if ((double) breads.size() / (double) meats.size() < 2.0) {
            breads.add(bread);
        } else {
            System.out.println("Kitchen: Too much bread in kitchen");
        }
    }

    public void addMeat(Object meat) {
        meats.add(meat);
    }

    public int getBreadsCount() {
        return breads.size();
    }

    public int getMeatsCount() {
        return meats.size();
    }
}
