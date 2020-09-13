package Task2;

public class Main {
    public static void main(String[] args) {
        Animal[] animals = {new Dog(), new Cat(), new Horse()};

        animals[0].setFood("Кость");
        animals[0].setLocation("Простоквашино");
        animals[1].setFood("Рыба");
        animals[1].setLocation("Крекшино");
        animals[2].setFood("Сено");
        animals[2].setLocation("Поле");


        Veterinarian iBolit = new Veterinarian();
        for (Animal animal : animals){
            iBolit.treatAnimal(animal);
        }
    }
}
