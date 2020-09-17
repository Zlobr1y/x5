package Task2;

public class Main {
    public static void main(String[] args) {
        Lorry lorry = new Lorry();
        lorry.setCarModel("Volkswagen transporter");
        lorry.setCarClass("Грузовик");
        lorry.setWeight(3200);
        lorry.setLiftingCapacity(1900);
        lorry.engine.setManufacturer("Germany");
        lorry.engine.setPower(204);
        lorry.start();
        lorry.turnLeft();
        lorry.turnRight();
        lorry.stop();
        lorry.printInfo();

        SportCar sportCar = new SportCar();
        sportCar.setCarModel("Marussia B2");
        sportCar.setCarClass("Sport Car");
        sportCar.setWeight(1100);
        sportCar.setMaxSpeed(250);
        sportCar.engine.setManufacturer("Russia");
        sportCar.engine.setPower(420);
        sportCar.start();
        sportCar.turnLeft();
        sportCar.turnRight();
        sportCar.stop();
        sportCar.printInfo();

    }
}
