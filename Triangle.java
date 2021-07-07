// Time Complexity : O(n*n) --> As the triangle is 2- D array we have to compare all the elements.
// Space Complexity : O(n) --> DP array to store the intermediate values 
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No
// Approach --> Bottom Up Approach
// Store bottom row in a array
// Add value from bottom array and get the minimum and proceed till it reaches TOP.
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        if(triangle == null || triangle.size() == 0)
            return 0;
        
        int n = triangle.size();
        int rows = triangle.get(n-1).size();
        int[] sumArrayatEachLevel = new int[rows];
        
        for(int i = 0; i< rows; i++){
            sumArrayatEachLevel[i] =  triangle.get(n-1).get(i);
        }
        
        int col = rows - 1; // Every time col reduce as we move upward from bottom.
        
        for(int i = n-2; i>=0; i--){          //Go from Bottom to top
            for(int j = 0; j<col; j++){       // Go from Left to Right in each individual list
                int currElem = triangle.get(i).get(j);
                sumArrayatEachLevel[j]= Math.min(sumArrayatEachLevel[j] + currElem,
                                                sumArrayatEachLevel[j+1] + currElem);
            }
            col--;
        }
        
       return sumArrayatEachLevel[0];
    }
}
