import java.util.*;

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
      // 1. 숫자별 나온 숫자 카운팅
        Map<Integer, Integer> freqMap = new HashMap<>();
        for(int num:nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        // 2. 빈도가 높은 k개 요소만 남기고 버리기 - 우선 순위 큐
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(Comparator.comparingInt(freqMap::get));

        for(int key : freqMap.keySet()) {
            minHeap.add(key);
            if(minHeap.size() > k) {
                minHeap.poll();
            }
        }

        // 3. 출력
        int[] result = new int[k];
        for (int i = k-1; i >=0; i--) {
            result[i] = minHeap.poll();
        }

        return result;
    }
}