package com.DataStructure.dynamicprogramming.problems;

public class pb5_LongestPalindrome {
    public static String longestPalindrome(String s) {
        if (isPalindrome(s))
            return s;
       // longestPalindrome(s.substring(1, s.length() - 1));
        String a = longestPalindrome(s.substring(1, s.length() - 1));
        String b = longestPalindrome(s.substring(0, s.length() - 2));
        return a.length() > b.length() ? a : b;
    }

    static boolean isPalindrome(String s) {
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != s.charAt(s.length() - 1 - i))
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("abababz"));
    }
}
