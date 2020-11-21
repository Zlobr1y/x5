package L2;

import java.util.ArrayList;
import java.util.HashSet;

public class UniqueUtils {

    public static HashSet<Integer> getUniqElements(HashSet<Integer> hashSetRepository, ArrayList<Integer> inputList) {
        HashSet<Integer> inputSet = new HashSet<Integer>(inputList);
        if (inputSet.size() == inputList.size()) {
            for (Integer item : inputSet) {
                if (hashSetRepository.contains(item)) {
                    return new HashSet<Integer>();
                }
            }
            hashSetRepository.addAll(inputSet);
        } else {
            return new HashSet<Integer>();
        }
        return hashSetRepository;
    }

    public static ArrayList<Integer> getUniqElements(ArrayList<Integer> arrayListRepository, ArrayList<Integer> inputList) {
        ArrayList<Integer> compareList = new ArrayList<Integer>();
        for (Integer item : inputList) {
            if (!compareList.contains(item)) {
                compareList.add(item);
            }
            if (arrayListRepository.contains(item)) {
                return new ArrayList<Integer>();
            }
        }
        arrayListRepository.addAll(compareList);
        return arrayListRepository;
    }
}
