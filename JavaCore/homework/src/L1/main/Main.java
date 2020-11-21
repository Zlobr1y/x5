package L1.main;

public class Main {

    public static void main(String[] args) {
        String[] testArray = {"111","11111","111","1","11111111"};
        ArrayService.sortArray(testArray);
        for(String s : testArray){
            System.out.println(s);
        }


        TriangleMatrix triangleMatrix = new TriangleMatrix();
        int[][] matrix = triangleMatrix.rows(3);


        String[] testArray3 = {"333333","11","2222","44444444","5555555555"};
        ArrayService.reverseArray(testArray3);
        for(String s : testArray3){
            System.out.println(s);
        }
    }


}
