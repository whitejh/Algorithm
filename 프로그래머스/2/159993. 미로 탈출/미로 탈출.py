from collections import deque

def solution(maps):
    # ✅ 주어진 입력을 사용하기 좋게 전처리한다.
    n = len(maps)
    m = len(maps[0])
    maze = [list(row) for row in maps]  # String[] → char[][] 변환
    
    start = [0, 0]
    lever = [0, 0]
    exit_ = [0, 0]  # exit은 파이썬 내장함수명이라 exit_ 사용
    
    for r in range(n):
        for c in range(m):
            if maze[r][c] == 'S':
                start = [r, c]
            elif maze[r][c] == 'L':
                lever = [r, c]
            elif maze[r][c] == 'E':
                exit_ = [r, c]
    
    # ✅ 시작 지점 -> 레버까지 최단거리를 구한다.
    to_lever = bfs(maze, start, lever, n, m)
    # ✅ 경로가 없다면 -1을 반환한다.
    if to_lever == -1:
        return -1
    
    # ✅ 레버 -> 출구까지 최단거리를 구한다.
    to_exit = bfs(maze, lever, exit_, n, m)
    # ✅ 경로가 없다면 -1을 반환한다.
    if to_exit == -1:
        return -1
    
    # ✅ 두 개의 최단거리를 더한 값을 반환한다.
    return to_lever + to_exit


def bfs(maze, start, target, n, m):
    visited = [[False] * m for _ in range(n)]
    dr = [0, 0, -1, 1]
    dc = [-1, 1, 0, 0]
    queue = deque()
    
    queue.append((start[0], start[1], 0))  # 위치와 현재까지의 거리를 함께 저장
    visited[start[0]][start[1]] = True
    
    while queue:
        r, c, distance = queue.popleft()
        
        for d in range(4):
            nr = r + dr[d]
            nc = c + dc[d]
            
            if 0 <= nr < n and 0 <= nc < m and maze[nr][nc] != 'X':
                if not visited[nr][nc]:
                    if nr == target[0] and nc == target[1]:
                        return distance + 1
                    
                    queue.append((nr, nc, distance + 1))
                    visited[nr][nc] = True
    
    return -1  # 목표 지점에 도달할 수 없는 경우