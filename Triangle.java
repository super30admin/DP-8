Time Complexity = O(n*n)
Space Complexity = O(n)

class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[] ans = new int[n];
        
        int i = n-1;
        for(int j = 0; j < n ; j++){
            ans[j] = triangle.get(i).get(j);
        }
        
        int col = n-1;
        for(i = n-2;i >=0; i--){
            for(int j = 0; j < col; j++){
            ans[j] = Math.min(ans[j],ans[j+1]) + triangle.get(i).get(j);
            }
            col--;
        }
        return ans[0];
    }
}