from collections import deque

class BinaryTree:
    def __init__(self, data):
        self.data = data
        self.left = None
        self.right = None

    def add_child(self, data):
        if data == self.data:
            print("Number already exist, cannot add it")
            return
        if data < self.data:
            # add as left child
            if self.left:
                self.left.add_child(data)
            else:
                self.left = BinaryTree(data)
        else:
            if self.right:
                self.right.add_child(data)
            else:
                self.right = BinaryTree(data)
            
    def search_element(self, data):
        if self.data == data:
            return True
        
        if data < self.data:
            if self.left:
                return self.left.search_element(data)
            else:
                return False
        if data > self.data:
            if self.right:
                return self.right.search_element(data)
            else:
                return False

    # Inorder Traversal with Recursion
    def in_order_traversal(self):
        elements = []
        
        if self.left:
            elements += self.left.in_order_traversal()
        
        elements.append(self.data)
        
        if self.right:
            elements += self.right.in_order_traversal()
        return elements

    
    # Preorder Traversal with Recursion
    def preorder_traversal(self):
        elements = []
        elements.append(self.data)
        
        if self.left:
            elements += self.left.preorder_traversal()
        
        if self.right:
            elements += self.right.preorder_traversal()
        return elements

    # Preorder Traversal with Recursion
    def preorder_traversal_non_recursive(self):
        stack = []

        if self==None:
            return
        
        stack.append(self)
        
        while stack:
            s = stack.pop()
            print(s.data, end=" ")

            if s.right:
                stack.append(s.right)
            if s.left:
                stack.append(s.left)
                # self = self.left
            
                # self = self.right
    
    def inorder_without_recursion(self):
        if self==None:
            return

        stack1 = []
        # stack2 = []

        curr = self
        while stack1 or curr!=None:
            while curr:
                stack1.append(curr)
                curr = curr.left
            
            curr = stack1.pop()
            print(curr.data, end=" ")

            curr = curr.right
        
        print()

    
    def postorder_traversal(self):
        elements = []
        
        if self.left:
            elements += self.left.postorder_traversal()
        
        if self.right:
            elements += self.right.postorder_traversal()
        
        elements.append(self.data)

        return elements

    def postorder_without_recursion(self):
        s1 = []
        s2 = []

        root = self
        s1.append(root)

        while s1:
            temp = s1.pop()
            s2.append(temp)

            if temp.left:
                s1.append(temp.left)
            if temp.right:
                s1.append(temp.right)

        while s2:
            s = s2.pop()
            print(s.data, end=" ")
        
    
    def levelorder_traversal(self):
        dq = deque()

        curr = self
        while curr:
            print(curr.data, end=" ")

            if curr.left:
                dq.appendleft(curr.left)
            if curr.right:
                dq.appendleft(curr.right)

            if len(dq)==0:
                break
            curr = dq.pop()




    
    def find_max(self):
        if self.right is None:
            return self.data
        return self.right.find_max()

    def find_min(self):
        if self.left is None:
            return self.data
        return self.left.find_min()
    
    def delete_node(self, val):
        if val < self.data:
            if self.left:
                self.left = self.left.delete_node(val)
        elif val > self.data:
            if self.right:
                self.right = self.right.delete_node(val)
        else:
            if self.left is None and self.right is None:
                return None
            elif self.left is None:
                return self.right
            elif self.right is None:
                return self.left

            min_val = self.right.find_min(val)
            self.data = min_val
            self.right = self.right.delete_node(min_val)

        return self

    


def build_bst(numbers):
    root = BinaryTree(numbers[0])

    for data in numbers[1:]:
        root.add_child(data)

    return root

if __name__ == '__main__':
    numbers = [12,10,14,2,1,5,3,89,56,24]

    root = build_bst(numbers)

    print(root.in_order_traversal())

    print(root.search_element(14))
    print(root.search_element(142))
    print(root.find_max())

    # root.delete_node(56)
    print("\nInorder traverlsal with Recursion")
    print(root.in_order_traversal())
    print("\nInorder traverlsal without Recursion")
    root.inorder_without_recursion()
    print("\nPreorder traverlsal with Recursion")
    print(root.preorder_traversal())
    print("\nPreorder traverlsal without Recursion")
    root.preorder_traversal_non_recursive()

    print("\nPostorder traverlsal with Recursion")
    print(root.postorder_traversal())
    print("\nPostorder traverlsal without Recursion")
    root.postorder_without_recursion()
    print("\n\nLevel Order Traversal")
    root.levelorder_traversal()




