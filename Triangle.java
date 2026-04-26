// Time Complexity : O(n^2)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach
/*
We start from the last second row and move upwards.For every element, we take the minumum of its children(j, j+1).
At the end, the topmost element gives the minimum sum.
 */
class Solution {
    Integer[][] memo;
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();

        for(int i = n - 2 ; i >= 0 ; i--) {
            for(int j = 0 ; j <= i ; j++) {
                triangle.get(i).set(j, triangle.get(i).get(j) + Math.min(triangle.get(i + 1).get(j) , triangle.get(i + 1).get(j + 1)));
            }
        }
        return triangle.get(0).get(0);
    }
}