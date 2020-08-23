// Time Complexity : O(m*n)
// Space Complexity : O(1)
// Any problem you faced while coding this : No; Similar to paint house problem
// Your code here along with comments explaining your approach
//1. For Bottom Up approach start with last but 1 column and create the sum
//2. Do this till you reach the end of the triangle
//3. return the top element of the triangle


class Solution {
public:
    int minimumTotal(vector<vector<int>>& triangle) {
        //edge
        if(triangle.size()==0){
            return 0;
        }
        
        //dp approach
        //Bottom approach
        int rows = triangle.size();
        int cols;
        for(int i=rows-2; i>=0; i--){
            cols= triangle[i].size();
            for(int j=0; j<cols; j++){
                triangle[i][j] = min(triangle[i][j]+triangle[i+1][j] , triangle[i][j]+triangle[i+1][j+1]);
            }
        }
        return triangle[0][0];
    }
};


// Time Complexity : O(m*n)
// Space Complexity : O(1)
// Any problem you faced while coding this : No; Similar to paint house problem
// Your code here along with comments explaining your approach
//1. For Top Up approach start with  1 row and create the sum
//2. Do this till you reach the end of the triangle
//3. return the smallest element of the last row of the triangle


 class Solution {
 public:
     int minimumTotal(vector<vector<int>>& triangle) {
         //edge
         if(triangle.size()==0){
             return 0;
         }
         int global_min=INT_MAX;
         //dp approach
         //Top-Down approach
         int rows = triangle.size();
         int cols;
         for(int i=1; i<rows; i++){
             cols= triangle[i].size();
             for(int j=0; j<cols; j++){
                 if(j==0){
                    // cout<< " before "<<triangle[i][j]<<"\t";
                    triangle[i][j] = triangle[i][j]+triangle[i-1][j];
                    //cout<< " after "<<triangle[i][j]<<endl;
                 } else if(j==cols-1){
                     //cout<< " before "<<triangle[i][j]<<"\t";
                    triangle[i][j] = triangle[i][j]+triangle[i-1][j-1];
                    //cout<< " after "<<triangle[i][j]<<endl;
                 } else if(j>0){
                    //cout<< " before "<<triangle[i][j]<<"\t";
                    triangle[i][j] = min(triangle[i][j]+triangle[i-1][j] , triangle[i][j]+triangle[i-1][j-1]);
                    //cout<< " after "<<triangle[i][j]<<endl;
                  }
             }
         }
         cols= triangle[rows-1].size();
            
         for(int i=0; i<cols; i++){
             global_min = min(global_min, triangle[rows-1][i]);
         }
            
         return global_min;
     }
 };

//WITH EXTRA SPACE
// Time Complexity : O(m*n)
// Space Complexity : O(n)
// Any problem you faced while coding this :
// Your code here along with comments explaining your approach
//1. We know that at every row we have one more element than the row number.
//2. Traverse from back to front and fill those numbers at every level.
//3. Get the minimum number at the end.

class Solution {
public:
    int minimumTotal(vector<vector<int>>& triangle) {
        int row = triangle.size();
        if (row == 1)    return triangle[0][0];
        vector<int> dp(row + 1, INT_MAX);
        dp[0] = triangle[0][0];
        for (int i = 1; i < row; ++i) {
            for (int j = i; j >= 0; --j) {
                //cout<<j<<" before "<<dp[j]<<"\t";
                if(j==0)
                    dp[j] = dp[j] + triangle[i][j];
                else
                    dp[j] = min(dp[j - 1], dp[j]) + triangle[i][j];
                //cout<<" after "<<dp[j]<<endl;
            }
        }
        int minVal = INT_MAX;
        for (int i = 0; i <row; ++i) {
            minVal = min(minVal, dp[i]);
        }
        return minVal;
    }
};


// Time Complexity : O(n)
// Space Complexity : O(n)
// Any problem you faced while coding this :
//Understanding taking min per every row was a bit tricky

// Your code here along with comments explaining your approach
//1. Find minimum at every row
//2. Difference of prev min and current min is the element choosen. Push it back on the path
//3. Return the last row min.


class Solution {
public:
    int minimumTotal(vector<vector<int>>& triangle) {
        if(triangle.size() == 0) return 0;
        int rows =  triangle.size();
        vector<int> path;
        
        path.push_back(triangle[0][0]);
        int prev_row_min = triangle[0][0];
        int cols;
        for(int i = 1; i < rows; i++){
            int curr_row_min = INT_MAX;
            cols= triangle[i].size();
            for(int j = 0; j < triangle[i].size(); j++){ //traversal for every row
                if(j==0){
                    triangle[i][j] = triangle[i][j]+triangle[i-1][j];
                 } else if(j==cols-1){
                    triangle[i][j] = triangle[i][j]+triangle[i-1][j-1];
                 } else if(j>0){
                    triangle[i][j] = min(triangle[i][j]+triangle[i-1][j] , triangle[i][j]+triangle[i-1][j-1]);
                  }
                
                curr_row_min = min(curr_row_min, triangle[i][j]);
            }
            path.push_back(curr_row_min - prev_row_min);
            prev_row_min = curr_row_min;
        }
        
        for(int i=0; i<path.size(); i++){
            cout<<path[i]<<"\t";
        }
        cout<<endl;
        return prev_row_min;
        
    }
};

