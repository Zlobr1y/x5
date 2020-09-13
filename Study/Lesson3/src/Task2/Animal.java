package Task2;

public class Animal {
    protected String food;
    protected String location;

    void makeNoise(){
        System.out.println("Какое-то животное шумит.");
    }
    void eat(){
        System.out.println("Какое-то животное, что-то непонятное есть.");
    }
    void sleep(){
        System.out.println("Какое-то животное спит.");
    }

    public String getFood() {
        return food;
    }

    public void setFood(String food) {
        this.food = food;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
