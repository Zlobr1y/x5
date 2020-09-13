package Task1;

public class Phone {
    int number;
    String model;
    double weight;

    public Phone() {
    }

    public Phone(int number, String model) {
        this.number = number;
        this.model = model;
    }

    public Phone(int number, String model, double weight) {
        this.number = number;
        this.model = model;
        this.weight = weight;
    }

    public int getNumber() {
        return number;
    }

    static void receiveCall(String callerName) {
        System.out.println("Звонит " + callerName);
    }


    static void receiveCall(String callerName, int callerNumber) {
        System.out.println("Звонит " + callerName + ": " + callerNumber);
    }

    static void sendMessage(int[] numbers) {
        for (int number : numbers) {
            System.out.println(number);
        }
    }
}
