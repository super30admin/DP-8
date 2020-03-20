//Time Complexity: O(n)
//Space Complexity: O(n)

public class Solution {
    public int numberOfArithmeticSlices(int[] A) {
        //base case
        if(A == null || A.length == 0)
            return 0;
        //size of array
        int n = A.length;
        //consider dp of n size
        int[] dp = new int[n];
        int result = 0;
        //i starts from 2 cz we need atleast 3 elements to check Airthmetic Progression
        //1,2,3,4 
        for (int i = 2; i < dp.length; i++) {
            //if (2-1) == (3-2) : as AP condition
            if (A[i] - A[i - 1] == A[i - 1] - A[i - 2]) {
                //until i; from prev + 1
                dp[i] = dp[i - 1] + 1;
                //add with result
                result += dp[i];
            }
        }
        return result;
    }
}

/****************************************************************************************************** */

//Brute Force
//Time Complexity: O(n^2)

public class Solution {
    public int numberOfArithmeticSlices(int[] A) {
        //base case
        if(A == null || A.length == 0)
            return 0;
        int count = 0;
        //top down approach
        for (int i = 0; i < A.length - 2; i++) {
            int diff = A[i+1] - A[i];
            for(int j = i+1; j < A.length-1; j++){
                //compare the difference with the diff calculated
                if (A[j+1] - A[j] == diff){
                    //increment count
                    count++;
                }
                //else break; since not an AP
                else break;
            }
         }
        //return the total count from the calculation
        return count;
    }
}

/****************************************************************************************** */

//Time Complexity: O(n)
//Space Complexity: O(1)
//No DP
public class Solution {
    public int numberOfArithmeticSlices(int[] A) {
        //base case
        if(A == null || A.length == 0)
            return 0;
        //size of array
        int n = A.length;
        int result = 0;
        //consider a curr value
        int curr = 0;
        //i starts from 2 cz we need atleast 3 elements to check Airthmetic Progression
        //1,2,3,4 
        for (int i = 2; i < n; i++) {
            //if (2-1) == (3-2) : as AP condition
            if (A[i] - A[i - 1] == A[i - 1] - A[i - 2]) {
                //until i, curr val + 1
                curr = curr + 1;
                //add curr to result
                result += curr;
            } else { 
                //if diff not equal; reset curr to 0
                curr = 0;
            }
        }
        return result;
    }
}

