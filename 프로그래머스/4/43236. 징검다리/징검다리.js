function solution(distance, rocks, n) {
  let answer = 0;
  rocks = [0, ...rocks.sort((a, b) => a - b), distance];

  let start = 0;
  let end = rocks[rocks.length - 1];

  while (start <= end) {
    let mid = Math.floor((start + end) / 2);
    let count = 0, now = 0;

    for (let i = 1; i < rocks.length; i++) { // 출발 지점부터 돌간 사이 간격 확인
      if (mid > rocks[i] - now) {
        count++;
      } else
        now = rocks[i];
    }

    if (count > n) { // 돌을 더 많이 제거했다면
      end = mid - 1;
    } else {        // 돌을 같거나 덜 제거했다면
      start = mid + 1;
    }
  }
  answer = end;

  return answer;
}