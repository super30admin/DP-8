// Time Complexity : O(n^2) - where n is the size of List. As we visit each element once, it's 1+2+3...n = n^2
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Approach : We can maintain a dp array and maintain the minimum value obtained at previous row's path sum at each index. We followed bottom up dp by starting from
// last row and add the minimum of previous row's i and i+1 to the current element and continue until we reach top of the dp. We can further optimize the space to
// O(1) by performing the operations on the input List as well by doing in place transformations.

class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[] dp = new int[n+1]; //dp array
        for(int i = n-1; i >=0;i--){ //bottom up dp
            for(int j = 0; j <= i;j++){
                dp[j] = triangle.get(i).get(j) + Math.min(dp[j], dp[j+1]); //current value + minimum of next row's j and j+1
            }
        }
        return dp[0];
    }
}