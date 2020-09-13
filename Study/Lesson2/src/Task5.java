import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Task5 {
    /*5. Ввести три целых числа с консоли. Вывести на
    экран наименьшее из них.*/
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] numbers = new int[3];

        for (int i = 0; i < numbers.length; i++) {
            String s = reader.readLine();
            numbers[i] = Integer.parseInt(s);
        }
        printMin(numbers);

    }

    public static void printMin(int[] arr) {
        for (int min = 0; min < arr.length; min++) {
            int least = min;
            for (int j = min + 1; j < arr.length; j++) {
                if (arr[j] < arr[least]) {
                    least = j;
                }
            }
            int tmp = arr[min];
            arr[min] = arr[least];
            arr[least] = tmp;
        }
        System.out.println(arr[0]);

    }


}
