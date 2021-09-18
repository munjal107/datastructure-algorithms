from collections import defaultdict

class Graph:
    def __init__(self) -> None:
        self.graph_dict = defaultdict(list)

    def add_edge(self, s, e):
        self.graph_dict[s].append(e)
    
    def bfs(self, start):
        visited = [False for i in range(max(self.graph_dict)+1)]
        que = []

        que.append(start)
        visited[start] = True

        while que:
            curr = que.pop(0)
            print(curr)
            for node in self.graph_dict[curr]:
                if not visited[node]:
                    que.append(node)
                    visited[node] = True

if __name__ == '__main__':
    g = Graph()
    g.add_edge(0, 1)
    g.add_edge(0, 2)
    g.add_edge(1, 2)
    g.add_edge(2, 0)
    g.add_edge(2, 3)
    g.add_edge(3, 3)

    g.bfs(2)