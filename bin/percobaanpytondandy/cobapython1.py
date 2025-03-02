from collections import deque

def dfs(graph, start, visited=None):
    if visited is None:
        visited = set()
    visited.add(start)
    print(start, end=' ')
    for neighbor in graph[start]:
        if neighbor not in visited:
            dfs(graph, neighbor, visited)
    return visited

def bfs(graph, start):
    visited = set()
    queue = deque([start])
    while queue:
        node = queue.popleft()
        if node not in visited:
            print(node, end=' ')
            visited.add(node)
            queue.extend(neighbor for neighbor in graph[node] if neighbor not in visited)

graph = {
    'A': ['D', 'B'],
    'B': ['A', 'E', 'C'],
    'C': ['B', 'F', 'L'],
    'D': ['A', 'E', 'H'],
    'E': ['B', 'D', 'I'],
    'F': ['C', 'G'],
    'G': ['F', 'J'],
    'H': ['D', 'I', 'M'],
    'I': ['E', 'H', 'J'],
    'J': ['I', 'G', 'K'],
    'K': ['J', 'M'],
    'L': ['C'],
    'M': ['H', 'K']
}

print("DFS Traversal dari K:")
dfs(graph, 'K')
print("\nBFS Traversal dari K:")
bfs(graph, 'K')
