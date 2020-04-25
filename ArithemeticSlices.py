'''
Solution:
1.  Brute Force --> for each index, move until you have same common difference and
    start again from next index.
2.  DP-I --> Maintain an output array mentioning number of arithmetic slices possible till
    that index and if not possible => 0; also count the elements in output array.
3.  DP-II --> Same approach but instead of maintaining an entire array, just maintain two 
    variables just like fibonacci and count continuously the total possible slices.

Time Complexity:    O(N^2)      |   O(N)    |   O(N)
Space Complexity:   O(1)        |   O(N)    |   O(1)

--- Passed all testcases successfully on leetcode for all the three solutions.
'''


class ArithemeticSlices-BruteForce:
    def numberOfArithmeticSlices(self, A: List[int]) -> int:
        

        #   edge case
        if (A == None or len(A) < 3):
            return 0
        
        #   initialize count
        count = 0
        
        #   start index
        for i in range(0, len(A) - 2):
            diff = A[i + 1] - A[i]          #   common difference for current start index

            #   move till c.d. is the same else break while updating the count
            for j in range(i + 2, len(A)):
                if A[j] - A[j - 1] == diff:
                    count += 1
                else:
                    break
        
        #   return count            
        return count


class ArithemeticSlices-DP-I:
    def numberOfArithmeticSlices(self, A: List[int]) -> int:
        
        #   edge case
        if (A == None or len(A) < 3):
            return 0
        
        #   initialize count
        count = 0
        
        #   initialize output array
        output = [0 for i in range(len(A))]
        
        #   from third index
        for i in range(2, len(A)):

            #   update output index's value from 0 if diff is same
            if (A[i] - A[i - 1] == A[i - 1] - A[i - 2]):
                output[i] = 1 + output[i - 1]
            
            #   update count
            count += output[i] 
        
        #   return count
        return count

class ArithemeticSlices-DP-II:
    def numberOfArithmeticSlices(self, A: List[int]) -> int:
        
        #   edge case
        if (A == None or len(A) < 3):
            return 0
        
        #   initializations
        count = 0
        
        prev = 0
        curr = 0
        
        #   from third index
        for i in range(2, len(A)):

            #   update curr to prev + 1 if same diff
            #   else curr = 0
            #   re-assign prev to curr just like fibonacci
            if (A[i] - A[i - 1] == A[i - 1] - A[i - 2]):
                curr = 1 + prev
            else:
                curr = 0
            prev = curr
            
            #   update count
            count += curr
        
        #   return count
        return count