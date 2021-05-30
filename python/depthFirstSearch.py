from collections import defaultdict

class Graph:
    def __init__(self) -> None:
        self.graph_dict = defaultdict(list)

    def add_edge(self, s, e):
        self.graph_dict[s].append(e)
    
    def dfs_util(self, start, visited):
        visited.add(start)
        print(start, end=" ")

        for node in self.graph_dict[start]:
            if node not in visited:
                self.dfs_util(node, visited)

    def dfs(self, start):
        visited = set()

        self.dfs_util(start, visited)



if __name__ == '__main__':
    g = Graph()
    g.add_edge('A', 'C')
    g.add_edge('A', 'B')
    
    g.add_edge('B', 'D')
    g.add_edge('D', 'E')
    g.add_edge('D', 'F')
    g.add_edge('E', 'C')
    g.add_edge('E', 'F')
    g.add_edge('E', 'B')

    g.dfs('A')