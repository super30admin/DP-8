// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach
// DP
class Solution {
    public int numberOfArithmeticSlices(int[] A) {
        if(A==null || A.length==0)
            return 0;
        
        int prev =0;
        int sum = 0;
        for (int i = 2; i < A.length; i++) {
            if (A[i] - A[i - 1] == A[i - 1] - A[i - 2]) {
                prev = 1 + prev;
                sum += prev;
            }else{
                prev=0;
            }
        }
        return sum;
    }
}