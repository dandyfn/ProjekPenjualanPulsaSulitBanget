from collections import deque

def dfs(graph, start, goal, path=None, visited=None):
    if visited is None:
        visited = set()
    if path is None:
        path = []
    
    visited.add(start)
    path.append(start)
    
    if start == goal:
        return path
    
    for neighbor in graph[start]:
        if neighbor not in visited:
            result = dfs(graph, neighbor, goal, path.copy(), visited)
            if result:
                return result
    return None

def bfs(graph, start, goal):
    queue = deque([(start, [start])])
    visited = set()
    
    while queue:
        node, path = queue.popleft()
        if node == goal:
            return path
        if node not in visited:
            visited.add(node)
            for neighbor in graph[node]:
                if neighbor not in visited:
                    queue.append((neighbor, path + [neighbor]))
    return None

graph = {
    'S': ['A', 'B'],
    'A': ['B', 'D'],
    'B': ['C', 'A'],
    'C': ['E', 'D'],
    'D': ['A', 'C', 'F'],
    'E': ['Z'],
    'F': ['Z'],
    'Z': []
}

print("DFS Path dari S ke Z:")
print(dfs(graph, 'S', 'Z'))
print("BFS Path dari S ke Z:")
print(bfs(graph, 'S', 'Z'))
