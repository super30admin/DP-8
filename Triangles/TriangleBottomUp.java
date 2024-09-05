/* Time Complexity : O(n)
 *   n - length of the input array */
/* Space Complexity : O(1) */
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

//Bottom-up 
// Curr ele + Math.min(below two elements)


class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        for(int i = n -2; i >= 0; i--){
            for(int j = 0; j <= i; j++){
                triangle.get(i).set(j, (triangle.get(i).get(j) + Math.min(triangle.get(i+1).get(j), triangle.get(i+1).get(j+1))));
            }
        }
        return triangle.get(0).get(0);
    }    
}


/*
//with path
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] path = new int[n-1][n-1];
        for(int i = n -2; i >= 0; i--){
            for(int j = 0; j <= i; j++){
                int min;
                if(triangle.get(i+1).get(j) < triangle.get(i+1).get(j+1)){
                    min = triangle.get(i+1).get(j);
                    path[i][j] = j;
                } else {
                    min = triangle.get(i+1).get(j+1);
                    path[i][j] = j + 1;
                }
                triangle.get(i).set(j, (triangle.get(i).get(j) + min));
            }
        }
        System.out.println(Arrays.deepToString(path));
        return triangle.get(0).get(0);
    }    
}

*/