package com.day3;

/*
Solution 1(Brute Force):
1.
2.
3.

Time Complexity: O()
Space Complexity: O()

Solution 2(Better):
1.
2.
3.
Time Complexity: O()
Space Complexity: O()

Solution 3(Optimal):
1.
2.
3.
Time Complexity: O()
Space Complexity: O()

*/
public class MyPow {
    public static double pow(double x, int n) {
        long nn = n;
        double d = 1.0;
        boolean isNegative = false;
        if (nn < 0) {
            isNegative = true;
            nn = nn * (-1);
        }
        while (nn > 0) {
            if (nn % 2 == 1) {
                d *= x;
                nn--;
            } else {
                x = x * x;
                nn /= 2;
            }
        }
        return isNegative ? (double) 1.0 / (double) d : (double) d;
    }

    public static void main(String[] args) {
        System.out.println(pow(2, -3));
    }
}
