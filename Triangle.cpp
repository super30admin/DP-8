// Approach - Bottom up DP and modifying the given matrix.
// Time Complexity - O(n^2)
// Space Complexity - O(1)
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
