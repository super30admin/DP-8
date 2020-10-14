//Time Complexity-O(n)-->Total number of elements in vector of vectors
//Space Complexity-O(1)
//Did the code execute on Leetcode? Yes

class Solution {
public:
    int minimumTotal(vector<vector<int>>& triangle) {
        if(triangle.size()==0)
        {
            return 0;
        }
        for(int i=triangle.size()-1;i>0;i--)
        {
            for(int j=0;j<triangle[i].size()-1;j++)
            {
                triangle[i-1][j]+=min(triangle[i][j],triangle[i][j+1]);
            }
        }
        return triangle[0][0];
    }
};