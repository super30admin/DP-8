//DP approach where the auxillary data structure holds only elements of the last row 
//TC: O(n)
//SC: O(length of last row)
//running on leetcode: yes
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        //base case
        if(triangle == null || triangle.size()==0) return 0;
        //size of the given triangle
        int n = triangle.size();
        //create dp matrix of size n
        int[] dp = new int[n];
        //fill the dp array with elements of the last row
        //n elements are present in the last row
        for(int j=0; j<n; j++) {
            //j is the column, n-1 is the last row. iterating over the last row
            dp[j]=triangle.get(n-1).get(j); 
        }
        //Bottom up approach. going from last second row of the triangle and adding
        for(int i=n-2; i>=0; i--) {
            for(int j=0; j<=i; j++){
                dp[j]=triangle.get(i).get(j) + Math.min(dp[j], dp[j+1]);
            }
        }
        return dp[0];
}
}
