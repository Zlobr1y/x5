package L1.test;

import junit.framework.TestCase;
import L1.main.TriangleMatrix;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class TriangleMatrixTest extends TestCase {
    TriangleMatrix triangleMatrix;

    @Test
    public void testWhenRows1() {
        triangleMatrix=new TriangleMatrix();
        int[][] result = {
                {1}
        };
        assertArrayEquals(result, triangleMatrix.rows(1));
    }

    @Test
    public void testWhenRows2() {
        triangleMatrix=new TriangleMatrix();
        int[][] result = {
                {1}, {2, 3}
        };
        assertArrayEquals(result, triangleMatrix.rows(2));
    }

    @Test
    public void testWhenRows3() {
        triangleMatrix=new TriangleMatrix();
        int[][] result = {
                {1}, {2, 3}, {4, 5, 6}
        };
        assertArrayEquals(result, triangleMatrix.rows(3));
    }
}
