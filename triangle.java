/*
Time Complexity: O(N)
Space Complexity: O(1)
*/
class Solution {
    
    public int minimumTotal(List<List<Integer>> triangle) {
        
        if(triangle.size() == 1){
            return triangle.get(0).get(0);
        }
        
        for(int i = triangle.size() - 2; i >= 0; i--){
            for(int j = 0; j < triangle.get(i).size(); j++){
                int val = triangle.get(i).get(j) + 
                    Math.min(triangle.get(i+1).get(j), triangle.get(i+1).get(j+1));
                 
                triangle.get(i).set(j, val);
            }
        }
        
        return triangle.get(0).get(0);
    }
    
}