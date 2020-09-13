package Task2;

public class Horse extends Animal {
    @Override
    void makeNoise() {
        System.out.println("ИГО-ГО!!");
    }

    @Override
    void eat() {
        System.out.println("Конь жуёт траву");
    }

    @Override
    void sleep() {
        System.out.println("Выходит ночью в поле с хозяином :)");
    }
}
