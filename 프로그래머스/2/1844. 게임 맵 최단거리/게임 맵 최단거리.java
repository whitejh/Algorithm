import java.util.*;

    class Solution {

        private static final int[] rx = {0, 0, 1, -1};
        private static final int[] ry = {1, -1, 0, 0};

        private static class Node {
            int r, c;

            public Node(int r, int c) {
                this.r = r;
                this.c = c;
            }

        }

        public int solution(int[][] maps) {
            int answer = 0;

            int N = maps.length;
            int M = maps[0].length;

            ArrayDeque<Node> queue = new ArrayDeque<>();
            boolean[][] visited = new boolean[N][M]; // 정점에 대한 방문처리 배열
            int[][] dist = new int[N][M]; // 최단거리 배열

            queue.addLast(new Node(0, 0));
            visited[0][0] = true; // 방문
            dist[0][0] = 1;

            while (!queue.isEmpty()) {
                Node now = queue.pollFirst(); // 현재 위치한 정점

                for (int i = 0; i < 4; i++) { // 상하좌우 탐색
                    int nr = now.r + rx[i];
                    int nc = now.c + ry[i];

                    if (nr < 0 || nc < 0 || nr >= N || nc >= M) {
                        continue; // map 밖으로 나가는 경우, 예외처리
                    }

                    if (maps[nr][nc] == 0) // 갈 수 없는 곳 (벽)
                        continue;

                    if (!visited[nr][nc]) {
                        visited[nr][nc] = true; // 방문처리
                        queue.add(new Node(nr, nc));
                        dist[nr][nc] = dist[now.r][now.c] + 1; // 다음 정점 최단거리 = 현재 정점 최단거리+1
                    }
                }
            }

    

            return dist[N - 1][M - 1] == 0 ? -1 : dist[N - 1][M - 1];
        }

    }