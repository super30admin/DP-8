// Time Complexity : O(n*n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

public class Triangle {
    class Solution {
        public int minimumTotal(List<List<Integer>> triangle) {
            if(triangle.size() == 0 || triangle == null)
                return 0;
            int size = triangle.size();

            for(int i = size-2; i >= 0; i--){
                List<Integer> curr = triangle.get(i);
                for(int j = 0; j < curr.size(); j++){
                    int min = Math.min(triangle.get(i+1).get(j), triangle.get(i+1).get(j+1));
                    triangle.get(i).set(j, triangle.get(i).get(j) + min);
                }
            }
            return triangle.get(0).get(0);
        }
    }
}
