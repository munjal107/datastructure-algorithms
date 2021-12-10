class HashTable:
    def __init__(self):
        self.MAX = 10
        self.arr = [None for i in range(self.MAX)]

    def get_hash(self, key_string):
        sum=0
        for char in key_string:
            sum += ord(char)
        return sum % self.MAX
    
    def __getitem__(self, key):
        hash = self.get_hash(key)
        return self.arr[hash]
    
    def __setitem__(self, key, val):
        hash = self.get_hash(key)
        self.arr[hash] = val

# Class to handle Hash collision - chaining
class HashCollision:
    def __init__(self):
        self.MAX = 10
        self.arr = [[] for i in range(self.MAX)]

    def get_hash(self, key_string):
        sum=0
        for char in key_string:
            sum += ord(char)
        return sum % self.MAX
    
    def __getitem__(self, key):
        hash = self.get_hash(key)
        for element in self.arr[hash]:
            if element[0]==key:
                return element[1]
    
    def __setitem__(self, key, val):
        hash = self.get_hash(key)
        found = False
        for idx, element in enumerate(self.arr[hash]):
            if element[0]==key:
                self.arr[hash][idx] = (key, val)
                found = True
        if not found:
            self.arr[hash].append((key, val))



def fun1():
    h = HashTable()
    # since we have use __setitem__ we can write
    # like below instead of h.setitem(k,v)
    h['march 6'] = 10
    h['march 9'] = 20
    print(h['march 6'])
    print(h['march 9'])
    print(h.arr)

def fun2():
    h = HashCollision()
    h['march 6'] = 10
    h['march 9'] = 20
    h['march 17'] = 30

    print(h['march 6'])
    print(h['march 17'])
    print(h.arr)


if __name__ == '__main__':
    fun2()