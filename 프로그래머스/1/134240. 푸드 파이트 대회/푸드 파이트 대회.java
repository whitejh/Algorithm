class Solution {
    public String solution(int[] food) {

        String answer = "";
        StringBuilder half = new StringBuilder();

        for (int i = 1; i < food.length; i++){
            if (food[i] % 2 == 1){
                food[i]--;
            }

            int count = food[i] / 2;

            for (int j = 0; j < count; j++){
                half.append(i);
                }
            }
        
        return half.toString() + "0" + half.reverse().toString();
    }
}