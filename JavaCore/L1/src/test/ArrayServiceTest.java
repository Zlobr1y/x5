package test;

import junit.framework.TestCase;
import main.ArrayService;
import org.junit.Assert;
import org.junit.Test;

public class ArrayServiceTest extends TestCase {

    @Test
    public void testSortArray() {
        String[] array = {"111","11111","111","1","11111111"};
        ArrayService.sortArray(array);
        String[] expectedArray = {"1","111","111","11111","11111111"};
        Assert.assertArrayEquals(array,expectedArray);
    }
    @Test
    public void testRevArray() {
        String[] array = {"333333","11","2222","44444444","5555555555"};
        ArrayService.reverseArray(array);
        String[] expectedArray = {"5555555555","44444444","2222","11","333333"};
        Assert.assertArrayEquals(array,expectedArray);
    }
}
