// Time Complexity - O(n) the int array is traversed only once
// Space complexity - O(1) constant space
public class ArithmeticSlices {
    public int countArithmetic(int [] nums){
        int n = nums.length;
        if( n < 3) return 0;

        int count = 0;
        int start = 0;

        for (int i =2; i < n; i++){
            if( nums[i] - nums[i -1] == nums[i-1] - nums[i-2]){
                count += i - start;
            } else{
                start = i - 1;
            }
        }
        return count;
    }

    public static void main ( String [] args){
       ArithmeticSlices solution = new ArithmeticSlices();;
       System.out.println(solution.countArithmetic(new int [] {1,2,3,4}));
       System.out.println(solution.countArithmetic(new int [] {1,3,5,7,9}));
       System.out.println(solution.countArithmetic(new int [] {1,2,3,8,9,10}));
    }
}
