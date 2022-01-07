class Node:
    def __init__(self, data):
        self.data = data
        self.next = None


class LinkedList:
    def __init__(self):
        self.head = None
    
    def show_data(self):
        temp = self.head
        print("\nPrinting data...")
        while temp:
            print(temp.data)
            temp = temp.next

    def push(self, data):
        obj = Node(data)
        obj.next = self.head
        self.head = obj

    def append(self, data):
        obj = Node(data)
        temp = self.head
        while temp.next:
            temp = temp.next
        temp.next = obj

    def remove_at(self, index):
        if index==0:
            self.head = self.head.next
        else:
            count=0
            temp = self.head
            while temp:
                if count==index-1:
                    temp.next = temp.next.next
                    break
                temp = temp.next
                count+=1
    
    def insert_at(self, index, data):
        if index==0:
            self.push(data)

        count = 0
        temp = self.head
        while temp:
            if count==index-1:
                node = Node(data)
                node.next = temp.next
                temp.next = node
                break
            temp = temp.next
            count+=1
    
    def remove_by_key(self, key):
        temp = self.head

        if temp is not None:
            if key==temp.data:
                self.head = temp.next
                temp = None
                return
            else:
                while(temp):
                    if temp.next.data == key:
                        # print('Found')
                        temp.next = temp.next.next
                        break
                    temp = temp.next

if __name__ == '__main__':
    ll = LinkedList()
    #ll.show_data()
    ll.push(10)
    ll.push(20)
    ll.push(30)
    ll.show_data()
    ll.append(40)
    # ll.show_data()
    # ll.remove_at(2)
    # ll.show_data()
    ll.insert_at(2,99)
    ll.show_data()
    ll.remove_by_key(99)
    ll.show_data()
