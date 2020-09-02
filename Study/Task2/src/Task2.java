import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Task2 {

    public static void main(String[] args) throws IOException {
        //2. Ввести целое трехзначное число в консоли и найти сумму цифр этого трехзначного числа
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String sNum = reader.readLine();
        int nNum = Integer.parseInt(sNum);

        int num1 = nNum % 10;
        int num2 = ((nNum - num1)/10)% 10;
        int num3 = (nNum - (num2*10+num1))/100;

        System.out.println(num1+num2+num3);
        System.out.println(num1);
        System.out.println(num2);
        System.out.println(num3);

    }


}
