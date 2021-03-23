/*
The time complexity is O(N) and the space complexity is O(1) where N is the total numbers in triangle.

Here the intuition is to start from the last but one level and take the least number from its below two children and add to its present
value. This way we are propogating the least value upwards and the top will get the least value.

Yes, the solution passed all the test cases.
 */
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {

        int tsize = triangle.size();
        if(tsize==0){return 0;}

        for(int i = tsize-2;i>=0;i--){
            for(int j = 0; j<=i; j++){
                triangle.get(i).set(j,triangle.get(i).get(j)+Math.min(triangle.get(i+1).get(j),triangle.get(i+1).get(j+1)));
            }
        }

        return triangle.get(0).get(0);
    }
}