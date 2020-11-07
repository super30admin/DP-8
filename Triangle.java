// Time Complexity : O(n*e) n is the number of rows and e is the number of elements in the row
// Space Complexity : O(n) n is the number of elements which we store of the next row and which is actually the number of the rows in the triangle
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        if(triangle == null || triangle.size() == 0)    return 0;
        int sum = 0;
        
        for(int i = triangle.size() - 2; i >= 0; i--){
            List<Integer> row = triangle.get(i+1);
            
            for(int j = 0; j <= i; j++){
                sum = Math.min(row.get(j), row.get(j+1)) + triangle.get(i).get(j);
                triangle.get(i).set(j,sum);
            }
        }
        return triangle.get(0).get(0);
    }
}
