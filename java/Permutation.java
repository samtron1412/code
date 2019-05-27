/*
 * Given a smaller string s and a bigger string b, find all permutations
 * of the shorter string within the longer one. Print the location of
 * each permutation.
 */

import java.lang.String;

public class Permutation {
    public static final int NO_OF_CHARS = 256;

    public static boolean isPermutation(int[] arr1, int[] arr2) {
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }

    public static void findPermutations(String shorter, String longer) {
        int countShorter[] = new int[NO_OF_CHARS];
        int countLonger[] = new int[NO_OF_CHARS];
        for (int i = 0; i < shorter.length(); i++) {
            countShorter[shorter.charAt(i)] += 1;
        }
        for (int i = 0; i < longer.length(); i++) {
            countLonger[longer.charAt(i)] += 1;
            if (isPermutation(countShorter, countLonger)) {
                System.out.println(i - shorter.length() + 1);
            }
            if (i >= shorter.length() - 1) {
                countLonger[longer.charAt(i - shorter.length() + 1)] -= 1;
            }
        }
    }

    public static void main(String[] args) {
        // findPermutations("abcd", "abcdabcd");
        findPermutations("abbc", "cbabadcbbabbcbabaabccbabc");
    }
}
