// Time Complexity :o(n)
// Space Complexity :o(n)
// Did this code successfully run on Leetcode :YES
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n=triangle.size();
        int[] output=new int[n];
       int i= n-1;
        for(int j=0;j<n;j++){
            output[j]=triangle.get(i).get(j);
        }
        int cols=n-1;
        for(int k=n-2;k>=0;k--){
            for(int j=0;j<=cols-1;j++){
               output[j]= triangle.get(k).get(j)+Math.min(output[j],output[j+1]);
            }
        cols--;
        }
        return output[0];
    }
}