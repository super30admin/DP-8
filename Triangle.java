class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        
        for(int i = triangle.size()-2;i>=0;i--) {
            List<Integer> mylist = triangle.get(i);
            for(int j =0; j< mylist.size();j++) {
                int minimum = Math.min(triangle.get(i+1).get(j), triangle.get(i+1).get(j+1))+ mylist.get(j);
                mylist.set(j,minimum);
            }
        }
              
         return triangle.get(0).get(0);
        }
    }
