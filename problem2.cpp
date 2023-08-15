/*
Time complexity: O(n^2)
Space complexity: O(n)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No
*/

class Solution {
   public:
    int minimumTotal(vector<vector<int>>& triangle) {
        
        int n = triangle.size();
        vector<int> next_row(triangle[n - 1]);
        vector<int> curr_row(n, 0);

        for (int i = n - 2; i >= 0; i--) 
        {
            for (int j = 0; j < i + 1; j++) 
            {
                int lower_left = triangle[i][j] + next_row[j];
                int lower_right = triangle[i][j] + next_row[j + 1];
                curr_row[j] = min(lower_left, lower_right);
            }

            swap(curr_row, next_row);
        }
        
        return next_row[0];
    }
};