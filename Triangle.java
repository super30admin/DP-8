//Time Complexity: O(n*k) 
//Space Complexity: O(1)

class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int m = triangle.size();
        
        for(int i = m-2;i >=0;i--){
            for(int j=0;j<=i;j++){
                List<Integer> nextRow = triangle.get(i+1);
                
                int sum = Math.min(nextRow.get(j),nextRow.get(j+1)) + triangle.get(i).get(j);
                triangle.get(i).set(j,sum);
            }
        }
        
        return triangle.get(0).get(0);
    }
}