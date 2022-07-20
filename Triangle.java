// Time Complexity : O(n^2) n = number of rows
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
public class Triangle {
    class Solution {
        public int minimumTotal(List<List<Integer>> triangle) {
            int sum = 0;
            int n = triangle.size();
            for(int i=n-2; i>=0; i--) {
                for(int j=0; j<=i; j++) {
                    triangle.get(i).set(j, triangle.get(i).get(j)+Math.min(triangle.get(i+1).get(j), triangle.get(i+1).get(j+1)));
                }

            }
            return triangle.get(0).get(0);
        }
    }
}
