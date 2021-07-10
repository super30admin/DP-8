
// Time Complexity : O(nxm)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : Yes 
// Any problem you faced while coding this :No
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
               
        //edge case
        if(triangle.size() == 0)
        {
            return 0;
        }
        for(int i = triangle.size()-2;i >=0;i--)
        {
            for(int j = 0;j <triangle.get(i).size();j++)
            {
                triangle.get(i).set(j,
                                     Math.min(triangle.get(i+1).get(j),triangle.get(i+1).get(j+1))+triangle.get(i).get(j));
                                   
            }
        }
        return triangle.get(0).get(0);
    }
}