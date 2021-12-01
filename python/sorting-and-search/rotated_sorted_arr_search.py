class Solution:
    def search(self, nums, target) -> int:
        l = 0
        r = len(nums) - 1
        while l<=r:
            m = (l+r)//2
            if target == nums[m]:
                return m
            
            if nums[m] >= nums[l]:
                if target > nums[m] or target < nums[l]:
                    l = m + 1
                else:
                    r= m - 1
            else:
                if target < nums[m] or target > nums[r]:
                    r = m - 1
                else:
                    l = m + 1
        return -1

# https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/submissions/    - 153
    def findMin(self, nums: List[int]) -> int:
        l = 1
        r = len(nums) - 1
        min_num = nums[0]
        while l<=r:
            m = (l+r)//2
            if nums[m] < min_num:
                min_num = nums[m]
            if nums[m] >= nums[l]:
                if min_num > nums[r]:
                    l = m+1
                else:
                    r = m - 1
            else:
                if min_num < nums[l]:
                    r = m-1
                else:
                    l = m + 1
        return min_num
        
                    

if __name__ == "__main__":
    nums = [4,5,6,7,0,1,2]
    s = 0
    print(Solution().search(nums,s))