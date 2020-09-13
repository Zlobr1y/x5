package Task2;

public class Veterinarian {
    void treatAnimal(Animal animal){
        System.out.println("Животное из: "+ animal.getLocation()+ " очень голодное, небходимо дать: "+ animal.getFood());
    }
}
