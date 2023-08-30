import java.util.Scanner;

public class ArithmeticSlicesPointer {

        // Single Pointer - Time O(n) and Space O(1)
        public int numberOfArithmeticSlices(int[] nums) {

            int n = nums.length;

            if(n < 3) {
                return 0;
            }

            // pointers
            int curr = 0;

            // initialize count as zero
            int countArithmetic = 0;

            // iterate left to right
            for(int i = 2; i < n; i++) {

                // if two consecutive pairs have the same difference
                if(nums[i] - nums[i-1] == nums[i-1] - nums[i-2]) {

                    // increment current sub arrays
                    curr += 1;
                }

                else {

                    // when there is mismatch in difference, make current sub arrays zero
                    curr = 0;
                }

                // total count of sub arrays is sum of arithmetic sub arrays at each element in nums
                countArithmetic += curr;
            }

            // output
            return countArithmetic;
        }

        public static void main(String[] args) {

            ArithmeticSlicesPointer obj = new ArithmeticSlicesPointer();

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
Time Complexity = O(n)
Space Complexity = O(1)
*/