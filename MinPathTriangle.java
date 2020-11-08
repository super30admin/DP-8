// Time Complexity : O(n*m)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

//we shall take a dp array which will keep track of path sum, of length triangle
//populate dp array with last row of triangle as we move step by step from bottom upward
//at each level i, for each j, take min value between that index and the next from the row below , 
//add it with current index from triangle and update the dp array
//after all levels are traversed, the value at dp[0] wpuld be our answer 

class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        if(triangle==null||triangle.size()==0||triangle.get(0).size()==0){
            return 0;
        }
        
        int[] dp=new int[triangle.get(triangle.size()-1).size()];
        for(int i=0;i<dp.length;i++){
            dp[i]=triangle.get(dp.length-1).get(i);
        }
        for(int i=triangle.size()-2;i>=0;i--){
            for(int j=0;j<=i;j++){
                dp[j]=Math.min(dp[j],dp[j+1])+triangle.get(i).get(j);
            }
        }
        return dp[0];
    }
}