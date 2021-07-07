// Time Complexity : O(n) 
// Space Complexity : O(1) --> No extra space is used 
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No
// Approach --> Start from 0 since we need sequence of 3 elements. Take the difference of two elements and compare with previos 2 elements.
// If they matches increment the count
// Finally add the values to result



class Solution {
    public int numberOfArithmeticSlices(int[] A) {
        if(A == null || A.length == 0 || A.length < 3)
            return 0;
        
        int result  =0 ;
        int start = 0;
        int count = 0;
        int diff = 0;
        
        while(start < A.length - 2){
            if(A[start] - A[start+1] == A[start+1] - A[start+2]){
                count++;
                diff = A[start] - A[start+1];
            }else{
                count = 0;
            }

            result+= count;
            start++;
            
        }
     return result;   
    }
}
