package home;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by ly on 1/30/15.
 */
public class ArrayService {
    /**
     * @param array array of integers
     * @return a list of integers in the spiral array traversing order
     */
    public List<Integer> toSpiralString(int[][] array) {
        final List<Integer> result = new LinkedList<>();

        int n = array.length;
        int m = array[0].length;

        // copied the idea from some post on www.careercup.com
        int minRow = 0;
        int maxRow = n - 1;
        int minCol = 0;
        int maxCol = m - 1;

        while (minRow <= maxRow && minCol <= maxCol) {
            for (int i = minCol; i <= maxCol; i++) {
                result.add(array[minRow][i]);
            }

            for (int i = minRow + 1; i < maxRow; i++) {
                result.add(array[i][maxCol]);
            }

            for (int i = maxCol; i >= minCol && minRow < maxRow; i--) {
                result.add(array[maxRow][i]);
            }

            for (int i = maxRow - 1; i > minRow && minCol < maxCol; i--) {
                result.add(array[i][minCol]);
            }

            minRow++;
            maxRow--;
            minCol++;
            maxCol--;
        }
        return result;
    }
}
