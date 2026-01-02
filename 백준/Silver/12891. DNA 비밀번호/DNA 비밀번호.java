import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    //입력받은 각 문자의 최소 개수를 저장하는 배열 (A, C, G, T 순서)
    static int checkArr[];
    //현재 슬라이딩 윈도우에서 각 문자의 개수를 저장하는 배열
    static int test[];
    //조건을 만족하는 문자의 개수를 카운트
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        //첫번째 줄로 입력받은 변수 두개 저장
        int n = Integer.parseInt(st.nextToken());//DNA 문자열의 길이
        int m = Integer.parseInt(st.nextToken());//검사할 부분 문자열의 길이

        // DNA 문자열을 저장하는 배열
        char dna[] = new char[n];
        checkArr = new int[4];
        test = new int[4];
        int answer = 0;//조건을 만족하는 부분 문자열의 수
        count = 0;

        //두번째줄로 입력받은 dna 문자열을 배열로 저장
        dna = br.readLine().toCharArray();
        //세번째줄로 입력받은 4개의 숫자 저장
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < 4; i++) {
            checkArr[i] = Integer.parseInt(st.nextToken());
            if(checkArr[i] == 0) {
                count++;
            }
        }

        //초기 윈도우 설정
        for(int i = 0; i <m; i++) {
            Add(dna[i]);
        }
		//초기 윈도우에서 답이 나올경우 
        if(count == 4) {
            answer++;
        }
        // 슬라이딩 윈도우를 이용해 문자열 검사
        for(int i = m; i<n; i++) {
            Add(dna[i]);
            Remove(dna[i-m]);
            if(count == 4){
                answer++;
            }

        }
        System.out.println(answer);
        br.close();
    }
    // 윈도우에 문자를 추가하는 함수
    public static void Add(char c) {
        switch (c){
            case 'A':
                test[0]++;
                if(test[0] == checkArr[0]) {
                    count++;
                }
                break;
            case 'C':
                test[1]++;
                if(test[1] == checkArr[1]) {
                    count++;
                }
                break;
            case 'G':
                test[2]++;
                if(test[2] == checkArr[2]) {
                    count++;
                }
                break;
            case 'T':
                test[3]++;
                if(test[3] == checkArr[3]) {
                    count++;
                }
                break;
        }
    }
    // 윈도우에서 문자를 제거하는 함수
    public static void Remove(char c) {
        switch (c){
            case 'A':
                if(test[0] == checkArr[0]) {
                    count--;
                }
                test[0]--;
                break;
            case 'C':
                if(test[1] == checkArr[1]) {
                    count--;
                }
                test[1]--;
                break;
            case 'G':
                if(test[2] == checkArr[2]) {
                    count--;
                }
                test[2]--;
                break;
            case 'T':
                if(test[3] == checkArr[3]) {
                    count--;
                }
                test[3]--;
                break;
        }
    }
}