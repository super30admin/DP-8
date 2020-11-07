// Time Complexity : O(n-2) we iterate through the loop for n-2 times where n is the length of the given array
// Space Complexity : O(n) we store the array dp[] to find the number of slices
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public int numberOfArithmeticSlices(int[] A) {
        //no arithmetic slice can be formed if the array is null or there are less than 3 elements.
        if(A == null || A.length < 3)   return 0;
        
        int dp[] = new int[A.length];
        int slice = 0;
        
        for(int i = 2; i < A.length; i++){
            //to check the difference is same amongst the consecutive elements for 3 elements
            if(A[i] - A[i-1] == A[i-1] - A[i-2]){
                //adds 1 to the previously calculated value
                dp[i] = dp[i-1] + 1; 
                // slice will count the total number of arithmetic slices possible in the array
                slice += dp[i];
            }
        }
        return slice;
    }
}
//1 3 5 7 9
/*

0 1 2 3 4
1 3 5 7 9

0 1 2 3 4
0 0 1 2 3
slice 1 
1 + 2 = 3
3 + 3 = 6


*/
