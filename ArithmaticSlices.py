'''
Time Complexity --> O(n)
Space Complexity --> O(1)
'''
class Solution:
    def numberOfArithmeticSlices(self, nums: List[int]) -> int:
        # #brute Force
        # count = 0
        # for i in range(len(nums)-1):
        #     for j in range(i+1, len(nums)-1):
        #         #print(nums[j]-nums[j-1])
        #         if nums[j]-nums[j-1] == nums[j+1]-nums[j]:
        #             count+=1
        #         else:
        #             break
                
        # return count
        prev = 0
        tot = 0
        for i in range(len(nums)-3, -1, -1):
            if nums[i+2]-nums[i+1] == nums[i+1]-nums[i]:
                prev+=1
                tot+=prev
            else:
                prev = 0
        return(tot)

                
