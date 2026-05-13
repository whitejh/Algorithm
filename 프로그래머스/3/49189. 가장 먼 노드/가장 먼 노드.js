function solution(n, edge) {
  let node = Array.from({ length: n + 1 }, () => []); // node에는 연결된 간선을 표시
  // length가 n+1인 배열을 만들고, 그 배열의 값들을 빈 배열로 초기화
  let visited = new Array(n + 1).fill(0); // 방문여부를 체크하는 배열 (노드까지의 간선수를 카운트 해주는 역할), 0으로 채워진 n+1 길이의 배열
  let queue = [1]; // 1부터 시작하니 큐에 1 넣어줌

  // 양방향 간선(edge(int[][]))
  edge.forEach(x => {
    node[x[0]].push(x[1]);
    node[x[1]].push(x[0]);
  });

  // 1 방문,   // 1번 노드를 기준으로 최단거리를 구하기 때문에 visited[1]의 값을 1로 바꿔줌
  visited[1] = 1;

  // 나머지 방문 (BFS)
  while (queue.length !== 0) { // 큐가 빌 때까지 (큐가 비었다 = 모든 노드들 탐색 끝남)
    let index = queue.shift(); // 큐에서 탐색을 시작할 기준이 될 노드를 꺼낸다
    // console.log(index); // 1 3 2 6 4 5
    node[index].forEach(x => {
      if (!visited[x]) {
        queue.push(x); // 큐에 들어있는 노드 번호를 shift해주고, 해당 노드와 연결된 노드들을 큐에 집어 넣는다
        visited[x] = visited[index] + 1; 
      }
    })
    //console.log(node[index]);
  }

  const max = Math.max(...visited); // 가장 많은 간선의 개수
  return visited.filter(x => x === max).length; // 가장 먼거리들만 남겨둔 배열의 길이 값 리턴, [3,3,3]의 길이 = 3
}