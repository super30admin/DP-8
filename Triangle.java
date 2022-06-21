//Bottom Up Dp approach
class Solution {

    //Time Complexity : 0(m*n) where m is length of the triangle list and n is the length of the list inside
    //Space Complexity: 0(1)
    //Did it successfully run on leetcode: Yes
    //Did you face any problem while coding: No

    //In brief Explain your approach

    public int minimumTotal(List<List<Integer>> triangle) {
        if(triangle == null || triangle.size() == 0){
            return 0;
        }
        int n = triangle.size();//finding the size of the entire list
        for(int i = n-2; i >= 0; i--){  //since it's a bottom up dp, sp starting with the 2nd last row as I will compute the last row
            for(int j = 0; j <=i; j++){ //staring from 0 as it computes the column and goes upto i
                triangle.get(i).set(j, triangle.get(i).get(j) + Math.min(triangle.get(i+1).get(j),triangle.get(i+1).get(j+1)));
            }//for 1st column, I have access to the bottom 2 elements, therefore getting the min of bottom 2 and adding it to my current and doing the same for the entire row
        }
        return triangle.get(0).get(0);
    }
}

//Top Down Approach

class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        if(triangle == null || triangle.size() == 0){
            return 0;
        }
        int n = triangle.size();
        for(int i = 1; i < n; i++){
            for(int j = 0; j <= i; j++){
                if(j == 0){
                    triangle.get(i).set(j , triangle.get(i).get(j) + triangle.get(i-1).get(j));
                }
                else if(j == i){
                    triangle.get(i).set(j, triangle.get(i).get(j) + triangle.get(i-1).get(j-1));
                }else{
                    triangle.get(i).set(j, triangle.get(i).get(j) + Math.min(triangle.get(i-1).get(j), triangle.get(i-1).get(j-1)));
                }
            }
        }
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++){
            min = Math.min(min, triangle.get(n-1).get(i));
        }
        return min;
    }
}