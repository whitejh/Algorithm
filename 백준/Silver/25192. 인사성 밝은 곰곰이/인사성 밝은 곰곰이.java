import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int count = 0;

        Set<String> nicknames = new HashSet<>();

        for (int i = 0; i < N; i++) {
            String line = br.readLine();

            if (line.equals("ENTER")) {
                // 이전 세션에서 등장한 유니크 닉네임 수를 더함
                count += nicknames.size();
                // 새 세션 시작: Set 비우기
                nicknames.clear();
            } else {
                // 현재 세션에서 닉네임 등장(중복이면 자동 무시)
                nicknames.add(line);
            }
        }

        // 마지막 세션 처리 (ENTER로 안 끝날 수 있음)
        count += nicknames.size();

        System.out.println(count);
    }
}