// Time Complexity : O(n^2) where n is the length of the array A
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach

// for every number, find difference between it and next number. 
// If that diff. continies, keep on adding to set
// when it violates move to next num in array and repeat

class arithmeticSlices_BruteForce {
    public int numberOfArithmeticSlices(int[] A) {
        if (A.length == 0) return 0;
        int count = 0;
        for (int i = 0; i < A.length - 2; i++) {
            int diff = A[i + 1] - A[i];
            for (int j = i + 1; j < A.length - 1; j++) {
                if (A[j + 1] - A[j] == diff) {
                    count++;
                } else {
                    break;
                }
            }
        }
        return count;
    }
}