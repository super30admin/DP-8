
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

// Approach: Recurrsion + memoization
// Time Complexity : O(m*m)  m = triangle.size()
// Space Complexity : O(m*m)
// Did this code successfully run on Leetcode : yes

class Solution {
public:
    int m = 0;
    vector<vector<int>>dp;
    int minimumTotal(vector<vector<int>>& triangle) {
        m = triangle.size();
        dp.resize(m+1,vector<int>(m+1,-1));
        return triangle[0][0]+dfs(0,0,triangle);
    }
    int dfs(int i,int j,vector<vector<int>>& triangle)
    {
        if(i==m-1) return dp[i][j] = 0;
        if(dp[i][j]!= -1) return dp[i][j];
        
        int a = triangle[i+1][j] + dfs(i+1,j,triangle);
        int b = triangle[i+1][j+1] + dfs(i+1,j+1,triangle);
        
        return dp[i][j] = min(a,b);
    }
};

// Approach : DP Bottom up
// Time Complexity : O(m*m)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes

class Solution {
public:
    int minimumTotal(vector<vector<int>>& triangle) {
        int m = triangle.size();
        
        for(int i = m-2;i>=0;i--)
        {
            for(int j = 0;j<=i;j++)
            {
                triangle[i][j]+= min(triangle[i+1][j], triangle[i+1][j+1]);
            }
        }
        return triangle[0][0];
    }
};