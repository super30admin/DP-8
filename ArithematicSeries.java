package com.example.problems;

//Time Complexity : O(N)
//Space Complexity : O(N)
//Did this code successfully run on Leetcode : yES
//Any problem you faced while coding this :nO

/*
 * DP Solution
 * 1. We start iterating array from 3nd item perform the following steps
 * 		a.) Maintain a counter for counting arithematic series
 * 		b.)Compare difference between pairs of (1st,2nd) and (2nd,3rd).
 * 			i.) If difference between pairs is same, we found the arithematic series,increment the counter 
 *  2. Keep repeating the step until all array is processed
 * */

public class ArithematicSeries {

	public int numberOfAritheticSlicesConstanSpace(int[] A) {
		int num = 0;
		int size = A.length;
		int curr = 0, right = 0;
		for (int i = 2; i < size; i++) {
			if (A[i] - A[i - 1] == A[i - 1] - A[i - 2]) {
				curr = right + 1;
				num += curr;
				right = curr;
			} else {
				right = 0;
			}
		}
		return num;
	}

	public int numberOfArithmeticSlices(int[] A) {
		int num = 0;
		int size = A.length;
		int dp[] = new int[size];
		for (int i = 2; i < size; i++) {
			if (A[i] - A[i - 1] == A[i - 1] - A[i - 2]) {
				dp[i] = dp[i] + 1;
				num += dp[i];
			}
		}
		return num;
	}

	public static void main(String args[]) {
		ArithematicSeries series = new ArithematicSeries();
		int A[] = { 1, 3, 5, 7, 9 };
		System.out.print(series.numberOfArithmeticSlices(A));
	}
}
