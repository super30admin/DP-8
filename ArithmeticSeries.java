
// Time Complexity : O(n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : Yes 
// Any problem you faced while coding this :No
class Solution {
    public int numberOfArithmeticSlices(int[] A) {
        if(A==null || A.length<3) return 0;
        int right = 0;
        int sum =0;
        for(int i = A.length-3 ; i>=0;i--)
        {
            right = A[i+1]-A[i] == A[i+2] -A[i+1] ? right+1:0;
            sum+=right;
        }
        return sum;
    }
}