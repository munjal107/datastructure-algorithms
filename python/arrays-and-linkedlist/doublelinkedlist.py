class Node:
    def __init__(self, data, prev=None, next=None):
        self.data = data
        self.prev = prev
        self.next = next

class DoubleLinkedList:
    def __init__(self):
        self.head = None
    
    def push(self, data):
        node = Node(data)

        node.next = self.head
        if self.head is not None:
            self.head.prev = node
        self.head = node
        
    def append(self, data):
        node = Node(data)
        temp = self.head
        while temp.next:
            temp = temp.next
        temp.next = node
        node.prev = temp


    def show_data(self):
        temp = self.head
        while(temp):
            print(temp.data)
            temp = temp.next


if __name__ == '__main__':
    dll = DoubleLinkedList()
    dll.push(10)
    dll.push(20)
    dll.push(30)
    dll.append(40)
    dll.show_data()