package Task2;

public class Cat extends Animal {

    @Override
    void makeNoise() {
        System.out.println("Мяу!");
    }

    @Override
    void eat() {
        System.out.println("Кошка ест рыбу.");
    }

    @Override
    void sleep() {
        System.out.println("Кошка спит.");
    }
}
