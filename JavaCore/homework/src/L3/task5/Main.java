package L3.task5;

public class Main {

    /*1.    Лодочная станция.
    На лодочной станции 5 лодок(пронумерованных от 1до 5.Ее посещают 7посетителей(потоков).
    Каждый посетитель берет любую свободную лодку на случайное время(от 0.2до 1секунды),
    после чего возвращает ее на место,и,через случайное время (до 1секунды) приходит снова за лодкой, и
    так 5 раз.Если лодка у посетителя, ее не могут выдать второй раз, пока она не вернется.
    Когда лодку берут покататься и возвращают, необходимо печатать соответствующее сообщение*/


    public static void main(String[] args) {
        Object lock = new Object();
        Thread person1 = new Thread(new Boat(lock, 5));
        Thread person2 = new Thread(new Boat(lock, 5));
        Thread person3 = new Thread(new Boat(lock, 5));
        Thread person4 = new Thread(new Boat(lock, 5));
        Thread person5 = new Thread(new Boat(lock, 5));
        Thread person6 = new Thread(new Boat(lock, 5));
        Thread person7 = new Thread(new Boat(lock, 5));

        person1.start();
        person2.start();
        person3.start();
        person4.start();
        person5.start();
        person6.start();
        person7.start();

    }
}
