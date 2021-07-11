// Time Complexity :O(n^2) where n is the number of rows in the triangle
// Space Complexity : O(1) With top down  
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/*class Solution {
public:
    int minimumTotal(vector<vector<int>>& triangle) {
        //bottom-up
        int n = triangle.size();
        vector<int> arr;
        arr = triangle[n-1];
        for(int i = n-2;i>=0;i-- ){
            for(int j=0;j<=i;j++){
                arr[j] = min(arr[j]+triangle[i][j],triangle[i][j]+arr[j+1]);
            }
        }
        return arr[0];
    }
};*/
class Solution {
public:
    int minimumTotal(vector<vector<int>>& triangle) {
        //top down
        for(int row = 1; row < triangle.size();row++){
            for(int col = 0; col < triangle[row].size();col++){
                if(col == 0){
                    triangle[row][col] = triangle[row][col] + triangle[row-1][col];
                }
                else if(col == triangle[row].size()-1){
                    triangle[row][col] = triangle[row][col] + triangle[row-1][col-1];
                }
                else{
                    triangle[row][col] = min(triangle[row][col] + triangle[row-1][col-1],
                                   triangle[row][col] + triangle[row-1][col]);
                }
            }
        }
        int minVal = INT_MAX;
        for(auto &c : triangle[triangle.size()-1]){
            minVal = min(minVal,c);
        }
        return minVal;
    }
};