
"""
If anyone is confused why the count was increased by myMap[ curr - k ] instead of just count+=1. 
It was because prefix sum can be same because of some negative values in the array. 
so our next occuring k will also pair  with those negative values also . 

consider this case A : [3 4  7    2   -3   1   4   2   1 ]  
                       preSum : [3 7 14 16 13 14 18 20 21]

you can see 14 occured twice  because of the subsequence [2 -3 1] their sum is 0. 
so When you are at the final index with value 1 . you have curr - k = 21 - 7 = 14 . 
you check for 14 it has occured twice . so you need to consider subsequences [2 -3 1 4 2 1] and [4 2 1].

"""


class Solution:
    def subarraySum(self, nums, k):
        d = {}
        n = len(nums)
        if n==0:
            return 0

        val = 0
        count = 0
        for i in range(n):
            val += nums[i]
            if val - k == 0:
                count += 1
            if d.get(val - k):
                count += d.get(val-k)
            d[val] = d.get(val, 0) + 1
        return count
        
if __name__ == '__main__':
    obj = Solution()

    nums = [1,1,1]
    k = 2
    print(obj.subarraySum(nums, k))