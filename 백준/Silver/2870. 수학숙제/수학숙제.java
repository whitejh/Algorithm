import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.util.ArrayList;

// 2026.2.10 화요일 오후 1시 55분
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        ArrayList<BigInteger> list = new ArrayList<>();

        String line[];
        for (int i = 0; i < N; i++) {
            line = br.readLine().split("\\D"); // 문자열 사이에 숨겨진 숫자들을 추출

            // lo3za4이 들어오면 -> ["", "", "3", "", "", "4"] 와 같은 형태의 배열이 생성됨

            for (int j = 0; j < line.length; j++) {
                if (!line[j].equals("")) {
                    list.add(new BigInteger(line[j]));
                }
            }
        }
        
        //list.sort((a,b) -> a.compareTo(b));
        list.sort(BigInteger::compareTo);
        
        N = list.size();
        for (int i = 0; i < N; i++) {
            sb.append(list.get(i) + "\n");
        }
        bw.write(sb.toString());
        bw.close();
        br.close();
    }
}
