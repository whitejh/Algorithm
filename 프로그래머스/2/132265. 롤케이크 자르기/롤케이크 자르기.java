import java.util.HashSet;

class Solution {
        public int solution(int[] topping) {

            HashSet<Integer> set = new HashSet<>();
            int[] arr1 = new int[topping.length];
            int[] arr2 = new int[topping.length];

            for (int i = 0; i < topping.length; i++) {
                set.add(topping[i]);
                arr1[i] = set.size();
            }

            set.clear(); // set 비우기

            for (int i = topping.length - 1; i >= 0; i--) {
                set.add(topping[i]);
                arr2[i] = set.size();
            }


            int answer = 0;

            for (int i = 0; i < topping.length - 1; i++) {
                if (arr1[i] == arr2[i + 1]) {
                    answer++;
                }
            }
            return answer;
        }
}