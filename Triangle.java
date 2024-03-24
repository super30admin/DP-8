/*Time Complexity: O(N^2)

Space Complexity: O(1)

Did this code successfully run on Leetcode : Yes

Approach: Tabulation - Bottom up

Prob: 120. Triangle
*/

import java.util.List;

class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        for(int i=n-2;i>=0;i--){
            for(int j=0;j<=i;j++){
                triangle.get(i).set(j,triangle.get(i).get(j) + 
                Math.min(triangle.get(i+1).get(j),triangle.get(i+1).get(j+1)));
            }
        }
        return triangle.get(0).get(0);
    }
}