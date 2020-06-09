//120 Triangle.java
//Time: O(number of elements(triange))
//Space: O(numberof(rows))
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        
        
        List<Integer> prevList = new ArrayList<>();
        //edge case
        if(triangle == null)
            return 0;
        
        //get the prevlist
        prevList = triangle.get(0);
        
        for(int i = 1;i < triangle.size();++i){
            
            List<Integer> currentList = triangle.get(i);
            
            
            for(int j = 0; j < currentList.size();++j){
                
                int leftIndex;
                int rightIndex;
                if(j == 0){
                    //same index
                    leftIndex = j;
                    //same index
                    rightIndex = j;
                    
                } 
                else {
                    
                    leftIndex = j -1;
                    if(j < prevList.size())
                        rightIndex = j;
                    else
                        rightIndex = j-1;
                    
                }
                int leftVal = prevList.get(leftIndex);
                int rightVal = prevList.get(rightIndex);
                int currentVal = currentList.get(j);
                currentVal = Math.min(leftVal+currentVal,rightVal+currentVal);
                currentList.set(j,currentVal);
                
            }   
            prevList = currentList;
        }
        
        return Collections.min(prevList);
    }
}
