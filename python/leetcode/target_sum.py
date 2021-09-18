# https://leetcode.com/problems/target-sum/ - 494
# https://www.youtube.com/watch?v=hqGa65Rp5LQ&ab_channel=TECHDOSE

class Solution:
    def get_output(self, nums, target, n, curr_sum):
        if n<0 and target == curr_sum:
            return 1
        if n < 0:
            return 0
        
        positive = self.get_output(nums, target, n-1, curr_sum + nums[n]) 
        negative = self.get_output(nums, target, n-1, curr_sum - nums[n])
        
        return positive + negative
    
    def findTargetSumWays(self, nums, target) -> int:
        n = len(nums) - 1
        curr_sum = 0
        return self.get_output(nums, target, n, curr_sum)




if __name__ == '__main__':
    obj = Solution()

    nums = [1, 1, 1, 1, 1]
    target = 3

    nums = [0,0,0,0,0,0,0,0,1]
    target = 1

    print(obj.findTargetSumWays(nums, target))