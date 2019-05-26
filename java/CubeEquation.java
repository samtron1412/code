/*
 * Listing all the solution for the equation: a^3 + b^3 = c^3 + d^3
 * Where a, b, c, d is in the range from 0 to 1000
 */

import java.util.Map;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class CubeEquation {
    public static void main(String[] args) {
        Map<Integer, List<Integer[]>> map = new HashMap<>();
        int max = 10;
        for (int a = 0; a <= max; a++) {
            for (int b = 0; b <= max; b++) {
                int sum = a*a*a + b*b*b;
                if (map.get(sum) == null) {
                    map.put(sum, new LinkedList<>());
                }
                map.get(sum).add(new Integer[]{a, b});
            }
        }
        var lst = map.values();
        int count = 0;
        for (var pairs : lst) {
            for (var p1 : pairs) {
                for (var p2 : pairs) {
                    System.out.print(p1[0] + " " + p1[1] + " "
                            + p2[0] + " " + p2[1]);
                    System.out.println();
                    count += 1;
                }
            }
        }
        System.out.println(count);
    }
}
