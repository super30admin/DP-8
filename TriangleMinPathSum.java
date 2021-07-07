// Time Complexity : O(n*m)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

import java.util.List;

public class TriangleMinPathSum {
    public int minimumTotal(List<List<Integer>> triangle) {
        // we go bottom up
        int n = triangle.size();

        if(n == 0){
            return 0;
        }

        for(int i = n-2; i>=0; i--){
            for(int j = 0; j <= i; j++){
                triangle.get(i).set(j, triangle.get(i).get(j) + Math.min(triangle.get(i+1).get(j), triangle.get(i+1).get(j+1)));
            }
        }

        return triangle.get(0).get(0);
    }
}
