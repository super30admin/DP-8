//time complexity-O(n^2)
//Space complexity-O(size of last column of triangle)
//Ran on leetcode-Yes
//Solution with comments-
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int dp[]= new int [triangle.size()];
        for(int i=0;i<triangle.size();i++){
            dp[i]=triangle.get(triangle.size()-1).get(i);//adding the last column to dp array   
        }
        
        for(int i=triangle.size()-2;i>=0;i--){
            for(int j=0;j<triangle.get(i).size();j++){
                dp[j]=Math.min(dp[j],dp[j+1])+triangle.get(i).get(j);//adding only the minimum value to the dp array's index
            }
            
        }
        return dp[0];
        
    }
}