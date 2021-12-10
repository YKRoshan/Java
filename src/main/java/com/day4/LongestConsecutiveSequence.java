package com.day4;

import java.util.HashSet;

public class LongestConsecutiveSequence {
    public static int longestConsecutive(int[] arr) {
        int ans = 0;
        HashSet<Integer> set = new HashSet<>();

        for (int n : arr) {
            set.add(n);
        }
        for (int n : arr) {
            if(!set.contains(n-1)){
                int count=1;
                n++;
                while(set.contains(n)){
                    count++;
                    n++;
                }
                ans=Math.max(count,ans);
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int []arr=new int[]{100,4,200,1,3,2};
        System.out.println(longestConsecutive(arr));
    }
}
