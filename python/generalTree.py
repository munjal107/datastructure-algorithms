class TreeNode:
    def __init__(self, data):
        self.data = data
        self.children = []
        self.parent = None
    
    def add_child(self, child):
        child.parent = self
        self.children.append(child)
    
    def get_level(self):
        level = 0
        p = self.parent
        while p:
            level+=1
            p = p.parent
        return level
    
    def print_tree(self):
        spaces = ' ' * self.get_level() * 3
        prefix = spaces + '|__' if self.parent else spaces

        print(prefix + self.data)
        if self.children:
            for child in self.children:
                child.print_tree()


def build_product_tree():
    root = TreeNode("Electronics")

    laptop = TreeNode("Laptops")
    laptop.add_child(TreeNode("Apple"))
    laptop.add_child(TreeNode("Asus"))
    laptop.add_child(TreeNode("Hp"))

    mobile = TreeNode("Cell Phone")
    mobile.add_child(TreeNode("Google Pixel"))
    mobile.add_child(TreeNode("iPhone"))
    mobile.add_child(TreeNode("Samsung"))

    tv = TreeNode("TV")
    tv.add_child(TreeNode("Sony"))
    tv.add_child(TreeNode("LG"))

    root.add_child(laptop)
    root.add_child(mobile)
    root.add_child(tv)

    print(tv.get_level())

    return root

if __name__ == '__main__':
    root = build_product_tree()
    root.print_tree()
