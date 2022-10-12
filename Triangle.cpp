// Approach - Bottom up DP and modifying the given matrix.
// Time Complexity - O(n^2)
// Space Complexity - O(1)
// It runs on Leetcode
// Problems Faced - No!
class Solution {
public:
    int minimumTotal(vector<vector<int>>& triangle) {
        int answer = 0;
        int n = triangle.size();
         for(int i = n-2; i >= 0; i--){
             int len = triangle[i].size();
             for(int j = 0; j < len; j++)
                 triangle[i][j] += min(triangle[i+1][j], triangle[i+1][j+1]);
         }
        return triangle[0][0];
    }
};

// Without modifying the input matrix.
// Time Complexity - O(n^2)
// Space Complexity - O(n^2)
// It runs on Leetcode
// Problems Faced - No!
class Solution {
public:
    int minimumTotal(vector<vector<int>>& triangle) {
        int n = triangle.size();
        vector<vector<int>> dp(n, vector<int>(n, 0));
        
        for(int i = 0; i < triangle[n-1].size(); i++)
            dp[n-1][i] = triangle[n-1][i];
        
        for(int i = n-2; i >= 0; i--){
            for(int j = 0; j <= i; j++)
                dp[i][j] = triangle[i][j] + min(dp[i+1][j], dp[i+1][j+1]);
        }
        return dp[0][0];
    }
};

// Time Complexity - O(n^2)
// Space Complexity - O(n)
// It runs on Leetcode
// Problems Faced - No!
class Solution {
public:
    int minimumTotal(vector<vector<int>>& triangle) {
        int n = triangle.size();
        vector<int> dp(n, 0);
        for(int i = 0; i < triangle[n-1].size(); i++)
            dp[i] = triangle[n-1][i];
        
        for(int i = n-2; i >= 0; i--){
            for(int j = 0; j <= i; j++)
                dp[j] = triangle[i][j] + min(dp[j], dp[j+1]);
        }
        return dp[0];
    }
};

// Printing the path
class Solution {
public:
    int minimumTotal(vector<vector<int>>& triangle) {
        int n = triangle.size();
        vector<int> dp(n, 0);
        vector<vector<int>> path(n, vector<int>(n, 0));
        
        for(int i = 0; i < triangle[n-1].size(); i++)
            dp[i] = triangle[n-1][i];
        
        for(int i = n-2; i >= 0; i--){
            for(int j = 0; j <= i; j++){
                path[i][j] = j;
                dp[j] = triangle[i][j] + min(dp[j], dp[j+1]);
                if(triangle[i+1][j] > triangle[i+1][j+1])
                    path[i][j] = j+1;
            }
        }
        int start = path[0][0];
        cout << triangle[0][0] << endl;
        for(int i = 1; i < n; i++){
            cout << triangle[i][start] << endl;
            start = path[i][start];
        }
        return dp[0];
    }
};