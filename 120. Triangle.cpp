class Solution {
public:

    /*
    Time: O(n)
    Space: O(no. of rows)

    Just do DP, but bottom-up and iterative, so you will need to keep a dp table of max_col size (which is equal to no. of rows)
    */
    int minimumTotal(vector<vector<int>>& t) {
        int n = t.size();
        
        vector<int> dp(n+1, 0);

        for(int i=n-1;i>=0;i--){
            vector<int> tmp = dp; //temporary store dp table
            dp = vector(n, INT_MAX); //init dp table to inf so that we can do min operation
           
            auto &v = t[i];


            for(int j=0;j<v.size();j++){    
                dp[j] = v[j] + min(tmp[j], tmp[j+1]); //fill this row's dp table using current cells' values and next row's dp table (stored in tmp)
            }
        }

        return dp[0];
    }
};
