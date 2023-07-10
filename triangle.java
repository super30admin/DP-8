// tc : O(n*n)
// sc : O(1)

class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        for(int i = triangle.size()-2 ; i>=0 ; i--){
            List<Integer> row = triangle.get(i);
            for(int j =0 ; j <= i ; j++ ) row.set(j,row.get(j)+Math.min(triangle.get(i+1).get(j), triangle.get(i+1).get(j+1)));
        }
        return triangle.get(0).get(0);
    }
}
