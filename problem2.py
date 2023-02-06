#time complexity:O(n)
#space complexity: O(n)
#ran on leetcode: yes
class Solution:
    def minimumTotal(self, triangle: List[List[int]]) -> int:
        L=triangle[0]
        l=[]
        for T in triangle[1:]:
            l=[100000]*len(T)
            for j in range(len(L)):
                
                for i in range(len(T)):
                    if(i==j or j+1==i):
                        if(T[i]+L[j]<l[i]):
                            l[i]=T[i]+L[j]
                        
            L=l
            #l=[]
        #print(L)
        return min(L)
