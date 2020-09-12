import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Task7 {
    /*Написать программу, вычисляющую стоимость 10
    минутного междугороднего разговора в зависимости
    от кода города. ( Москва(905) - 4.15руб. Ростов(194) -
            1.98руб. Краснодар(491) - 2.69руб. Киров(800) - 5.00
    руб. ). Пользователь в консоли должен ввести код
    города, а в ответ от программы получить, например,
    при вводе кода 905, - «Москва. Стоимость разговора:
            41.5»*/

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String s = reader.readLine();
        int num = Integer.parseInt(s);
        int min = 10;
        double cost;
        if (num == 905) {
            cost = min * 4.15;
            System.out.println("Москва. Стоимость разговора: " + cost);
        } else if (num == 194) {
            cost = min * 1.98;
            System.out.println("Ростов. Стоимость разговора: " + cost);
        } else if (num == 491) {
            cost = min * 2.69;
            System.out.println("Краснодар. Стоимость разговора: " + cost);
        } else if (num == 800) {
            cost = min * 5.00;
            System.out.println("Киров. Стоимость разговора: " + cost);
        } else {
            System.out.println("Введен неизвестный код города. Расчитать стоимость минуты невозможно!");

        }
    }
}
