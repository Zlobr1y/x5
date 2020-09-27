package Task2;

import Task2.Fruit.Fruit;
import Task1.ArrayScroll;

public class Box<T extends Fruit> {

    private ArrayScroll<T> elements;
    private float totalWeight;

    public Box() {
        elements = new ArrayScroll<>();
    }

    public Box<T> add(T fruit) {
        elements.add(fruit);
        this.totalWeight += fruit.getWeight();
        return this;
    }

    public void remove(T fruit) {
        elements.remove(fruit);
        this.totalWeight -= fruit.getWeight();
    }

    float getWeight() {
        return this.totalWeight;
    }

    public boolean compare(Box box) {
        return this.getWeight() == box.getWeight();
    }

    public void mergeToBox(Box<T> box) {
        while (this.elements.size() != 0) {
            box.add(this.elements.get(0));
            remove(this.elements.get(0));
        }
    }
}

