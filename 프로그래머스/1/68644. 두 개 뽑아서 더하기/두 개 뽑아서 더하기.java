import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {
    public int[] solution(int[] numbers) {
        List<Integer> answerList = new ArrayList<>();

        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                answerList.add(numbers[i] + numbers[j]);
            }
        }

        Set<Integer> answerSet = new HashSet<>(answerList);
        int[] answer = new int[answerSet.size()];
        int index = 0;
        
        for (int num : answerSet) {
            answer[index++] = num;
        }
        Arrays.sort(answer);

        return answer;
    }
}