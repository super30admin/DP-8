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