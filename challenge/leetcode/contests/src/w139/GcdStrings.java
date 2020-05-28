package w139;

import java.util.*;

class GcdStrings {
    public static int gcd(int a, int b) {
        if (a == 0) {
            return b;
        }
        return gcd(b % a, a);
    }

    public static Integer[] commonDividers(int a, int b) {
        Set<Integer> s = new HashSet<>();
        int gcd = gcd(a, b);
        for (int i = 1; i <= Math.sqrt(gcd); i++) {
            if (gcd % i == 0) {
                s.add(i);
                s.add(gcd / i);
            }
        }
        Integer[] arr = s.toArray(new Integer[s.size()]);
        Arrays.sort(arr);
        return arr;
    }

    public static boolean isDivided(String divisor, String dividend) {
        for (int i = 0; i < dividend.length(); i++) {
            if (dividend.charAt(i) != divisor.charAt(i % divisor.length())) {
                return false;
            }
        }
        return true;
    }

    public static String gcdOfStrings(String str1, String str2) {
        if (str1.length() == 0 || str2.length() == 0) {
            return "";
        }
        Integer[] cds = commonDividers(str1.length(), str2.length());
        for (int i = cds.length - 1; i >= 0; i--) {
            String divisor = str1.substring(0, cds[i]);
            if (isDivided(divisor, str1) && isDivided(divisor, str2)) {
                return divisor;
            }
        }
        return "";
    }

    public static void main(String[] args) {
//        String str1 = "ABCABC";
//        String str1 = "ABABAB";
        String str1 = "";
//        String str2 = "ABC";
//        String str2 = "ABAB";
        String str2 = "ABCABCABC";
        String str = gcdOfStrings(str1, str2);
        System.out.println(str);
    }
}
