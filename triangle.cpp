//Time - O(n) n-num of elements in triangle
//Space - O(1)
class Solution {
public:
    int minimumTotal(vector<vector<int>>& triangle) {
        
        for(int i = 1;i<triangle.size();i++){
            for(int j = 0;j<triangle[i].size();j++){
                triangle[i][j] += min((j-1>=0?triangle[i-1][j-1]:100000),(j<triangle[i-1].size()?triangle[i-1][j]:100000));
            }
        }
        
        int ans = INT_MAX;
        for(int j=0;j<triangle[triangle.size()-1].size();j++){
            ans = min(ans,triangle[triangle.size()-1][j]);
        }
        
        return ans;
        
    }
};