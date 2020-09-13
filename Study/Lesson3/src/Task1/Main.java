package Task1;

import static Task1.Phone.receiveCall;
import static Task1.Phone.sendMessage;

public class Main {
    public static void main(String[] args) {
        Phone[] phones = {new Phone(), new Phone(123, "gnusmaS"), new Phone(321, "Sony", 12.21)
        };

        for (Phone phone : phones) {
            System.out.println("Номер: " + phone.number + " Модель: " + phone.model + " Вес: " + phone.weight);
        }

        receiveCall("Billy Butcher");
        receiveCall("Homelander", 123123123);
        sendMessage(new int[]{12321, 45654, 78987});

    }
}
