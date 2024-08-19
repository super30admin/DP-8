/*
    LC - 120. Triangle
    TC - O(m * n)
    SC - O(1)
*/

class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        if(triangle == null || triangle.size() == 0) {
            return 0;
        }
        int m = triangle.size();
        for(int i = 1; i<m; i++) {
            for(int j=0; j<triangle.get(i).size(); j++){
                if(j == 0) {
                    triangle.get(i).set(j, triangle.get(i).get(j) + triangle.get(i - 1).get(j));
                } else if(j == triangle.get(i).size() -1) {
                    triangle.get(i).set(j, triangle.get(i).get(j) + triangle.get(i - 1).get(j - 1));
                } else {
                    triangle.get(i).set(j, triangle.get(i).get(j) + Math.min(triangle.get(i - 1).get(j), triangle.get(i - 1).get(j - 1)));
                }
            }
            int min = Integer.MAX_VALUE;
            for(int j=0; j< triangle.get(m - 1).size(); j++) {
                min = Math.min(min, triangle.get(m - 1).get(j));
            }
            return min;
        }
        return triangle.get(0).get(0);
    }
}