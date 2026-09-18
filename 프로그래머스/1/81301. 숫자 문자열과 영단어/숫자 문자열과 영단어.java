class Solution {
    public int solution(String s) {
        String[] str = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        String answer = s;
        
        for(int i = 0; i < str.length; i++) {
            answer = answer.replace(str[i], String.valueOf(i));
        }
        return Integer.parseInt(answer);
    }
}