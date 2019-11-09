/*
The time complexity is O(N) and the space compleixty is O(1) where N is the length of A

Here the intuition is not to calculate the sub problems of again and again but save them for future use.

Yes, the solution passed all the test cases in leetcode
 */
class Solution {
    public int numberOfArithmeticSlices(int[] A) {

        int len = A.length;

        //If there are less than 3 numbers then no AP is possible, return 0
        if(len<3){return 0;}

        //prev is used to save the previous calculation.
        int ans = 0; int prev = 0;
        for(int i=2;i<len;i++){

            //For each index see if the present number with the previous two numbers will form AP. If yes than add 1 to the prev result.
            if(A[i-1]-A[i-2] == A[i]-A[i-1]){
                prev = prev+1;

                //Save every calculated value in our final answer
                ans+=prev;
            }
            else{
                prev = 0;
            }
        }

        return ans;
    }
}