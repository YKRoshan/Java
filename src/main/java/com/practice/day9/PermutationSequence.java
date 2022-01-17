package com.practice.day9;

import java.util.ArrayList;
import java.util.List;

/*
Que: Given n and k, return the kth permutation sequence.

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
1 2 4
n=4 k=17

1 2 3 4
fact=24, per=6, fixedNumber=2, res=3,k=5

1 2 4
fact=8, per=2, fixedNumber=2, res=34, k=1
1 2
fact=2, per=1, fixedNumber=2, res=34, k=1


*/
public class PermutationSequence {
    static public String getPermutation(int n, int k) {
        String res = "";
        List<Integer> num = new ArrayList<>();
        int fact = 1;
        for (int i = 1; i <= n; i++) {
            num.add(i);
            fact *= i;
        }
        k--;
        while (!num.isEmpty()) {
            int per = fact / num.size();
            int fixedNumber = k / per;
            res += num.get(fixedNumber);
            k = k % per;
            fact /= num.size();
            num.remove(fixedNumber);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(getPermutation(3,2));
    }
}
