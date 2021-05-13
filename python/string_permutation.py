def print_string(a):
    print(''.join(a))

def get_all_permutations(a, l, r):
    if l==r:
        print_string(a)
    
    for i in range(l, r):
        a[l], a[i] = a[i], a[l]
        get_all_permutations(a, l+1, r)
        a[l], a[i] = a[i], a[l]            # backtracking

if __name__ == '__main__':
    s = 'abc'
    s = list(s)
    get_all_permutations(s, 0, len(s))