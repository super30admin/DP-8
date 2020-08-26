class Solution:
        
    """
        
        Name : Shahreen Shahjahan Psyche
        Time : O(N)
        Space: constantSpace : O(1)
               dynammicSolution : O(N)
        
        Passed All Test Cases in LC : Yes
        
        Approach : 1-D Array DP Solution
                   # Initilize a dp array of sizee of length of A
                   # Now, start travarsing the array
                   # whenever we encounter an arithmatic sub array, start the inner loop
                   # add to the global total
                   # Finally, return the total
        
       
        
    """
    
    # With O(N) space
    def dynamicSolution(self, A):
        
        track = [0 for i in range(len(A)-1)]
        j = 1
        while j < len(A)-1:
            if A[j] - A[j-1] == A[j+1] - A[j]:
                count = 0
                while j < len(A)-1 and A[j] - A[j-1] == A[j+1] - A[j]:
                    count += 1
                    track[j] = track[j-1] + count
                    j += 1
                if j != len(A)-1:
                    track[j] = track[j-1]
            else:
                track[j] = track[j-1]
            j += 1
        return track[len(track)-1]
    
    
    # With constant space
    def constantSpaceDP(self, A):

        total = 0
        j = 1
        while j < len(A)-1:
            count = 0
            while j < len(A)-1 and A[j] - A[j-1] == A[j+1] - A[j]:
                count += 1
                total += count
                j += 1
            j += 1
                
        return total
            

    def numberOfArithmeticSlices(self, A: List[int]) -> int:
        
        if not A or len(A)<3:
            return 0
        
        # total = self.constantSpaceDP(A)
        total = self.dynamicSolution(A)
                
        return total
            
            
            
            
        
        
