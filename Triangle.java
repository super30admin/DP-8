// Time Complexity : O(n) where n is the number of elements
// Space Complexity : O(1) In place
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Finding the path without extra space.
/* Your code here along with comments explaining your approach: Start from the bottom, take the min of the adjacent neighbors and replace the
jth index with the min plus the current element. Move one row up and repeat the same by again taking the min of adjacent element, and then add
the min to the current element and similarly move bottom up till the top of the row will have the sum as root (min sum). The branches pointing
to the same neighbor of the traingle are the repeated subproblems.
*/
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        if(triangle == null || triangle.size() == 0) return 0;
        for(int i = triangle.size()-2; i>=0;  i--){                                                                     // Bottom up
            for(int j = 0; j < triangle.get(i).size(); j++){
             triangle.get(i).set(j, triangle.get(i).get(j) + Math.min(triangle.get(i+1).get(j),             // Take the min of the adjacent neighbors + Current element
                               triangle.get(i+1).get(j+1)));   
            }
        }
        return triangle.get(0).get(0);                                                                      // Return the root
    }
}