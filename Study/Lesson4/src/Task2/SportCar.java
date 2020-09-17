package Task2;

public class SportCar extends Car {
    int maxSpeed;

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    @Override
    void start() {
        System.out.println(carClass+ " поехал");
    }

    @Override
    void stop() {
        System.out.println(carClass+ " остановился");
    }

    @Override
    void printInfo() {
        System.out.println("Модель: " + carModel);
        System.out.println("Класс: " + carClass);
        System.out.println("Вес: " + weight + " кг");
        System.out.println("Мощность двигателя: " + engine.getPower() + " л/с" );
        System.out.println("Предельная скорость : "+ maxSpeed + " км/ч");
        System.out.println("Производитель: " + engine.getManufacturer());
    }
}
