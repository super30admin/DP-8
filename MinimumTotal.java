// Time Complexity : The time complexity is O(n!) where n is the length of the triangle
// Space Complexity : The space complexity is O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach

class Solution {

    int min = Integer.MAX_VALUE;

    public int minimumTotal(List<List<Integer>> triangle) {

        int n = triangle.size();

        //traverse through the triangle
        for(int i=1;i<n;i++){
            for(int j=0;j<=i;j++){

                int min = Integer.MAX_VALUE;

                //find the minimum of the previous 2 elements
                for(int k=j-1;k<=j;k++){
                    if(k>=0 && k<i){
                        min = Math.min(min,triangle.get(i-1).get(k));
                    }
                }
                min += triangle.get(i).get(j);
                triangle.get(i).set(j,min);
            }
        }

        int min = Integer.MAX_VALUE;

        //get the minimum of all the paths
        for(int i=0;i<n;i++){
            min = Math.min(min,triangle.get(n-1).get(i));
        }

        return min;

    }
}