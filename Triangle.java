// Time complexity: O(N) where N is the number of elements in triangle
// Space complexity: O(1)

class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        
        if(n==0)    return 0;
        
        for(int i = n-2; i >=0; i--)
        {
            for(int j = 0; j <= i; j++)
            {
                triangle.get(i).set(j, triangle.get(i).get(j) +
                                    Math.min(triangle.get(i+1).get(j), triangle.get(i+1).get(j+1)));
            }
        }
        
        return triangle.get(0).get(0);
    }
}