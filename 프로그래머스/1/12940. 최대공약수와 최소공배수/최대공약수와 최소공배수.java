class Solution {
    public int[] solution(int n, int m) {
        int[] answer = new int[2];
        

        answer[0] = gcd(n, m); // 최대공약수
        answer[1] = (n * m)/answer[0]; // 최소공배수
   
        return answer;
    }
    
    public static int gcd (int p, int q) {
        if(q == 0) 
            return p;
        
        return gcd(q, p%q);
        
    }
        
}