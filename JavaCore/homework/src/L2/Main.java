package L2;

import javax.lang.model.type.MirroredTypeException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class Main {

    public static void main(String[] args) {
        //пример работы:
        ArrayList<Integer> list = new ArrayList<Integer>();
        Integer[] testArray = new Integer[]{22,33,44,55};
        list.addAll(Arrays.asList(testArray));

        ArrayList<Integer> arrList = initListRepository(new ArrayList());
        ArrayList<Integer> compareList = UniqueUtils.getUniqElements(arrList, list);
        System.out.println(compareList);

        HashSet<Integer> hashSet = initSetRepository(new HashSet());
        HashSet<Integer> compareSet = UniqueUtils.getUniqElements(hashSet, list);
        System.out.println(compareSet);
    }

    //пример наполнения.
    private static ArrayList<Integer> initListRepository(ArrayList arrayListRepository) {
        if (arrayListRepository == null) {
            arrayListRepository = new ArrayList();
        }
        Integer[] testArray = new Integer[]{1, 5, 3, 4, 5, 6, 25, 2, 8};
        arrayListRepository.addAll(Arrays.asList(testArray));
        return arrayListRepository;
    }

    private static HashSet<Integer> initSetRepository(HashSet hashSetRepository) {
        if (hashSetRepository == null) {
            hashSetRepository = new HashSet();
        }
        Integer[] testArray = new Integer[]{61, 71, 81, 91, 51, 162, 311, 101, 181};
        hashSetRepository.addAll(Arrays.asList(testArray));

        return hashSetRepository;
    }
}