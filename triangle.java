// Time, Space - O(N^2), O(1)
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        if(triangle == null || triangle.size() == 0) {
            return 0;
        }
        
        int rows = triangle.size();
        
        for(int i=rows-2;i>=0;i--) {
            List<Integer> row = triangle.get(i+1);
        
            for(int j=0;j<row.size()-1;j++) {
                int curr = triangle.get(i).get(j);
                int val = Math.min(curr + row.get(j), curr + row.get(j+1));
                triangle.get(i).set(j, val);
            }
        }
        
        
        return triangle.get(0).get(0);
    }
}
