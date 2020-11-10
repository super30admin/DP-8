//Time Complexity-O(n*m)
//Space Complexity-O(n)
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        if(triangle.size()==0||triangle==null)
        {
            return 0;
        }
        int[]dp=new int[triangle.get(triangle.size()-1).size()];
        for(int j=0;j<dp.length;j++)
        {
            dp[j]=triangle.get(dp.length-1).get(j);
        }
        for(int i=dp.length-2;i>=0;i--)
        {
            for(int j=0;j<triangle.get(i).size();j++)
            {
                dp[j]=Math.min(dp[j],dp[j+1])+triangle.get(i).get(j);
            }
        }
        return dp[0];
    }
}