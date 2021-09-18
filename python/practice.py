class Node:
    def __init__(self, data):
        self.data = data
        self.next = None
    

class LinkedList:
    def __init__(self):
        self.head = None

    def push(self, data):
        temp = Node(data)
        temp.next = self.head
        temp = self.head

    def append(self, data):
        node = Node(data)
        # print("hell", data)
        temp = self.head
        if temp:
            while temp.next:
                temp = temp.next
            temp.next = node
        else:
            self.head = node 

    def show_data(self):
        print("showing data...")
        temp = self.head
        while temp:
            print(temp.data)
            temp = temp.next

if __name__ == "__main__":
    llist = LinkedList()
    llist.push(2)
    llist.push(3)
    llist.push(4)
    llist.push(5)

    llist.show_data()

    llist.push(100)
    llist.show_data()

   # llist.append(101)
    llist.show_data()

    #llist.deleteNode(3)
    llist.show_data()
