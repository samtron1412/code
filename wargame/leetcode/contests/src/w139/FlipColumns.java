package w139;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class FlipColumns {
    public static void addRow(int[] row, Map<String, Integer> map) {
        StringBuilder b0 = new StringBuilder();
        StringBuilder b1 = new StringBuilder();
        for (int i = 0; i < row.length; i++) {
            if (row[i] == 0) {
                b0.append(i);
            } else {
                b1.append(i);
            }
        }
        String str0 = b0.toString();
        String str1 = b1.toString();
        if (!map.containsKey(str0))
            map.put(str0, 1);
        else
            map.put(str0, map.get(str0) + 1);
        if (!map.containsKey(str1))
            map.put(str1, 1);
        else
            map.put(str1, map.get(str1) + 1);
    }

    public static int maxEqualRowsAfterFlips(int[][] matrix) {
        Map<String, Integer> m = new HashMap<>();
        for (int i = 0; i < matrix.length; i++) {
            addRow(matrix[i], m);
        }
        return Collections.max(m.values());
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{0, 0, 0}, {0, 0, 1}, {1, 1, 0}};
        System.out.println(maxEqualRowsAfterFlips(matrix));
    }
}
