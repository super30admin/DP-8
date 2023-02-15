
// Time O(N)
// Space O(1)
public class ArithmaticSlices {
	
	public int numberOfArithmeticSlices(int[] nums) {
        if(nums==null || nums.length<=2)
            return 0;
        int sum=0;
        int prev=0;
       //int[] dp = new int[nums.length]; 
        for(int i=2;i<nums.length;i++){
            if(nums[i]-nums[i-1]== nums[i-1]-nums[i-2]){
                prev = 1+prev;
                sum+=prev;
            }else{
                prev=0;
            }
        }
        return sum;

    }
	
}
