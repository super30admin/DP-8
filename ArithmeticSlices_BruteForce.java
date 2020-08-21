// Time Complexity : O(n^2) --> where n is the length of input array
// Space Complexity : O(1)
// Did this code successfully run on Leetcode (413): Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach

class Solution {
    public int numberOfArithmeticSlices(int[] A) {
        // edge case
        if (A == null || A.length < 3) return 0;
        
        int count = 0;
        for (int i = 0; i < A.length - 2; i++) {
            int diff = A[i+1] - A[i];
            for (int j = i+1; j < A.length - 1; j++) {
                if (A[j+1] - A[j] == diff) count++;
                else break;
            }
        }
        return count;
    }
}