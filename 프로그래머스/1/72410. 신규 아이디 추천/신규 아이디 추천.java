class Solution {
    public String solution(String new_id) {
        String answer = "";

        // 1,2,3단계
        answer = new_id.toLowerCase();
        answer = answer.replaceAll("[^a-z0-9._-]", "");
        answer = answer.replaceAll("\\.+", ".");

        // 4단계
        if (answer.startsWith(".")) {
            answer = answer.substring(1);
        }
        if (answer.endsWith(".")) {
            answer = answer.substring(0, answer.length() - 1);
        }
        // 5단계
        if (answer.isEmpty()) {
            answer = "a";
        }

        // 6단계
        if (answer.length() >= 16) {
            answer = answer.substring(0, 15);
            if (answer.endsWith(".")) {
                answer = answer.substring(0, answer.length() - 1);
            }
        }

        // 7단계
        if (answer.length() <= 2) {
            String last = String.valueOf(answer.charAt(answer.length() - 1));
            while (true) {
                if (answer.length() == 3) {
                    break;
                }
                answer += last;
            }
        }
        
        return answer;
    }
}