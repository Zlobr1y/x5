package L2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class Main {
    static HashSet hashSetRepository = new HashSet();
    static ArrayList arrayListRepository = new ArrayList();

    public static void main(String[] args) {
        System.out.println("checking at tests...");
        //пример работы:
        ArrayList<Integer> list = new ArrayList<Integer>();
        Integer[] testArray = new Integer[]{10,100,101,123};
        list.addAll(Arrays.asList(testArray));

        UniqueUtils.getUniqElements(hashSetRept эnj lf
                ository,list);
        System.out.println();

    }


    //пример наполнения.
    private static void initSetRepository(HashSet hashSetRepository){
        if(hashSetRepository==null) {
            hashSetRepository = new HashSet();
        }
        Integer[] testArray = new Integer[]{1,2,3,4,5,6,12,23,26};
        hashSetRepository.addAll(Arrays.asList(testArray));

    }
    private static void initListRepository(ArrayList arrayListRepository){
        if(arrayListRepository==null) {
            arrayListRepository = new ArrayList();
        }
        Integer[] testArray = new Integer[]{1,5,3,4,5,6,12,23,26};
        arrayListRepository.addAll(Arrays.asList(testArray));
    }

}
