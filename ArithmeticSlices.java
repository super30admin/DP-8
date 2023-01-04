package s30.dp.dp8;

public class ArithmeticSlices {
    //DP Algo: considering the curr index as my last element of the subarray for arithmetic slice,
    // here we need the sum of dp array as result.
    //TC: O(n)
    //SC: O(1)
    public int numberOfArithmeticSlicesDP(int[] nums) {

        int prev = 0;
        int res=0;

        for(int i =2; i < nums.length; i++){

            int curr = nums[i] - nums[i-1] != nums[i-1] - nums[i-2] ? 0 : 1 + prev;

            prev = curr;

            res += curr;
        }


        return res;
    }


    //recursive algo -> finding the count of  Arithmetic slices with all indices.
    //TC: O(n^2)
    //SC: O(n)
    public int numberOfArithmeticSlices(int[] nums) {

        return numberOfArithmeticSlices(nums, 0);
    }

    private int numberOfArithmeticSlices(int[] nums, int index){
        //base

        if(nums.length < 3 || index == nums.length -2) return 0;

        //recurse

        int notSelect = numberOfArithmeticSlices(nums, index+1);

        //select
        int select =0;
        int curr= nums[index];
        int next = nums[index+1];

        int diff = next - curr;

        for(int i= index+2; i < nums.length; i++){
            if(nums[i] - next == diff){
                select++;
                next = nums[i];
            }
            else break;
        }

        return select + notSelect;
    }


    public static void main(String[] args) {

    }
}
