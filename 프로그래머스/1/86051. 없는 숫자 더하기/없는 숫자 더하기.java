class Solution {
    public int solution(int[] numbers) {
        int sum = 0;
        
        // for(int i = 0; i < numbers.length; i++)
        //     sum += number[i];
        
        for(int num : numbers)
            sum += num;
        
        return 45 - sum;
    }
}