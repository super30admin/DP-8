//time o(mn), m is no of rows, n - max elements in a particular row
//space o(1)
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        if(triangle == null || triangle.size() == 0)
            return 0;
        int size = triangle.size();
        
        for(int i=size-2; i>=0; i--) {
            int n = triangle.get(i).size();
            for(int j=0; j<n; j++) {
                triangle.get(i).set(j, triangle.get(i).get(j) +
                                   Math.min(triangle.get(i+1).get(j), triangle.get(i+1).get(j+1)));
            }
        }
        return triangle.get(0).get(0);
    }
}