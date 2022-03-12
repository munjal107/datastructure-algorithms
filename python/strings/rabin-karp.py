def string_search(s, pat):
    m = len(pat)
    n = len(s)
    # total characters
    d = 26
    # prime no. q
    q = 5381
    h = 1

    for _ in range(m-1):
        h = (h*d)%q
    
    pat_hash=0
    str_hash=0
    for i in range(m):
        pat_hash = (d*pat_hash+ord(pat[i]))%q
        str_hash = (d*str_hash+ord(pat[i]))%q
    
    res = []
    for i in range(n-m+1):
        if pat_hash==str_hash:
            # print("index",i)
            j=0
            while j<m:
                if s[i+j]!=pat[j]:
                    break
                j+=1
            if j==m:
                res.append(i)
        
        # create new hash for next char
        if i<n-m:
            str_hash = ( d*(str_hash-(ord(s[i])*h)) + ord(s[i+m]))%q
            if str_hash<0:
                str_hash = str_hash+q
    
    return res
    



if __name__=="__main__":
    s="AABAACAADAABAABA"
    pat="AABA"
    res = string_search(s, pat)
    print(res)