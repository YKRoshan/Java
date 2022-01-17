package com.practice.day1;

public class KadaneAlgorithm {
	private static int kadane(int[] arr, int n) {
		int maxSum = arr[0];
		int maxSumSoFar = arr[0];
		for (int i = 0; i < n; i++) {
			maxSumSoFar = Math.max(maxSumSoFar + arr[i], arr[i]);
			maxSum = Math.max(maxSumSoFar, maxSum);
		}
		return maxSum;
	}

	public static void main(String[] args) {
		int[] arr = new int[]{1, 2, 3, -2, 5};
		System.out.println(kadane(arr, 5));

		int[] arr2 = new int[]{-1, -2, -3, -4};
		System.out.println(kadane(arr2, 4));

		System.out.println(4^3^6^2^1^1);
		System.out.println(3^6^2);
		System.out.println(1^2^3^4^5);
		//System.out.println(4^3^6^2^1^1);
	}
}