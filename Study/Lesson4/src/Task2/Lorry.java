package Task2;

public class Lorry extends Car {

    private double liftingCapacity;
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
        System.out.println("Грузоподъемность: "+ liftingCapacity + " кг");
        System.out.println("Мощность двигателя: " + engine.getPower() + " л/с" );
        System.out.println("Производитель: " + engine.getManufacturer());
    }

    public double getLiftingCapacity() {
        return liftingCapacity;
    }

    public void setLiftingCapacity(double liftingCapacity) {
        this.liftingCapacity = liftingCapacity;
    }
}
