#include<iostream>
#include<bits/stdc++.h>
#include<vector>
using namespace std;
/*
We use a 1D array to store min path sums from the bottom row upwards.
For each row from bottom to top, we update the array using the two children below.
At the end, the first element of the array holds the final minimum total.
*/
class Solution{
public:
    int minimumTotal(vector<vector<int>>& triangle){
        int n = triangle.size();
        vector<int> dp = triangle[n-1];

        for(int i = n-2; i >= 0; i--){
            for(int j = 0; j <= i; j++){
                dp[j] = triangle[i][j] + min(dp[j], dp[j+1]);
            }
        }
        return dp[0];
    }
};
