class Node:
    def __init__(self, data):
        self.data = data
        self.next = None

class LinkedList:
    def __init__(self):
        self.head = None
    
    def show_data(self):
        print("\nPrinting Data...")
        temp = self.head
        while(temp):
            print(temp.data)
            temp = temp.next
    
    def push(self, new_data):
        temp = Node(new_data)
        temp.next = self.head
        self.head = temp

    def append(self, new_data):
        obj1 = Node(new_data)
        temp = self.head
        while(temp.next):
            temp = temp.next
        temp.next = obj1
    
    def deleteNode(self, key):
        temp = self.head

        if temp is not None:
            if temp.data == key:
                self.head = temp.next
                temp = None
                return
        
        while temp is not None:
            if temp.data == key:
                break
            prev = temp
            temp = temp.next
        if temp == None:
            return

        prev.next = temp.next
        temp = None

if __name__ == '__main__':
    llist = LinkedList()

    llist.head = Node(2)

    obj1 = Node(3)
    obj2 = Node(4)

    llist.head.next = obj1
    obj1.next = obj2

    llist.show_data()

    llist.push(100)
    llist.show_data()

    llist.append(101)
    llist.show_data()

    llist.deleteNode(3)
    llist.show_data()








    