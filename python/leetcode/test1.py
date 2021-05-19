import re

def func1():
    s = 'faacdfasfa'
    pat = re.compile(r'cdf')
    m = re.search(pat,s)

    # print(m.start())
    print(m)
    print(s[m.start():m.end()])



if __name__ == '__main__':
    func1()