// 413.
class Solution {
    public int numberOfArithmeticSlices(int[] A) {
        //edge
        if(A == null || A.length < 3)
        {
            return 0;
        }
        return optimalDP(A);
    }
    
    //time - O(n^2)
    //space - O(1)
    private int nestedLoops(int[] A) {
        int count = 0; //return value
        for(int i = 0; i < A.length - 2; i++) //no need to consider last 2 elements as an AP has atleast 3 elements
        {
            int initialDiff = A[i + 1] - A[i]; //x2 - x1 is calculated initially
            for(int j = i + 1; j < A.length - 1; j++)
            {
                //check if x3 - x2 = x2 - x1 -> if so x1,x2,x3 is an AP and increase count by 1
                //else break out of inner for() so the outer for starts from next i
                if(A[j + 1] - A[j] == initialDiff) 
                {
                    count++;
                }
                else
                {
                    break;
                }
            }
        }
        return count;
    }
    
    //time - O(n)
    //space - O(n)
    private int tabulation(int[] A) {
        int[] result = new int[A.length];
        result[A.length - 1] = 0; //no need to intailize explicitly
        result[A.length - 2] = 0; //last 2 elements cant form an AP - so set to 0
        int sum = 0;
        
        for(int i = A.length - 3; i >= 0; i--)
        {
            if(A[i + 1] - A[i] == A[i + 2] - A[i + 1]) //checking for x3 - x2 = x2 - x1
            {
                //A[i], A[i + 1], A[i + 2] - is an AP - at result[i] add 1 with result[i + 1] to account for this new triplet
                result[i] = 1 + result[i + 1];
                sum += result[i]; //the answer is sum of all numbers in result[]
            }
        }
        
        return sum;
    }
    
    //time - O(n)
    //space - O(1)
    private int optimalDP(int[] A) {
        int right = 0; //we only need the next element in result[] - so right tracks it
        int sum = 0;
        for(int i = A.length - 3; i >= 0; i--)
        {
            if(A[i + 1] - A[i] == A[i + 2] - A[i + 1]) //checking for x3 - x2 = x2 - x1
            {
                right = 1 + right; //number of APs at this point is 1 + val of right
                sum += right; //add to sum
            }
            else
            {
                //reset right to 0
                right = 0;
            }
        }
        return sum;
    }
}
