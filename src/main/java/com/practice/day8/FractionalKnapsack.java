package com.practice.day8;

import java.util.Arrays;

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
public class FractionalKnapsack {
    double fractionalKnapsack(int w, Item arr[], int n) {
        double res = 0d;
        Arrays.sort(arr, (a, b) -> {
            if ((double) a.value / (double) a.weight > (double) b.value / (double) b.weight)
                return -1;
            else if ((double) a.value / (double) a.weight < (double) b.value / (double) b.weight)
                return 1;
            return 0;
        });
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].weight <= w) {
                w -= arr[i].weight;
                res += arr[i].value;
            } else {
                double p = ((double) arr[i].value / (double) arr[i].weight) * w;
                res += p;
                w = 0;
            }
            if (w == 0) break;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println();
    }
}

class Item {
    int value, weight;

    Item(int x, int y) {
        this.value = x;
        this.weight = y;
    }
}