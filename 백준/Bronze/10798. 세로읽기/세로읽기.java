import java.io.*;

// 세로 읽기
// 2024/12/16 월요일 오후 9시 2분
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        char[][] map = new char[5][15]; // 2차원 배열
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 15; j++) {
                map[i][j] = ' '; // 2차원 배열을 먼저 빈칸으로 채우기
            }
        }

        for (int i = 0; i < 5; i++) {
            char text[] = br.readLine().toCharArray(); // 읽어온 문자열을 char배열(각각의 문자)로 변환
            for (int j = 0; j < text.length; j++) {
                map[i][j] = text[j];
            }
        }

        //세로로 탐색해서 출력
        for (int j = 0; j < 15; j++) {
            for (int i = 0; i < 5; i++) {
                if (map[i][j] != ' ') {
                    bw.write(map[i][j]);
                }
            }
        }
        bw.flush();
    }
}
