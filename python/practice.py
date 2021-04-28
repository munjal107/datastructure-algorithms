class BinarySearchTree:
    def __init__(self, data):
        self.data = data
        self.left = None
        self.right = None
    
    def add_child(self, data):
        if self.data == data:
            return
        if data < self.data:
            if self.left:
                 self.left.add_child(data)
            else:
                self.left = BinarySearchTree(data)
        else:
            if self.right:
                self.right.add_child(data)
            else:
                self.right = BinarySearchTree(data)
    
    def in_order_traversal(self):
        if self.left:
            self.left.in_order_traversal()
        
        print(self.data)

        if self.right:
            self.right.in_order_traversal()

    def in_order_traversal1(self):
        elements = []
        
        if self.left:
            elements += self.left.in_order_traversal1()
        
        elements.append(self.data)
        
        if self.right:
            elements += self.right.in_order_traversal1()
        return elements

def build_tree(numbers):
    root = BinarySearchTree(numbers[0])
    for num in numbers[1:]:
        root.add_child(num)

    return root

   
if __name__ == '__main__':
    numbers = [3,4,2,12,24,20,34,13,15,76]
    # numbers = [12,10,14,2,1,5,3,89,56,24]

    root = build_tree(numbers)
    root.in_order_traversal()
    # print(root.in_order_traversal1())
