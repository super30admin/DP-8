/* Time Complexity : O(n^2)
 *   n - length of the input array */
/* Space Complexity : O(1) */
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

//Top-down
// Curr ele + Math.min(above two elements [if not first and last ele])
// Min in the last row will be the result


class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        for(int i = 1; i < n; i++){
            for(int j = 0; j <= i; j++){
                if(j == 0){//first ele
                    triangle.get(i).set(j, triangle.get(i).get(j) + triangle.get(i-1).get(j));
                } else if(j == i){//last ele
                    triangle.get(i).set(j, triangle.get(i).get(j) + triangle.get(i-1).get(j-1));
                } else {
                    triangle.get(i).set(j, (triangle.get(i).get(j) + Math.min(triangle.get(i-1).get(j), triangle.get(i-1).get(j-1))));
                }                
            }
        }
        //Min in the last row will be the result
        int min = Integer.MAX_VALUE;
        for(int j = 0; j < n; j++){
            min = Math.min(min, triangle.get(n-1).get(j));
        }
        return min;
    }    
}