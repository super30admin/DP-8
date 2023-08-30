import java.util.Scanner;

public class ArithmeticSlicesDP {

        // Dynamic Programming - Time O(n) and Space O(n)

        public int numberOfArithmeticSlices(int[] nums) {

            int n = nums.length;

            if(n < 3) {
                return 0;
            }

            // dp array
            int[] subArrDP = new int[n];

            // arithmetic subarray count variable
            int countArithmetic = 0;

            // right to left
            for(int i = n-3; i >= 0; i--) {

                // if two consecutive pairs have the same difference
                if(nums[i+2] - nums[i+1] == nums[i+1] - nums[i]) {

                    // sub array count will be one more than that at rightward element in dp array
                    subArrDP[i] = 1 + subArrDP[i+1];
                }

                // count of arithmetic sub arrays will be sum of all non-zero elements, which indicate number of arithmetic sub arrays at that location, in dp array
                countArithmetic += subArrDP[i];
            }
            // output
            return countArithmetic;
        }

        public static void main(String[] args) {

            ArithmeticSlicesDP obj = new ArithmeticSlicesDP();

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
Space Complexity = O(n)
*/

/*
            // alternative - left to right
            for(int i = 2; i < n; i++) {

                // if two consecutive pairs have the same difference
                if(nums[i] - nums[i-1] == nums[i-1] - nums[i-2]) {

                    // sub array count will be one more than that at leftward element in dp array
                    subArrDP[i] = 1 + subArrDP[i-1];
                }

                // count of arithmetic sub arrays will be sum of all non-zero elements, which indicate number of arithmetic sub arrays at that location, in dp array
                countArithmetic += subArrDP[i];
            }
 */