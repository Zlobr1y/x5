package Task2;

public class Dog extends Animal {
    @Override
    void makeNoise() {
        System.out.println("Гав!");
    }

    @Override
    void eat() {
        System.out.println("Пёс грызет кость.");
    }

    @Override
    void sleep() {
        System.out.println("Пёс спит.");
    }
}
