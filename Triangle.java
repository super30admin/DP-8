// Time Complexity : O(m * n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : NA


// Your code here along with comments explaining your approach

// We start iteration from bottom 2nd row and iterate the complete row
// At each element, current value is updated to curr + min(triangle.get(i + 1).get(j), triangle.get(i + 1).get(j + 1)) 
// Result is present at the top of triangle which is triangle.get(0).get(0)

class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        
        if(triangle == null || triangle.size() == 0) {
            return 0;
        }
        
        int rows = triangle.size();
        
        for(int i = rows - 2; i >= 0; i--) {
            for(int j = 0; j < triangle.get(i).size(); j++) {
                int first = triangle.get(i + 1).get(j);
                int second = triangle.get(i + 1).get(j + 1);
                int curr = triangle.get(i).get(j);
                triangle.get(i).set(j, curr + Math.min(first, second));
            }
        }
        return triangle.get(0).get(0);
    }
}