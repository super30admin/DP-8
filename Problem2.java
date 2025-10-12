

//Time Complexity: O(n^2) where n is the number of rows in the triangle
//Space Complexity: O(1) as we are modifying the input triangle in place

//Solved in leetcode: YES

//We can use dynamic programming to solve this problem. We start from the second row of the triangle and for each element,
// we add the minimum of the two elements directly above it in the previous row. We continue this process until we reach the last row.
// Finally, we return the minimum value from the last row as the result.

class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n=triangle.size();

        for(int i=1;i<n;i++) {
            for(int j=0;j<=i;j++) {
                if(j==0){
                    triangle.get(i).set(j,triangle.get(i).get(j)+triangle.get(i - 1).get(0));
                } else if(j==i) {
                    triangle.get(i).set(j,triangle.get(i).get(j)+triangle.get(i - 1).get(j - 1));
                } else {
                    triangle.get(i).set(j, triangle.get(i).get(j)+ 
                        Math.min(triangle.get(i - 1).get(j - 1),triangle.get(i - 1).get(j)));
                }
            }
        }

        int min=Integer.MAX_VALUE;
        for(int j=0;j<n;j++) {
            min=Math.min(min,triangle.get(n - 1).get(j));
        }

        return min;
    }
}
