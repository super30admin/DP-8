import java.util.*;
class Triangle {

    /**
     * Time complexity: O(M*N) where N is number of lists and M is max elements in each list;
     * Space complexity: O(1) 
     * 
     * Approach:
     * 1. For every top row, take the minimum of its adjacent numbers from the the row below it and 
     * add to it.
     */
    public int minimumTotal(List<List<Integer>> triangle) {
        
        if(triangle == null || triangle.size() == 0)
            return 0;
        
        int n = triangle.size();
        
        for(int i = n-2; i>=0; i--) {
            int cols = triangle.get(i).size();
            for(int j=0; j<cols; j++) {
                triangle.get(i).set(j, triangle.get(i).get(j) + 
                                   Math.min(triangle.get(i+1).get(j), triangle.get(i+1).get(j+1)));
            }
        }
        
        return triangle.get(0).get(0);
        
    }
}