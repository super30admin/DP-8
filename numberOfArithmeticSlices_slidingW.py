"""
TC=O(N^2)
sc=O(1)

"""
class Solution:
    def numberOfArithmeticSlices(self, A: List[int]) -> int:
        if not A or len(A)<3:
            return 0
        count=0
        for i in range(len(A)-2):#since 3 elements and 2 consecutive diff need to be same stopp iterating i before 2 elements 
            diff=A[i+1]-A[i] #find difference between current and next no 
            
            for j in range(i+1,len(A)-1): #j should be from i+1 and len(A)-1 because comaprison is cone between i and i+1
                if A[j+1]-A[j]==diff:#this is calculated again and again 
                    count+=1
                else:
                    break
        return count
        
        
        
        