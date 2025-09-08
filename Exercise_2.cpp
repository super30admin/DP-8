// Time Complexity : O(n^2) where n is the number of elements
 // Space Complexity : O(1) since we are mutating the elements in triangle array
 // Were you able to solve it on Leetcode : Yes
 // Any problem you faced while coding this : No

class Solution {
public:
    int minimumTotal(vector<vector<int>>& triangle) {
        if (triangle.empty()){
            return 0;
        }
        if(triangle.size() == 1){
            return triangle[0][0];
        }   
        int n=triangle.size();
        // vector<int> dp = triangle[n-1];
        

        for (int i=n-2; i>=0;--i) {

            for (int j=0;j<=i;++j) {
                // cout<<i<<" "<<j<<endl;

                // dp[j] = triangle[i][j] + min(dp[j], dp[j+1]);
                triangle[i][j] += min(triangle[i+1][j], triangle[i+1][j+1] ) ;
            }
        }

        return triangle[0][0];
        
    }
};