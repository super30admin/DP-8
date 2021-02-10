//Given a triangle array, return the minimum path sum from top to bottom.
// TC O(N) SC O(1)
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0){
            return 0;
        }
        for (int i = triangle.size()-2; i >= 0; i--) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                int value = Math.min(triangle.get(i+1).get(j), triangle.get(i+1).get(j+1));
                int currVal = triangle.get(i).get(j);
                triangle.get(i).set(j, currVal + value);
            }
        }
        return triangle.get(0).get(0);
    }
}
