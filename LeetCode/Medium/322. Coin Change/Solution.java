class Solution {
    public int coinChange(int[] coins, int amount) {

        if(amount == 0) return 0;

        Queue<int[]> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[amount + 1];

        queue.add(new int[]{amount, 0}); // 초기 상태: 금액 amount, 동전 개수 0
        visited[amount] = true;

        while(!queue.isEmpty()) {
            int[] current = queue.poll();
            int curAmount = current[0];
            int coinCount = current[1];

            // 각 동전을 사용해 다음 금액 탐색
            for(int coin : coins) {
                int nextAmount = curAmount - coin;

                // 목표금액 0에 도달
                if(nextAmount == 0) {
                    return coinCount + 1;
                }

                // 유효한 금액이고 미방분인 경우
                if(nextAmount > 0 && !visited[nextAmount]) {
                    queue.add(new int[]{nextAmount, coinCount + 1});
                    visited[nextAmount] = true;
                }

            }
        }

        return -1; // amount를 만들 수 없는 경우
    }
}