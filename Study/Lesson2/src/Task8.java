public class Task8 {
    /*Дан массив целых чисел:
            [1,-10,5,6,45,23,-45,-34,0,32,56,-1,2,-2]. Для данного
    массива найти и вывести на экран:
            - максимальное значение
 - сумму положительных элементов
 - сумму четных отрицательных элементов
 - количество положительных элементов
 - среднее арифметическое отрицательных элементов*/
    public static void main(String[] args) {
        int[] list = {1, -10, 5, 6, 45, 23, -45, -34, 0, 32, 56, -1, 2, -2};

        System.out.println("Максимальное значение: " + max(list));
        System.out.println("Сумма положительных элементов: " + sumPositiveNum(list));
        System.out.println("Сумма четных отрицательных элементов: " + sumNegativeEvenNum(list));
        System.out.println("Количество положительных элементов: " + countPositiveNum(list));
        System.out.println("Среднее арифметическое отрицательных элементов: " + avgNegativeNum(list));


    }

    public static int max(int[] array) {
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max)
                max = array[i];
        }
        return max;
    }

    public static int sumPositiveNum(int[] array) {
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] > 0)
                sum += array[i];
        }
        return sum;
    }

    public static int sumNegativeEvenNum(int[] array) {
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] < 0) {
                if (array[i] % 2 == 0)
                    sum += array[i];
            }
        }
        return sum;

    }

    public static int countPositiveNum(int[] array) {
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] > 0)
                count++;
        }
        return count;
    }

    public static double avgNegativeNum(int[] array) {
        int count = 0;
        double sum = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] < 0) {
                sum += array[i];
                count++;
            }
        }
        return sum / count;
    }


}
