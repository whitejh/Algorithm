from collections import deque

def solution(maps):
    n = len(maps)
    m = len(maps[0])
    visited = [[False] * m for _ in range(n)]
    queue = deque()
    
    # ✅ BFS 탐색을 수행한다.
    queue.append((0, 0, 1))
    visited[0][0] = True
    
    dr = [0, 1, 0, -1]
    dc = [-1, 0, 1, 0]
    
    while queue:
        r, c, dist = queue.popleft()
        
        # ✅ 탐색 과정에서 목적지에 도달하면 거리를 반환한다.
        if r == n - 1 and c == m - 1:
            return dist
        
        for d in range(4):
            nr = r + dr[d]
            nc = c + dc[d]
            
            if 0 <= nr < n and 0 <= nc < m and maps[nr][nc] == 1:
                if not visited[nr][nc]:
                    visited[nr][nc] = True
                    queue.append((nr, nc, dist + 1))
    
    # ✅ 탐색 과정에서 목적지에 도달하지 못했다면 -1을 반환한다.
    return -1