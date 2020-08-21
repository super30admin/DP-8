// Time Complexity : O(n) --> where n is the length of input array
// Space Complexity : O(1)
// Did this code successfully run on Leetcode (413): Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach

class Solution {
    public int numberOfArithmeticSlices(int[] A) {
        // edge case
        if (A == null || A.length < 3) return 0;
        
        int prev = 0;
        int sum = 0;
        for (int i = 2; i < A.length; i++) {
            if (A[i-1] - A[i-2] == A[i] - A[i-1]) {
                prev += 1;
                sum += prev;
            }
            else prev = 0;
        }
        return sum;
    }
}