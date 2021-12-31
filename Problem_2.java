// Time Complexity : O(m*n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : Yes
// Three line explanation of solution in plain english
// in top down take care of first and end case, and then at the end check the min between the last row.
// Your code here along with comments explaining your approach
// dp - top - down
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int m = triangle.size();
        if( m < 2 ) return triangle.get(0).get(0);
        for(int i = 1; i < m; i++){
            for(int j = 0; j <= i; j++){
                if( j == 0){
                    triangle.get(i).set(j, triangle.get(i).get(j) + triangle.get(i-1).get(0));
                }else if( j == i){
                    triangle.get(i).set(j, triangle.get(i).get(j) + triangle.get(i-1).get(i-1));
                }else{
                    triangle.get(i).set(j, triangle.get(i).get(j) + Math.min( triangle.get(i-1).get(j), triangle.get(i-1).get(j-1)));
                }
            }
        }
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < m; i++){
            min = Math.min(min, triangle.get(m-1).get(i));
        }
        return min;
    }
}

//bottom up - DP
// class Solution {
//     public int minimumTotal(List<List<Integer>> triangle) {
//       int m = triangle.size();
//       if(m < 2) return triangle.get(0).get(0);
//       for( int i = m-2; i >=0; i--){
//           for(int j = triangle.get(i).size()-1; j >=0 ; j--){
//               int sum = Math.min(triangle.get(i+1).get(j),
//                                  triangle.get(i+1).get(j+1));
//               triangle.get(i).set(j, (triangle.get(i).get(j)+ sum));
//           }
//       }
//       return triangle.get(0).get(0);
//     }
// }