package com.DataStructure.array;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = new int[]{4, 7, 5, 1, 8, 9, 2, 6, 3, 10};
        sort(arr, 0, arr.length - 1);

        for (int i : arr)
            System.out.print(i + " ");
    }

    private static void sort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = (right + left) / 2;
            sort(arr, left, mid);
            sort(arr, mid + 1, right);
            merge1(arr, left, mid, right);
        }
    }

    private static void merge1(int[] arr, int left, int mid, int right) {
        // Find sizes of two sub-arrays to be merged
        int n1 = mid - left + 1;//*
        int n2 = right - mid;
        int[] L = new int[n1];
        int[] R = new int[n2];
        //Copy values into sub-arrays
        for (int i = 0; i < n1; ++i)
            L[i] = arr[left + i];
        for (int j = 0; j < n2; ++j)
            R[j] = arr[mid + 1 + j];

        int i = 0, j = 0;
        // Initial index of merged sub-array array
        int k = left;//*
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k++] = L[i++];
            } else
                arr[k++] = R[j++];
        }
        /* Copy remaining elements of L[] if any */
        while (i < n1) {
            arr[k++] = L[i++];
        }
        /* Copy remaining elements of R[] if any */
        while (j < n2) {
            arr[k++] = R[j++];
        }
    }
}
