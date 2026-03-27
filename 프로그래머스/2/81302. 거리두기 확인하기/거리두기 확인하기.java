import java.util.ArrayDeque;
import java.util.Queue;

class Solution {

	private static final int[] dr = {0, 1, 0, -1};
	private static final int[] dc = {1, 0, -1, 0};

	public int[] solution(String[][] places) {
		int[] answer = new int[5];
		for (int i = 0; i < 5; i++) {
			answer[i] = check(places[i]) ? 1 : 0;
		}

		return answer;
	}

	private boolean check(String[] place) {
		for (int r = 0; r < 5; r++) {
			for (int c = 0; c < 5; c++) {
				if (place[r].charAt(c) == 'P') {
					if (!bfs(r, c, place))
						return false;
				}
			}
		}
		return true;
	}

	private boolean bfs(int sr, int sc, String[] place) {
		boolean[][] visited = new boolean[5][5];
		Queue<int[]> queue = new ArrayDeque<>();
		queue.add(new int[] {sr, sc, 0}); // 행, 열, 거리(시작점 거리를 0으로 초기화)
		visited[sr][sc] = true;

		while (!queue.isEmpty()) {
			int[] cur = queue.poll(); // 현재 노드의 좌표와 거리 가져오기 (큐의 맨 앞 요소를 꺼냄)
			int r = cur[0];
			int c = cur[1];
			int dist = cur[2];

			for (int i = 0; i < 4; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];
				int nextDist = dist + 1;

				// 범위, 파티션, 방문, 거리 체크
				if (nr < 0 || nr >= 5 || nc < 0 || nc >= 5) continue;
				if (place[nr].charAt(nc) == 'X' || visited[nr][nc]) continue;
				if (nextDist > 2) continue;

				// 거리 2 이내에 다른 응시자 발견
				if(place[nr].charAt(nc) == 'P') {
					return false;
				}

				visited[nr][nc] = true;
				queue.add(new int[]{nr, nc, nextDist});
			}
		}
		return true;

	}
}