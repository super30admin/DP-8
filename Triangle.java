// Time Complexity :O(N2)
// Space Complexity :O(N)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        if(triangle == null || triangle.size()==0) return 0;
        
        List<List<Integer>> dp = new ArrayList<>();
        for(List<Integer> item: triangle){
            dp.add(new ArrayList<>(Collections.nCopies(item.size(), 0)));
        }
        for(int i = 0;i<triangle.get(triangle.size()-1).size();i++){
            dp.get(dp.size()-1).add(i,triangle.get(triangle.size()-1).get(i));
        }
            int count = 0;
        for(int i = triangle.size()-2;i>=0;i--){
            for(int j=0;j<triangle.get(i).size();j++){
                dp.get(i).add(j,triangle.get(i).get(j)+Math.min(dp.get(i+1).get(j),dp.get(i+1).get(j+1)))  ;
            }
      
        }
          return dp.get(0).get(0);
    }
}
    
