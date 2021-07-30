// Time Complexity : O(N*M)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/*
    We do a bottom-up DP to find the minimum path sum.
*/

class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
       
        for(int i=triangle.size()-2; i>=0; i--)
            for(int j=0; j<triangle.get(i).size(); j++)
                triangle.get(i).set(j, triangle.get(i).get(j) + Math.min(triangle.get(i+1).get(j), triangle.get(i+1).get(j+1)));
    
        return triangle.get(0).get(0);
    }
}