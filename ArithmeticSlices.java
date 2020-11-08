// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

//minimum of 3 elements are required in the slice, so we check for 3 elements at a time , we start from the back
//whenever there is valid arithmetic expression, add 1 to the prev, when there isnt, make the prev as 0
//maintain a global sum of total slices for the array
//return sum

class Solution {
    public int numberOfArithmeticSlices(int[] A) {
        if(A==null||A.length==0){
            return 0;
        }
        int prev=0,sum=0;
        for(int x=A.length-3;x>=0;x--){
            if(A[x]-A[x+1]==A[x+1]-A[x+2]){
                prev=1+prev;
                sum+=prev;
            }
            else{
                prev=0;
            }
        }
        return sum;
    }
}