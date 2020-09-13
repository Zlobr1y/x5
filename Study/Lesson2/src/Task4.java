import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Task4 {
    /*4. Ввести целое число в консоли. Если оно является
    положительным, то прибавить к нему 1; если
    отрицательным, то вычесть из него 2; если нулевым,
    то заменить его на 10. Вывести полученное число.*/
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String sNum = reader.readLine();
        int nNum = Integer.parseInt(sNum);

        if (nNum > 0) {
            nNum += 1;
        } else if (nNum == 0) {
            nNum = 10;
        } else {
            nNum -= 2;
        }
        System.out.println(nNum);
    }

}
