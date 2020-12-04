package L3.task6;

import javax.naming.ConfigurationException;
import java.io.Closeable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        /*  Станция бургеров Для изготовления бургера нужна 1 котлета и 2 булочки.
            Есть два потока - поставщика котлет (через случайные промежутки времени увеличивают число котлет на станции, каждый раз на 1 и
            3 потока поставщика булочек (аналогично котлетам), но с доп условием, булочек на станции должно быть не более чем в два раза больше чем котлет.
            Еще есть 2 потока поваров, они подходят через случайное время к станции и забирают каждый раз ингридиентов на 1 бургер (при условии, что ингридиентов хватает).
            Отдельно есть еще поток отчетов, который каждую секунду пишет в консоль текущее количество ингридиентов на станции и на сколько бургеров их хватит,
            он не должен блокировать работу других потоков. Кроме синхронизации потребуется использовать ключевое слово volatile   */


        try {
            List<Object> closeableThreads = new ArrayList<>();
            Kitchen kitchen = new Kitchen();
            Cooker cooker1 = new Cooker(kitchen, "Cooker-1", 7000);
            Cooker cooker2 = new Cooker(kitchen, "Cooker-2", 7000);
            closeableThreads.add(cooker1);
            closeableThreads.add(cooker2);

            Deliver deliverCutlet1 = new Deliver(kitchen, "meat", 7000, "DeliverCutlet-1");
            Deliver deliverCutlet2 = new Deliver(kitchen, "meat", 7000, "DeliverCutlet-2");
            Deliver deliverBread1 = new Deliver(kitchen, "bread", 7000, "DeliverBread-1");
            Deliver deliverBread2 = new Deliver(kitchen, "bread", 7000, "DeliverBread-2");
            Deliver deliverBread3 = new Deliver(kitchen, "bread", 7000, "DeliverBread-3");
            closeableThreads.add(deliverCutlet1);
            closeableThreads.add(deliverCutlet2);
            closeableThreads.add(deliverBread1);
            closeableThreads.add(deliverBread2);
            closeableThreads.add(deliverBread3);

            Status status = new Status(kitchen);
            closeableThreads.add(status);

            for (Object object : closeableThreads) {
                Thread thread = (Thread) object;
                thread.start();
            }

            Thread.sleep(30000);

            for (Object object : closeableThreads) {
                Closeable closeable = (Closeable) object;
                closeable.close();
            }
        } catch (ConfigurationException | InterruptedException | IOException e) {
            e.printStackTrace();
        }
    }
}
