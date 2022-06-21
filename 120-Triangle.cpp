/* 
    Time Complexity                              :  O(M*N) where M is the length of the rows and N is the length of the columns
    Space Complexity                             :  O(1) - since used the same 2d array
    Did this code successfully run on Leetcode   :  Yes
    Any problem you faced while coding this      :  No
*/

#include <bits/stdc++.h> 
using namespace std;  

class Solution {
public:
    int minimumTotal(vector<vector<int>>& triangle) {
        int n = triangle.size()-1;
        // return bottomUp(triangle);
        return topDown(triangle);
    }
    
    // bottom up 
    int bottomUp(vector<vector<int>>& triangle) {
        int n = triangle.size();
        
        for(int i=n-2;i>=0;i--) {
            for(int j=0;j<=i;j++) {
                triangle[i][j] += min(triangle[i+1][j],triangle[i+1][j+1]);
            }
        }
        
        return triangle[0][0];
    }
    
    // top-down
    int topDown(vector<vector<int>>& triangle) {
        int n = triangle.size();
        int mn = INT_MAX;
        
        for(int i=0;i<n;i++) {
            for(int j=0;j<=i;j++) {
                
                if(i > 0) {
                    if(j == 0) {
                        triangle[i][j] += triangle[i-1][j];
                    } else if (j == i) {
                        triangle[i][j] += triangle[i-1][j-1];
                    } else {
                        triangle[i][j] += min(triangle[i-1][j],triangle[i-1][j-1]);
                    }
                }
                
                if(i == n-1) {
                    mn = min(mn, triangle[i][j]);
                }
            }
        }
        
        return mn;
    }
    
};