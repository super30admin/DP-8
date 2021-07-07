TC: O(n*m)
SC: O(1)

Runtime: 4 ms, faster than 32.62% of Java online submissions for Triangle.
Memory Usage: 39.2 MB, less than 8.16% of Java online submissions for Triangle.

Approach : Similar to minimum falling path. We start from second last row and for each position in the row, we find the minimum sum till
that path by adding the current value with minimum of the adjacent numbers in the next row. We are updating the minimum distance inplace.
Output will be the first element.

class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        
        if(triangle == null || triangle.size() ==0) return 0;
        
        for(int i=triangle.size()-2; i>=0 ; i--){
            for(int j=0; j<=i; j++ ){
                triangle.get(i).set(j,(triangle.get(i).get(j)+ Math.min(triangle.get(i+1).get(j),triangle.get(i+1).get(j+1))));
            }
        }
            
        return triangle.get(0).get(0);
        
    }
}
