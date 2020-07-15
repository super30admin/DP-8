// Time Complexity : 
            /*              APPROACH 1 : BRUTE FORCE: O(n^2) where n is the number of elements
                            APPROACH 2 : DP : O(n) where n is the number of elements
                            APPROACH 3 : OPTIMISED DP: O(n) where n is the number of elements
// Space Complexity :
            /*              APPROACH 1 : BRUTE FORCE: O(1) 
                            APPROACH 2 : DP : O(n) where is the number of elements
                            APPROACH 3 : OPTIMISED DP: O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None
/* Your code here along with comments explaining your approach: In the brute force approach, it is a straightforward approach that if the length
of subset is at least 3, then simply for each element, run another loop checking the difference between the consecutive elements on a set of three.
In DP apporach, once you get a subset of at least 3, store the occurance in a DP array, and if the next element leaves the subset difference intact,
add the number the subset, and increment the count in dp array by 1 from the previous element's count. In optimised dp, we are not maintaining
any extra space because we are concerened with only the previous element for which a variable is suffice.
*/
// APPROACH 1 : BRUTE FORCE
class Solution {
    public int numberOfArithmeticSlices(int[] A) {
        if(A == null || A.length < 3) return 0;
        int count  = 0;
        for(int i = 0; i < A.length-2 ; i++){
            int j = i+2;                                                                        // Start from the third elment j
            while(j < A.length){
                if(A[i+1] - A[i] == A[j] - A[j-1]){                                                 // Check the difference between consecutive elements
                    count++;                                                                // Increase the count since it satisfies the constraint
                } else {
                    break;                                                                          // subset found till now, need to find next one
                }
                j++;
            }
        }
        return count;
    }
}

// APPROACH 2 : DP 
class Solution {
    public int numberOfArithmeticSlices(int[] A) {
        if(A == null || A.length < 3) return 0;                                                                 // Base case of at least 3
        int[] dp = new int[A.length];
        for(int i = 2; i < A.length ; i++){                                                                 // Start from third elments
           if(A[i] - A[i-1] == A[i-1] - A[i-2]){                                            // Check the difference between consecutive elements
               dp[i] = dp[i-1] + 1;                                                     // Use the subset count found till the previous element's dp array
           }
        }
        return Arrays.stream(dp).sum();                                                             // return the sum of the number of subsets
    }
}

// APPROACH 3 : OPTIMISED DP
class Solution {
    public int numberOfArithmeticSlices(int[] A) {
        if(A == null || A.length < 3) return 0;
        int right = 0;                                                                              // local count
        int sum = 0;    
        for(int i = 2; i < A.length ; i++){
           if(A[i] - A[i-1] == A[i-1] - A[i-2]){                                                                // Check the difference
               right = right+1;                                                                 // Increment the count of subset till now
               sum += right;                                                                // Taking sum of the counts
           } else { 
               right = 0;                                                                       // Reset the count
           }
        }
        return sum;
    }
}