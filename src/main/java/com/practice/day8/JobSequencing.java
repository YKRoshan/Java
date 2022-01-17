package com.practice.day8;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

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
public class JobSequencing {
    static int[] JobScheduling(Job arr[], int n) {
        int jobCount = 0, totalProfit = 0;
        Arrays.sort(arr, (a, b) -> a.profit - b.profit);

        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < arr.length; i++) {
            if (!set.contains(arr[i].deadline)) {
                set.add(arr[i].deadline);
                jobCount++;
                totalProfit += arr[i].profit;
            } else {
                for (int j = arr[i].deadline - 1; j > 0; j--) {
                    if (!set.contains(j)) {
                        set.add(j);
                        jobCount++;
                        totalProfit += arr[i].profit;
                        break;
                    }
                }
            }
        }
        int[] res = new int[2];
        res[0] = jobCount;
        res[1] = totalProfit;
        return res;
    }

    public static void main(String[] args) {
        System.out.println();
    }
}

class Job {
    int id, profit, deadline;

    public Job(int id, int profit, int deadline) {
        this.id = id;
        this.profit = profit;
        this.deadline = deadline;
    }
}