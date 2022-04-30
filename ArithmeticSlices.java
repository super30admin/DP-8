/*
Time Complexity: O(N), N is the length of the nums array
Space Complexity: O(1), constant space
Run on leetcode: yes
Any difficulties: no

Approach: **Well Commented Code**
 */
public class ArithmeticSlices {
    public static int arithmeticSlices(int[] nums){
        if(nums.length == 0){
            return 0;
        }
        // Total number of Arithmatic slices
        int sum = 0;

        // Maintaining count when the three consecutive numbers are in arithmetic progression
        int count = 0;

        for(int i = 2; i<nums.length; i++){
            /*
            If the three consecutive elements are in the arithmetic progression, then increment the count
             */
            if(nums[i]-nums[i-1] == nums[i-1]-nums[i-2]){
                count++;
            }
            /*
             Otherwise, we can simply add sum of these count as the number of arithmatic slices, with formula
             n*(n+1)/2 and reset the count by 0
             */
            else{
                sum+= count*(count+1)/2;
                count = 0;
            }
        }
        sum+= count*(count+1)/2;
        return sum;
    }

    public static void main(String[] args){
        System.out.println("Arithmetic slices: "+ arithmeticSlices(new int[]{1,2,3,4}));
    }
}
