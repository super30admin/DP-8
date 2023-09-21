// Time Complexity : O(n) where n is the number of elements in triangle
// Space Complexity : O(1)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach

class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        //Starting from bottom row
        for(int i = triangle.size()-2; i>=0; i--){
            for(int j = 0; j <= i; j++ ){
                //Get the minimum and add it to current element
                triangle.get(i).set(j, triangle.get(i).get(j) + Math.min(triangle.get(i+1).get(j), triangle.get(i+1).get(j+1)));
            }
        }
        return triangle.get(0).get(0);
    }
}