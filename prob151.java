// S30 Big N Problem #151 {Medium}
// 120. Triangle

// Time Complexity :O(r*c)
// Space Complexity :O(r)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :None

// Your code here along with comments explaining your approach
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        if(triangle.size()==0 || triangle==null) return 0;
        int [] pathSum=new int[triangle.size()];
        
        //Filling the array bottom up
        for(int row=triangle.size()-1;row>=0;row--){
            int lenCol=triangle.get(row).size();
            
            for(int col=0;col<lenCol;col++){
                //bottom most level
                if(row==triangle.size()-1){
                    pathSum[col]=triangle.get(row).get(col);
                }
                //traversing other levels 
                else{
                    pathSum[col]=Math.min(pathSum[col],pathSum[col+1])+triangle.get(row).get(col);
                }
            }  
        }
        return pathSum[0];
    }
}