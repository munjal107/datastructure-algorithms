

def func1():
    l = [[-1, 0, 1], [-1, 2, -1], [0, 1, -1]]
    t = []
    for k in l:
        t.append(sorted(k))
    print(sorted(t))
    a = list(map(list, set(tuple(i) for i in t)))
    print(a)

def func2():
    s = "pwwkew"
    count = [1] # so that max func. dont throw error
    for i,ch in enumerate(s):
        max_count = max(count)
        temp_count = 1
        d = []
        d.append(ch)
        if len(s)-i+1 < max_count:
            break
        for c in s[i+1:]:
            if c in d:
                break
            else:
                d.append(c)
                temp_count += 1
        count.append(temp_count)

    print(max(count))

def func3():
    s = "pwwkew"
    start = maxLength = 0
    usedChar = {}
    
    for i in range(len(s)):
        if s[i] in usedChar and start <= usedChar[s[i]]:
            start = usedChar[s[i]] + 1
        else:
            maxLength = max(maxLength, i - start + 1)
        usedChar[s[i]] = i

    print(usedChar)
    print(maxLength)

# prob 88
def func4():
    nums1 = [1,2,3,0,0,0]
    m = 3
    nums2 = [3,5,6]
    n = 3

    while (m>0 and n>0):
        if nums1[m-1] > nums2[n-1]:
            nums1[m+n-1] = nums1[m-1]
            m-=1
        else:
            nums1[m+n-1] = nums2[n-1]
            n-=1

    print(nums1)

# prob-7
# https://leetcode.com/problems/reverse-integer/submissions/
def func5():
    x = -123
    is_neg = x<0
    y = abs(x)
    c=0
    while y>0:
        m = y%10
        c = c*10+m
        y=y//10
    if is_neg:
        c = c*-1
    print(c)
    if -2**31 <= c <2**31:
            print('True')


if __name__ == '__main__':
    func5()
    