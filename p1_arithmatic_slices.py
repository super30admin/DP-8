class Solution:
    def numberOfArithmeticSlices(self, nums: List[int]) -> int:
        """
            Time Complexity: O(n)
            Space Complexity: O(1)
            Approach:
                - we loop through the list 
                - For eg: we have [1, 2, 3, 4, 5, 13, 6, 18, 20, 22, 6, 3]
                - we check the diff between next two element is same as curr element and next element
                - if yes we add +1 to the res
                - Now iteration 2 
                    - We check the next two difference if it's same then 
                    we add +2 to the result because 
                        - it takes into account two arithmatic slices
                            - [1, 2, 3, 4] and [2, 3, 4]
                - For iteration 3
                    - If the difference is same
                    we add +3 because it takes into account the following slices
                        - [1, 2, 3, 4, 5], [2, 3, 4, 5] and [3, 4, 5]
                - If the next difference doesn't match 
                    - we make the curr back to zero and move to next iteration
        """
        count = 0
        curr = 0
        for i in range(0, len(nums)-2):
            if nums[i+1] - nums[i] == nums[i+2] - nums[i+1]:
                curr+=1
                count+=curr
            else:
                curr =0
        # #Brute Force 
        # count = 0
        # for i in range(0, len(nums)-2):
        #     diff1 = nums[i+1] - nums[i]
        #     for j in range(i+2, len(nums)):
        #         diff2 = nums[j] - nums[j-1]
        #         if diff2 == diff1:
        #             count+=1
        #         else:
        #             break
        return count