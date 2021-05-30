# prob-5
# https://leetcode.com/problems/longest-palindromic-substring/


def longestPalindrome1(s: str) -> str:
    s = 'cbababd'
    s='cbaabd'
    s='abb'
    len_of_str = len(s)

    if len_of_str==2:
        if s[0]==s[1]:
            output=s
        else:
            output=s[0]
    else:
        if len_of_str%2==0:
            i=-1
            stack = s[: (len_of_str//2)]
            mid = len_of_str//2
            temp_r = left = (len_of_str//2)
            is_odd = False
        else:
            stack = s[: (len_of_str//2)]
            i=-1
            mid = len_of_str//2 + 1
            temp_r = left = len_of_str//2
            is_odd = True

        for ch in s[mid:]:
            if ch==stack[i]:
                i-=1
                left-=1
            else:
                break
        print(i)
        i = abs(i)-1
        if is_odd:
            right = temp_r+i+1
        else:
            right = temp_r+i
        output = s[left:right]
    print(output)


def isPalindrome(s):
    return s == s[::-1]

def longestPalindrome2(s: str) -> str:
    s = 'cbababd'
    s='cbaabd'
    s="oyxshtfvhudhhsnstwfxhdlhieqwaujxubhymmmuhpzjmjrwlapdlrnmzxprwkykmhcjozlivieafymrnixadlyomwvmoextitacntoopnldbhhzqsxkatwjmyzrvkhrwltapztwverlrnbownqhhdmuzwzynfdzdzgcjjxbwmziemkxhgsppdwureforlajyhucagmnxngmcxtzwrevgzdwzpbuxgkzdablbgzmjhnuvdaeonsotcwmazcpziuwjzgweygfvlqajzgujxsskaaduicsjyevqiwivrfvntmmbadqawskzrszhekrbdgdmfvszsypxhsaqeenogzegehuxifpkusuukrddouzshamsjukhagruhmwvrrrrvwmhurgahkujsmahszuoddrkuusukpfixuhegezgoneeqashxpyszsvfmdgdbrkehzsrzkswaqdabmmtnvfrviwiqveyjsciudaakssxjugzjaqlvfgyewgzjwuizpczamwctosnoeadvunhjmzgblbadzkgxubpzwdzgverwztxcmgnxnmgacuhyjalroferuwdppsghxkmeizmwbxjjcgzdzdfnyzwzumdhhqnwobnrlrevwtzpatlwrhkvrzymjwtakxsqzhhbdlnpootncatitxeomvwmoyldaxinrmyfaeivilzojchmkykwrpxzmnrldpalwrjmjzphummmyhbuxjuawqeihldhxfwtsnshhduhvfthsxyo"  
    max_len = -1
    output = ""
    for i in range(len(s)):
        for j in range(len(s), i, -1):
            #print('j:',j,i)
            substr = s[i:j+1]
            #print('sub',substr)
            is_pal = isPalindrome(substr)
            if is_pal:
                if len(substr) > max_len:
                    output = substr
                    max_len = len(substr)
                    break 
    print(output)

"""
Approach 4: Expand Around Center
In fact, we could solve it in O(n^2)O(n2) time using only constant space.

We observe that a palindrome mirrors around its center. Therefore, a palindrome can be
expanded from its center, and there are only 2n - 12n−1 such centers.

You might be asking why there are 2n - 12n−1 but not nn centers? The reason is the center of a palindrome
can be in between two letters. Such palindromes have even number of letters (such as "abba") and its center 
are between the two 'b's.
"""
def expand_around_center(s, left, right):
    l,r = left, right
    while l>=0 and r<len(s) and s[l]==s[r]:
        l-=1
        r+=1
    return r-l-1

def longestPalindrome3(s):
    s='babab'
    if len(s)<2:
        return s
    n = len(s)
    start = end = 0
    for i in range(n):
        l1 = expand_around_center(s,i,i)
        l2 = expand_around_center(s,i,i+1)
        max_l = max(l1, l2)
        if max_l > (end-start):
            start = i - (max_l-1)//2
            end = i + max_l//2
    print(s[start:end+1])



if __name__ == '__main__':
    longestPalindrome3('h')