//Timecomplexity:-O(N*N);
//space complexity:- 0(1).


class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        
        for(int i = n - 2; i >= 0; i--){
            for(int j = 0; j <= i; j++){
                int min = Math.min(triangle.get(n - 1).get(j), triangle.get(n - 1).get(j + 1));
                
                int val = triangle.get(i).get(j);
                
                triangle.get(n - 1).set(j, val + min); // going from last arraylist ,for every element we overwrite values in bottom row depending on  minimum of these two (i-1)(j), (i-1)(j+1) values, and this min is added to current value in last row.
            }
        }
        
        return triangle.get(n - 1).get(0);
    }
}