class Solution { //Memoization - Top down DP
//Time Complexity: O(N*N)
//Space Complexity: O(N*N)
    private:
    int minSum(int i , int j, vector<vector<int>>& triangle,int n , vector<vector<int> > &dp){
        // If the result for this cell is already calculated, return it
    if (dp[i][j] != -1)
        return dp[i][j];

    // If we're at the bottom row, return the value of the current cell
    if (i == n - 1)
        return triangle[i][j];

    // Calculate the sum of two possible paths: going down and going diagonally
    int down = triangle[i][j] + minSum(i + 1, j, triangle, n, dp);
    int diagonal = triangle[i][j] + minSum(i + 1, j + 1, triangle, n, dp);

    // Store the minimum of the two paths in the dp table and return it
    return dp[i][j] = min(down, diagonal);
    }
public:
    int minimumTotal(vector<vector<int>>& triangle) {
        int n = triangle.size();
        // vector<vector<int>> dp;
        // for (int i = 0; i < n; ++i) {
        //     dp.push_back(vector<int>(n, -1));
        // }
        vector<vector<int> > dp(n, vector<int>(n, -1));

        return minSum(0,0,triangle,n, dp);
        }
};