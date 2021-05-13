
"""Prints a maximum set of activities that can be done by a
single person, one at a time"""
# n --> Total number of activities
# s[]--> An array that contains start time of all activities
# f[] --> An array that contains finish time of all activities
def printMaxActivities(s,f):
    n = len(f)
    i = 0
    print(i)

    for j in range(1,n):
        if s[j] >= f[i]:
            print(j)
            i = j

if __name__ == '__main__':
    s = [1 , 3 , 0 , 5 , 8 , 5]
    f = [2 , 4 , 6 , 7 , 9 , 9]
    printMaxActivities(s , f)
