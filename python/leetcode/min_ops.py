# https://leetcode.com/problems/minimum-operations-to-reduce-x-to-zero/
"""
You are given an integer array nums and an integer x. In one operation, 
you can either remove the leftmost or the rightmost element from the array nums and subtract 
its value from x. Note that this modifies the array for future operations.

Return the minimum number of operations to reduce x to exactly 0 if it's possible, otherwise, return -1.
"""
 
class Solution:
    # solve my finding longest subarray with total = sum-x
    def minOperations(self, nums, x):
        n = len(nums)
        total = sum(nums) - x
        d = {0:0}
        prefix_sum = 0
        longest = 0
        for i in range(n):
            prefix_sum += nums[i]
            d[prefix_sum] = i
        if prefix_sum < x:
            return -1
        
        val = 0
        for i in range(n):
            val += nums[i]
            if d.get(val-total, -1) > 0:
                if val-total == 0:
                    longest = max(longest, i+1)
                else:
                    longest = max(longest, i - d.get(val-total))
        if longest==0:
            if total==0:
                return n
            else:
                return -1
        return n-longest
        

if __name__ == '__main__':
    nums = [1,1,4,2,3]
    x = 5
    obj = Solution()

    nums = [5,2,3,1,1]
    x = 5
    print(obj.minOperations(nums, x))