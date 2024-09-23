class Solution {
    public int solution(String s) {
        String[] numbers = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        String answer = s;

        for (int i = 0; i < numbers.length; i++) {
            answer = answer.replace(numbers[i], String.valueOf(i));
        }

        return Integer.parseInt(answer);
    }
}

