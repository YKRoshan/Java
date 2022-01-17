package com.practice.day10;

public class SingleNonDuplicateInSortedArray {
    static public int singleNonDuplicate(int[] num) {
        int res = 0;
        int l = 0;
        int r = num.length - 1;
        while (l < r) {
            int mid = (l + r) / 2;
            if (mid % 2 == 1) {
                if (num[mid] == num[mid - 1]) {
                    l = mid + 1;
                } else r = mid;
            } else {
                if (num[mid] == num[mid + 1]) {
                    r = mid;
                } else if (num[mid] == num[mid + 1]) {
                    l = mid;
                } else return num[mid];
            }
        }
        return res;
    }

    /*
    public int singleNonDuplicate(int[] nums) {
        int low = 0, high = nums.length - 2;
        while(low <= high) {
            int mid = (low + high) >> 1;
            if(nums[mid] == nums[mid^1]) {
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }
        return nums[low];
    } */
    public static void main(String[] args) {
        System.out.println(singleNonDuplicate(new int[]{3, 3, 7, 7, 10, 11, 11}));
    }
}
