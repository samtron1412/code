import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Solution {
    public static int uniquePairs(int[] nums, int target) {
        HashSet<Integer> uniqueNums = new HashSet<>();
        HashSet<Integer> uniquePairs = new HashSet<>();
        for (int num : nums) {
            uniqueNums.add(num);
        }
        for (int num : nums) {
            if (uniqueNums.contains(target - num) && !uniquePairs.contains(target - num)) {
                uniquePairs.add(num);
            }
        }
        return uniquePairs.size();
    }

    public static int[] movieFlight(List<Integer> movieDurations, int d) {
        int target = d - 30;
        HashMap<Integer, List<Integer>> originalIndices = new HashMap<>();
        int index = 0;
        for (Integer duration : movieDurations) {
            if (originalIndices.containsKey(duration)) {
                originalIndices.get(duration).add(index);
            } else {
                List<Integer> lst = new LinkedList<>();
                lst.add(index);
                originalIndices.put(duration, lst);
            }
            index += 1;
        }

        Collections.sort(movieDurations);
        int start = 0;
        int end = movieDurations.size() - 1;
        int first = movieDurations.get(start);
        int second = movieDurations.get(end);
        int max = Integer.MIN_VALUE;
        while (start <= end) {
            int curFirst = movieDurations.get(start);
            int curSecond = movieDurations.get(end);
            int sum = curFirst + curSecond;
            if (sum <= target) {
                if (sum > max) {
                    max = sum;
                    first = curFirst;
                    second = curSecond;
                }
                start++;
            } else {
                end--;
            }
        }

        int[] result = {originalIndices.get(first).get(0),
                originalIndices.get(second).get(0)};
        return result;
    }


    private static int[] Find2Sum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int max = Integer.MIN_VALUE;
        int[] res = new int[2];
        for(int i=0;i<nums.length;i++) {
            if(map.containsKey(nums[i])) {
                if(nums[i] > max || nums[map.get(nums[i])] > max) {
                    res[0] = map.get(nums[i]);
                    res[1] = i;
                    max = Math.max(nums[i], nums[map.get(nums[i])]);
                }
            }
            map.put(target - nums[i], i);
        }
        return res;
    }

    public static List<String> kSubstringUnique(String s, int k) {
        Set<Character> window = new HashSet<>();
        Set<String> result = new HashSet<>();
        for (int start = 0, end = 0; end < s.length(); end++) {
            //Remove all characters from start index to the existed character position
            for (; window.contains(s.charAt(end)); start++) {
               window.remove(s.charAt(start));
            }

            window.add(s.charAt(end));

            if (window.size() == k) {
                result.add(s.substring(start, end + 1));
                window.remove(s.charAt(start++));
            }
        }
        return new ArrayList<>(result);
    }


    public static int kSubstringNotUnique(String s, int k) {
        Set<Character> window = new HashSet<>();
        int result = 0;
        for (int start = 0, end = 0; end < s.length(); end++) {
            //Remove all characters from start index to the existed character position
            for (; window.size() > k; start++) {
                window.remove(s.charAt(start));
            }

            window.add(s.charAt(end));

            if (window.size() == k) {
                result++;
                window.remove(s.charAt(start++));
            }
        }
        return result;
    }


    public static int maxOfMinAltitudes(int columnCount, int rowCount,
                                 int[][] mat)
    {
        for (int i = 1; i < rowCount; i++) {
            mat[i][0] = Math.min(mat[i][0], mat[i-1][0]);
        }
        for (int j = 1; j < columnCount; j++) {
            mat[0][j] = Math.min(mat[0][j], mat[0][j-1]);
        }
        for (int i = 1; i < rowCount; i++) {
            for (int j = 1; j < columnCount; j++) {
                int min1 = Math.min(mat[i-1][j], mat[i][j]);
                int min2 = Math.min(mat[i][j-1], mat[i][j]);
                mat[i][j] = Math.max(min1, min2);
                System.out.println(mat[i][j]);
            }
        }
        return mat[rowCount - 1][columnCount - 1];
        // System.out.println(mat[rowCount - 1][columnCount - 1]);
        // return 0;
    }


    public static void main(String[] args) {
//        int[] nums = {1, 1, 2, 45, 46, 46};
//        int target = 47;

//        int[] nums = {1, 1};
//        int target = 2;

//        int[] nums = {1, 5, 1, 5};
//        int target = 6;
//
//        System.out.println(uniquePairs(nums, target));

        //====
//        Integer[] nums = {90, 85, 75, 60, 120, 150, 125};
//        int target = 250;
//        Integer[] nums = {10, 50, 20, 40, 30, 30, 0, 60};
//        int target = 90;
//        Integer[] nums = {0, 0, 0};
//        int target = 30;
//        List<Integer> movieDurations = new ArrayList<>();
//        Collections.addAll(movieDurations, nums);
//        int[] result = movieFlight(movieDurations, target);
//
//        System.out.println(result[0]);
//        System.out.println(result[1]);


        //=====
//        int[] nums1 = {1, 10, 25, 35, 60};
//        int target1 = 90;
//        System.out.println(Arrays.toString(Find2Sum(nums1, target1-30)));
//        int[] nums2 = {20, 50, 40, 25, 30, 10};
//        int target2 = 90;
//        System.out.println(Arrays.toString(Find2Sum(nums2, target2-30)));
//        int[] nums3 = {50, 20, 10, 40, 25, 30};
//        int target3 = 90;
//        System.out.println(Arrays.toString(Find2Sum(nums3, target3-30)));


        //======
//        System.out.println(kSubstringUnique("awaglknagawunagwkwagl", 4));
//        System.out.println(kSubstringUnique("abcabc", 3));



        //======
//        System.out.println(kSubstringNotUnique("pqpqs", 2));
//        System.out.println(kSubstringNotUnique("aabab", 3));

        int[][] mat = {{5, 1}, {4, 5}};
        System.out.println(maxOfMinAltitudes(2, 2, mat));
    }
}
