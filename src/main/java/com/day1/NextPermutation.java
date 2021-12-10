package com.day1;

/*
Solution 1(Brute Force):
1.Find all permutation of given array
2.Sort it in ascending order
3.Find next permutation
Time Complexity: O()
Space Complexity: O()

Solution 2(Better):
1.Find a element from right most of array which has greater element in right
2.Swap with nearest greater element
3.Sort remaining element in increasing order
Time Complexity: O()
Space Complexity: O()

Solution 3(Optimal):

Time Complexity: O()
Space Complexity: O()

*/

import java.util.Arrays;

public class NextPermutation {

    // Function to swap the data
    // present in the left and right indices
    public static int[] swap(int data[], int left, int right) {

        // Swap the data
        int temp = data[left];
        data[left] = data[right];
        data[right] = temp;

        // Return the updated array
        return data;
    }

    // Function to reverse the sub-array
    // starting from left to the right
    // both inclusive
    public static int[] reverse(int data[], int left, int right) {

        // Reverse the sub-array
        while (left < right) {
            int temp = data[left];
            data[left++] = data[right];
            data[right--] = temp;
        }

        // Return the updated array
        return data;
    }

    // Function to find the next permutation
    // of the given integer array
    public static boolean findNextPermutation(int data[]) {

        // If the given dataset is empty
        // or contains only one element
        // next_permutation is not possible
        if (data.length <= 1)
            return false;

        int last = data.length - 2;

        // find the longest non-increasing suffix
        // and find the pivot
        while (last >= 0) {
            if (data[last] < data[last + 1]) {
                break;
            }
            last--;
        }

        // If there is no increasing pair
        // there is no higher order permutation
        if (last < 0)
            return false;

        int nextGreater = data.length - 1;

        // Find the rightmost successor to the pivot
        for (int i = data.length - 1; i > last; i--) {
            if (data[i] > data[last]) {
                nextGreater = i;
                break;
            }
        }

        // Swap the successor and the pivot
        data = swap(data, nextGreater, last);

        // Reverse the suffix
        data = reverse(data, last + 1, data.length - 1);

        // Return true as the next_permutation is done
        return true;
    }

    // Driver Code
    public static void main(String args[]) {
        int data[] = {1, 2, 3};
        if (!findNextPermutation(data))
            System.out.println("There is no higher order permutation for the given data.");
        else {
            System.out.println(Arrays.toString(data));
        }
    }
}
