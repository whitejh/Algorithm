import java.util.ArrayDeque;

class Solution {
 
    private static final int HIT = 1;
    private static final int MISS = 5;

    public int solution(int cacheSize, String[] cities) {
        int answer = 0;

        ArrayDeque<String> cache = new ArrayDeque<>();
        
        if (cacheSize == 0)
            return cities.length * 5;

        for (String city : cities) { // O(N) N = 100,000
            city = city.toUpperCase(); //O(N) N = 20

            if (cache.contains(city)) { // O(N * M) 30 * 20 * 100,000
                answer += HIT;
                cache.remove(city);
                cache.offer(city);
            } else {
                answer += MISS;
                cache.offer(city);
                if (cache.size() > cacheSize)
                    cache.poll();
            }
        }

        return answer;
    }
}