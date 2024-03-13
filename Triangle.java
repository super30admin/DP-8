// Time Complexity :O(N^2)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :Yess
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach: 
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n= triangle.size();
        for(int i=n-2; i>=0; i--){
            for(int j=0; j<i+1;j++){
                triangle.get(i).set(j, triangle.get(i).get(j)+Math.min(triangle.get(i + 1).get(j),triangle.get(i + 1).get(j + 1)));
            }
        }
        return triangle.get(0).get(0);
    }
}