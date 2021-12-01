class Solution:
    def firstMissingPositive(self, nums) -> int:
        total = 0
        min_num = -1 
        max_num = max(nums)
        for n in nums:
            if n > 0:
                total += n
                if min_num == -1:
                    min_num = n
                else:
                    if min_num > n:
                        min_num = n
        print(min_num, max_num, total)
        missing_num = (max_num*(max_num+1)//2) - (total + (min_num*(min_num-1)//2))  
        return missing_num

    def firstMissingPositive1(self, nums):
        nums.append(0)
        n = len(nums)
        for i in range(len(nums)): #delete those useless elements
            if nums[i]<0 or nums[i]>=n:
                nums[i]=0
        
        print("nums-",nums)
        for i in range(len(nums)): #use the index as the hash to record the frequency of each number
            nums[nums[i]%n]+=n
        print("nums:", nums)
        
        for i in range(1,len(nums)):
            if nums[i]/n==0:
                return i
        return n


if __name__ == "__main__":
    nums = [1,2,0]
    nums = [3,4,-1,1]
    # nums = [7,8,9,11,12]
    output = Solution().firstMissingPositive1(nums)
    print("out",output)