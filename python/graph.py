class Graph:
    def __init__(self, edges):
        self.edges = edges
        self.graph_dict = {}
        for start, end in edges:
            if start in self.graph_dict:
                self.graph_dict[start].append(end)
            else:
                self.graph_dict[start] = [end]
            
        #print(self.graph_dict)
    
    def get_path(self, start, end, path = []):
        path = path + [start]

        if start == end:
            return [path]
        
        if start not in self.graph_dict:
            return []

        paths = []
        for node in self.graph_dict[start]:
            if node not in path:
                new_paths = self.get_path(node, end, path)
                for p in new_paths:
                    paths.append(p)
        
        return paths
        
    def get_shortest_path(self, start, end, path=[]):
        path = path + [start]

        if start == end:
            return path
        if start not in self.graph_dict:
            return []
        
        shortest_path  = None
        for node in self.graph_dict[start]:
            if node not in path:
                new_paths = self.get_shortest_path(node, end, path)
            if new_paths:
                if shortest_path is None or len(shortest_path) > len(new_paths):
                    shortest_path = new_paths
        return shortest_path


if __name__ == '__main__':
    routes = [
        ("Mumbai", "Paris"),
        ("Mumbai", "Dubai"),
        ("Paris", "Dubai"),
        ("Paris", "New York"),
        ("Dubai", "New York"),
        ("New York", "Toronto"),
        # ("Mumbai", "New York")

    ]

    route_graph = Graph(routes)

    s = "Mumbai"
    e = "New York"
    ap = route_graph.get_path(s, e)
    print(ap)
   #print("shortest path :", route_graph.get_shortest_path(s, e))