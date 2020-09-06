import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Task3 {
    /*3. Ввести целое число в консоли. Если оно является
    положительным, то прибавить к нему 1, в противном
    случае не изменять его. Вывести полученное число*/
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String sNum = reader.readLine();
        int nNum = Integer.parseInt(sNum);

        if (nNum > 0) {
            nNum += 1;
        }
        System.out.println(nNum);
    }
}
