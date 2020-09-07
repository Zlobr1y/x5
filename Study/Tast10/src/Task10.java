import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class Task10 {
    /*Дан массив целых чисел:
            [15,10,0,-6,-5,3,0,-34,0,32,56,0,24,-52]. Переместить
    нули в конец массива. Вывести результат в консоль*/
    public static void main(String[] args) {
        int[] data = {15,10,0,-6,-5,3,0,-34,0,32,56,0,24,-52};

        ArrayList<Integer> list =  new ArrayList<Integer>();
        for (int i = 0; i < data.length; i++) list.add(data[i]);
        moveZero(list);


    }

    public static void moveZero(ArrayList<Integer> list) {

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == 0) {
                list.remove(i);
                list.add(list.size(), 0);
            }
        }
        for (int i = 0; i < list.size(); i++){
            System.out.println(list.get(i));
        }
    }

}
