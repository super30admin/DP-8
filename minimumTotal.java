// Time Complexity : O(n)
// Space Complexity : O(1) 
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NO

// Your code here along with comments explaining your approach
class Solution {
    public int minimumTotal(List<List<Integer>> t) {
        
        int r = t.size();
        
        for(int i =r-2; i>=0; i--) {
            
            for(int j=0;j<t.get(i).size();j++) {
                
                t.get(i).set(j, t.get(i).get(j)+Math.min(t.get(i+1).get(j), t.get(i+1).get(j+1)));
                
            }
            
        }
        
        return t.get(0).get(0);
    }
}
