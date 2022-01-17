package com.practice.day3;

/*
Solution 1(Brute Force):
1.Find count of all numbers using double far loop
2.return ans


Time Complexity: O(N^2)
Space Complexity: O(1)

Solution 2(Better):
1.Use hash-map

Time Complexity: O(N)
Space Complexity: O(N)

Solution 3(Optimal):
    1.Initialize 2 variables:
        Count –  for tracking the count of element
        Element – for which element we are counting
    2.Traverse through nums array.
        If Count is 0 then initialize the current traversing integer of array as Element
        If the traversing integer of array and Element are same increase Count by 1
        If they are different decrease Count by 1
    3.The integer present in Element is the result we are expecting
Time Complexity: O(N)
Space Complexity: O(1)

*/
public class MajorityElement1 {
    private static int majorityBy_NBy2(int[] numbers) {
        int count = 0;
        int element = 0;
        for (int n : numbers) {
            if (count == 0) {
                element = n;
            }
            if (n == element) {
                count++;
            } else {
                count--;
            }
        }
        return element;
    }

    public static void main(String[] args) {
        int[] numbers = new int[]{1, 4, 2, 5, 5, 2, 5, 5, 8, 5, 2, 5, 5, 5};
        System.out.println(majorityBy_NBy2(numbers));
    }
}
