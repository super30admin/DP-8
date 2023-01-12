// Time Complexity : O(n) where n is the total number of numbers in the triangle
// Space Complexity : O(1) 
// Did this code successfully run on Leetcode : Yes 

// bottom up approach
/*
   2
   /\
  3 4
  /\/\
  6 5 7
 /\ (take the min and 6 + min(4,1) = 7)
4  1 8 3

*/


class Solution {
public:
    int minimumTotal(vector<vector<int>>& triangle) {
        if(triangle.size() == 0) return 0;
        int n = triangle.size();
        // start from the second last row and update the value of the 2 adj from the next row
        for(int i = n - 2; i >= 0; i--) {
            for(int j = 0; j <= i; j++) {
                triangle[i][j] = triangle[i][j] + min(triangle[i+1][j], triangle[i+1][j+1]);
            }
        }
        return triangle[0][0];
    }
};


// top down approach 

// top down

class Solution {
public:
    int minimumTotal(vector<vector<int>>& triangle) {
        if(triangle.size() == 0) return 0;
        int n = triangle.size();
        // start from the second last row and update the value of the 2 adj from the next row
        for(int i=1; i<n; i++){
            for(int j=0; j<=i; j++){
              //3 cases 
              // its the first element and just gets the sum from top
              // same for the alst element 
              // if they are middle elements, get min of the 2 on top
                if(j == 0)
                    triangle[i][j] += triangle[i-1][j];
                else if (j == i)
                    triangle[i][j] += triangle[i-1][j-1];
                else {
                    triangle[i][j] += min(triangle[i-1][j-1], triangle[i-1][j]);
                }
            }
        }

        int result = INT_MAX;
        for(int i = 0; i<n; i++){
            if(result > triangle[n-1][i])
                result = triangle[n-1][i];
        }
        return result;
    }
};