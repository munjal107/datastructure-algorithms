

s1 = "15:15:00"
s2 = "15:15:12"

s1 = "00:00:00"
s2 = "00:02:50"

l1 = list(map(int, s1.split(":")))
l2 = list(map(int, s2.split(":")))
print(l1)
print(set(''.join([str(i) for i in l1])))

h1 = l1[0]
m1 = l1[1]
s1 = l1[2]

h2 = l2[0]
m2 = l2[1]
s2 = l2[2]

def is_interesting(a,b,c):
    if a<10:
        a=f"0{a}"
    if b<10:
        b=f"0{b}"
    if c<10:
        c=f"0{c}"
    time = f"{a}:{b}:{c}"
    # print(time)

    if len(set(time.replace(':', ''))) <= 2:
            print("Success.",time)
            return 1
    return 0

count = 0
for i in range(h1, h2+1):
    if i==h1 and i==h2:
        for j in range(m1, m2+1):
            if j==m1 and j==m2:
                for k in range(s1, s2+1):
                    count += is_interesting(i, j, k)
            elif j == m1:
                for k in range(s1,61):
                    count += is_interesting(i, j, k)
            elif j==m2:
                for k in range(0, s2+1):
                    count += is_interesting(i, j, k)
            else:
                for k in range(0, 61):
                    count += is_interesting(i, j, k)
        
    elif i==h1:
        for j in range(m1, 61):
            if j == m1:
                for k in range(s1,61):
                    count += is_interesting(i, j, k)
            else:
                for k in range(0, 61):
                    count += is_interesting(i, j, k)
    elif i==h2:
        for j in range(0,m2):
            if j==m2:
                for k in range(0,s2+1):
                    count += is_interesting(i,j,k)
            else:
                for k in range(0, 61):
                    count += is_interesting(i,j,k)

print("Count->", count)


# for i in range()