import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Task1 {
    public static void main(String[] args) throws IOException {
        //1. Ввести целое число в консоли и вывести на экран последнюю цифру введенного числа.
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String sNum = reader.readLine();
        int nNum = Integer.parseInt(sNum);

        System.out.println(nNum % 10);

    }
}
