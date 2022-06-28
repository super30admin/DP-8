// Time Complexity : O(m*n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// 1) Bottom up approach
// 2) Start with 2nd last row, look at below elements and take min and add it to current
// 3) TC: O(row*col)

// 1) Top down approach
// 2) Start with 2nd row, look up for min and add to current element
// 3) If we are t boundary element, we need to consider the different conditions
//     a. First column - take only above row , first column value
//     b. Last column - take only above last column value
//     c. In middle - take above tow element, find min, add to current


public int MinimumTotal(IList<IList<int>> triangle) {
    if(triangle == null || triangle.Count() == 0)            
        return 0;
    
    int n = triangle.Count;

    //bottom up approach
    // for(int i = n-2; i >= 0; i--)
    // {
    //     for(int j = 0; j < triangle[i].Count; j++)
    //     {
    //         triangle[i][j] = triangle[i][j] + Math.Min(triangle[i+1][j], triangle[i+1][j+1]);
    //     }
    // }
    // return triangle[0][0];
    
    if(n == 1)
        return triangle[0][0];
    int min = Int32.MaxValue;
    //top down approach
    for(int i = 1; i < n; i++)
    {
        for(int j = 0; j < triangle[i].Count; j++)
        {
            if(j == 0)
                triangle[i][j] = triangle[i][j] + triangle[i-1][j];
            else if (j == triangle[i].Count - 1)
                triangle[i][j] = triangle[i][j] + triangle[i-1][j-1];
            else
                triangle[i][j] = triangle[i][j] + Math.Min(triangle[i-1][j-1], triangle[i-1][j]);
            
            if(i == n-1)
                min = Math.Min(min, triangle[i][j]);
        }
    }
    
    return min;
}