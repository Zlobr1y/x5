package L3.task5;


import java.util.concurrent.Semaphore;

public class Main_App {

        /*1.    Лодочная станция.
    На лодочной станции 5 лодок(пронумерованных от 1до 5.Ее посещают 7посетителей(потоков).
    Каждый посетитель берет любую свободную лодку на случайное время(от 0.2до 1секунды),
    после чего возвращает ее на место,и,через случайное время (до 1секунды) приходит снова за лодкой, и
    так 5 раз.Если лодка у посетителя, ее не могут выдать второй раз, пока она не вернется.
    Когда лодку берут покататься и возвращают, необходимо печатать соответствующее сообщение*/

    //Лодка занята - true, свободна - false
    private static final boolean[] COUNT_BOATS = new boolean[5];

    public static void main(String[] args) throws InterruptedException {

        Semaphore semaphore = new Semaphore(5);
        for (int j = 0; j < 5; j++) {
            for (int i = 1; i <= 7; i++) {
                new Thread(new Person(semaphore, i)).start();
                Thread.sleep((int) (Math.random() * 1000));
            }
        }
    }

    public static class Person implements Runnable {
        private Semaphore semaphore;
        private int num;

        public Person(Semaphore semaphore, int num) {
            this.semaphore = semaphore;
            this.num = num;
        }

        @Override
        public void run() {
            System.out.printf("Человек №%d взял лодку №", num);
            try {
                int parkingNumber = -1;
                //Ищем свободную лодку
                semaphore.acquire();
                synchronized (COUNT_BOATS) {
                    for (int i = 0; i < 5; i++)
                        if (!COUNT_BOATS[i]) {      //Если лодка свободна
                            COUNT_BOATS[i] = true;  //занимаем ее
                            parkingNumber = i;         //Наличие свободной лодки, гарантирует семафор
                            System.out.printf("Человек №%d вернул лодку %d.\n", num, i);
                            break;
                        }
                }

                Thread.sleep((int) (200 + Math.random() * 800));       //Катаемся на лодке

                synchronized (COUNT_BOATS) {
                    COUNT_BOATS[parkingNumber] = false;//Освобождаем лодку
                }
                System.out.printf("Человек №%d покинул лодочную станцию.\n", num);
                semaphore.release();
            } catch (InterruptedException e) {
            }
        }
    }
}


