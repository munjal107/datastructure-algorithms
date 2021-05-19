# Unsorted Continuous Subarray
# https://leetcode.com/problems/shortest-unsorted-continuous-subarray/

class Solution:            
    def findUnsortedSubarray_1(self, nums) -> int:
        start = -1
        end = -1
        prev = nums[0]
        for i in range(1, len(nums)):
            now = nums[i]
            if now < prev:
                if start==-1:
                    start = i-1
                    end = i
                else:
                    end = i
            prev = now
        # return end-start+1
        print(end-start+1) 
        print(end, start) 
    
    def findUnsortedSubarray(self, nums) -> int:
        is_same = [a==b for a,b in zip(nums, sorted(nums))]
        print(is_same)
        # return diff b/w index of first an last false + 1
        if all(is_same):
            out = 0
        else:
            out = len(nums) - is_same.index(False) - is_same[::-1].index(False)
        print(out)


if __name__ == '__main__':
     nums = [2,6,4,8,10,9,15]
    #  nums = [2,1]
     obj = Solution()
     obj.findUnsortedSubarray(nums)