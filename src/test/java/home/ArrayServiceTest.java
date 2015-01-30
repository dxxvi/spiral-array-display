package home;

import static org.junit.Assert.*;

import com.google.common.base.Joiner;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ly on 1/30/15.
 */
public class ArrayServiceTest {
    @Test
    public void testToSpiralString() {
/*
        int[][] array = new int[][] {
                {1,  2,  3,  4,  5},
                {6,  7,  8,  9,  10},
                {11, 12, 13, 14, 15},
                {16, 17, 18, 19, 20}
        };
*/
//        int[][] array = new int[][] { {1} };
        int[][] array = new int[][] {
                {1},
                {2}
        };
        List<Integer> integers = new ArrayService().toSpiralString(array);
        assertTrue("1 2 3 4 5 10 15 20 19 18 17 16 11 6 7 8 9 14 13 12".equals(Joiner.on(" ").join(integers)));
    }
}
