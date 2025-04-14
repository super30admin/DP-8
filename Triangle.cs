// time complexity - O(n)
// space complexity- O(n)
public class Solution
{
    public int MinimumTotal(IList<IList<int>> triangle)
    {
        int n = triangle.Count();
        int[] dp = new int[n];
        // for(int i=0;i<n;i++)
        // {
        //     for(int j=0;j<n;j++)  
        //     {
        //         dp[i,j] = Int32.MinValue;
        //     } 
        // }
        // return helper(triangle,0,0,dp);
        // with dp
        for (int j = 0; j < n; j++)
        {
            dp[j] = triangle[n - 1][j];
        }
        for (int i = n - 2; i >= 0; i--)
        {
            for (int j = 0; j <= i; j++)
            {
                int ele = triangle[i][j];
                dp[j] = ele + Math.Min(dp[j], dp[j + 1]);
            }
        }
        return dp[0];
    }

    public int helper(IList<IList<int>> triangle, int i, int j, int[,] dp)
    {
        // base
        if (i == triangle.Count)
        {
            return 0;
        }
        if (dp[i, j] != Int32.MinValue)
        {
            return dp[i, j];
        }
        // logic
        int case1 = helper(triangle, i + 1, j, dp);
        int case2 = helper(triangle, i + 1, j + 1, dp);

        int re = Math.Min(case1, case2) + triangle[i][j];
        dp[i, j] = re;
        return re;
    }
}