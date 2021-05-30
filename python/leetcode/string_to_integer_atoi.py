import re

class Solution:
    def myAtoi_1(self, s):
        s = s.strip()
        if len(s) <= 0:
            return 0
        if s[0] == '-' or s[0] == '+':
            is_sign = True
            sign = s[0]
            start = 1
        else:
            is_sign = False
            start = 0
        
        n = len(s)
        d = 0
        nums = []
        for char in s[start:]:
            if re.search("\d", char):
                d += 1
                nums.append(char)
            else:
                break
        d -= 1
        sum = 0
        # print(d, nums)
        for num in nums:
            sum = (10**d) * int(num) + sum
            d -= 1
        if is_sign:
            if s[0] == '-':
                sum = sum * -1
        if sum > 2**31 - 1:
            sum = 2**31 - 1
        if sum < -2**31:
            sum = -2**31

        print(sum)
    
    def myAtoi(self, s):
        s = s.strip()
        index = 0
        if len(s) <= 0:
            return 0
        
        if s[0] == '+' or s[0] == '-':
            index = 1
        
        total = 0
        for char in s[index:]:
            if re.search("\d", char):
                total = total * 10 + int(char)
            else:
                break
        if index == 1 and s[0]=='-':
            total = total * -1

        if total > 2**31 - 1:
            total = 2**31 - 1
        if total < -2**31:
            total = -2**31

        print(total)

        
if __name__ == '__main__':
    obj = Solution()
    obj.myAtoi("4193 with words")
    obj.myAtoi("   -42")
