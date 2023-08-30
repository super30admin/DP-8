import java.util.Scanner;

public class ArithmeticSlicesNestedLoops {

        // Brute Force - Nested Iterations - Time O(n*n) and Space O(1)

        public int numberOfArithmeticSlices(int[] nums) {

            int n = nums.length;

            if(n < 3) {
                return 0;
            }

            // arithmetic subarray count variable
            int countArithmetic = 0;

            // loop to check forward difference
            for(int i = 0; i < n-2; i++) {

                // difference of first pair in consecutive elements
                int diff = nums[i+1] - nums[i];

                // nested loop to check backward difference
                for(int j = i+2; j < n; j++) {

                    // difference of last pair in consecutive elements
                    if(nums[j] - nums[j-1] == diff) {

                        // if both differences match, increment count as it results in new valid arithmetic subarray
                        countArithmetic ++;
                    }

                    else {

                        // whenever differences do not match, stop inner loop
                        break;
                    }
                }

                // move to next element in nums
            }
            // output
            return countArithmetic;
        }

        public static void main(String[] args) {

            ArithmeticSlicesNestedLoops obj = new ArithmeticSlicesNestedLoops();

            Scanner scanner = new Scanner(System.in);

            System.out.println("nums length: ");
            int n = scanner.nextInt();
            int[] nums = new int[n];

            System.out.println("nums: ");
            for(int i = 0; i < n; i++) {

                nums[i] = scanner.nextInt();
            }

            int answer = obj.numberOfArithmeticSlices(nums);

            System.out.println("the number of arithmetic sub arrays of nums: " + answer);
        }

}

/*
Time Complexity = O(n*n)
Space Complexity = O(1)
*/