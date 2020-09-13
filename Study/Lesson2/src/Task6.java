import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Task6 {
    static StringBuilder sb = new StringBuilder();

    /*6. Ввести целое число в консоли. Вывести его строкуописание вида «отрицательное четное число»,
«нулевое число», «положительное нечетное число» и т. д*/
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String s = reader.readLine();
        int num = Integer.parseInt(s);

        checkValue(num);

        System.out.println(sb);


    }

    public static void checkValue(int num) {
        if (num > 0) {
            sb.append("положительное ");
            checkNum(num);
        } else if (num < 0) {
            sb.append("отрицательное ");
            checkNum(num);
        } else {
            sb.append("нулевое число");
        }


    }

    public static void checkNum(int num) {
        if (num % 2 > 0) {
            sb.append("нечетное число");
        } else {
            sb.append("четное число");
        }

    }


}


