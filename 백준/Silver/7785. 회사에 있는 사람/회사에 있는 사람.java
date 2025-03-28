import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.StringTokenizer;

// 2025/3/28 금요일 오전 10시 30분
// map 활용
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        HashMap<String, String> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            String state = st.nextToken();

            if (map.containsKey(name)) {
                map.remove(name);
            } else {
                map.put(name, state);
            }
        }

        ArrayList<String> list = new ArrayList<String>(map.keySet());
        list.sort(Collections.reverseOrder());

        for (String s : list) {
            System.out.println(s);
        }
    }
}


//그냥 HashMap key값에 이름들을 넣고 만약에 key 값이 한 번 더 나온다 하면 그 key값을 HashMap에서 삭제하였다.
// (여기서 굳이 value값으로 비교할 필요가 없는 게 만약 동일한 key값이 두 번 나왔으면
// 그거는 무조건 enter 후 leave이므로 key값 포함 여부만 확인하면 된다.)
//그러고 나서 ArrayList에 넣어서 사전 순의 역순으로 정렬을 해주고 출력을 하였다.
