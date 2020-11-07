    /*  Explanation
    # Leetcode problem link : https://leetcode.com/problems/arithmetic-slices/
    Time Complexity for operators : o(n) .. n is the length of the array
    Extra Space Complexity for operators : o(1) 
    Did this code successfully run on Leetcode : NA
    Any problem you faced while coding this : No
# Your code here along with comments explaining your approach
        # Basic approach : 
        # Optimized approach: 
                              
            # 1. 
                    A) Start from the end by A.length-2 position.
                    B) Check if different between 3 elements is same if it is then 
                        prev = 1 + prev
                        sum += prev
                    C) If not then, prev = 0.
                    D) At the end, return sum.
    */ 

class Solution {
    public int numberOfArithmeticSlices(int[] A) {
        if(A == null || A.length == 0)
            return 0;
        
        int prev = 0;
        int sum = 0;
        
        for(int i = A.length - 3; i >= 0; i--){
            if(A[i]-A[i+1] == A[i+1]-A[i+2]){
                prev = 1 + prev;
                sum += prev;
            }else
                prev = 0;
        }
        
        return sum;
    }
}