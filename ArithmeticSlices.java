//TC: O(n)
//SC: O(1)
//approach: dynamic programming, but keeping previous counter to avoid having to maintain dp array

public class ArithmeticSlices {
    public int numberOfArithmeticSlices(int[] nums) {
        int count = 0;
        int prev = 0;
        for(int i=2;i<nums.length;i++){
            if(nums[i-1]-nums[i-2] == nums[i]-nums[i-1]){
                prev++;
            }else prev=0;
            count+=prev;
        }
        return count;
    }
}
