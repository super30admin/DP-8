//problem1
class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int n=nums.length;
        int count=0;
        int curr=0;
        for(int i=n-3;i>=0;i--){
            if(nums[i]-nums[i+1]==nums[i+1]-nums[i+2]){
                curr=curr+1;
            }else{
                curr=0;
            }
            count+=curr;
        }
        return count;
    }
}
//problem2
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n=triangle.size();
        for(int i=n-2;i>=0;i--){
            for(int j=0;j<=i;j++){
                triangle.get(i).set(j,triangle.get(i).get(j)+
                Math.min(triangle.get(i+1).get(j),triangle.get(i+1).get(j+1)));
            }
        }
        return triangle.get(0).get(0);
    }
}
