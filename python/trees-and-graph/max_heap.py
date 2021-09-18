class MaxHeap:
    def __init__(self, arr):
        self.arr = arr
        self.heap_size = len(self.arr)

    def max_heapify(self, i):
        l = 2*i + 1
        r = 2*i + 2

        if l<self.heap_size and self.arr[l] > self.arr[i]:
            largest = l
        else:
            largest = i
        
        if r<self.heap_size and self.arr[r] > self.arr[largest]:
            largest = r
        
        if largest != i:
            self.arr[i], self.arr[largest] = self.arr[largest], self.arr[i]
            self.max_heapify(largest)

    def buil_max_heap(self):
        for i in range(self.heap_size//2, -1, -1):
            self.max_heapify(i)

    def heap_extract_max(self):
        if self.heap_size < 1:
            print("Error getting max")
            return None
        maximum = self.arr[0]
        self.heap_size = self.heap_size - 1
        self.arr[0] = self.arr[-1]
        self.max_heapify(0)
        return maximum
    
    def print_heap(self):
        for i in range(0, self.heap_size):
            print(self.arr[i], end = " ")
        print()
        
    # to increase the value of existing key
    def increase_key(self, i, key):
        if key < self.arr[i]:
            print("error")
            return None
        self.arr[i] = key
        while i>0 and self.arr[i//2] < self.arr[i]:
            self.arr[i], self.arr[i//2] = self.arr[i//2], self.arr[i]
            i = i//2 
        
    def insert_element(self, key):
        # array starts from 0 
       
        if self.heap_size >= len(self.arr):
            self.arr.append(-1000)
        else:
            self.arr[self.heap_size] = -1000  # ideally -infinity
        self.increase_key(self.heap_size, key)
        self.heap_size += 1
       
        # i = self.heap_size
        # self.heap_size += 1

        # while i>0 and self.arr[i//2] < self.arr[i]:
        #     self.arr[i], self.arr[i//2] = self.arr[i//2], self.arr[i]
        #     i = i//2
        
if __name__ == '__main__':
    arr = [1,5,6,8,12,14,16]
    heap = MaxHeap(arr)
    heap.buil_max_heap()
    heap.print_heap()
    # print(heap.heap_extract_max())
    heap.print_heap()
    heap.increase_key(5, 300)
    heap.print_heap()
    heap.insert_element(40)
    heap.print_heap()
