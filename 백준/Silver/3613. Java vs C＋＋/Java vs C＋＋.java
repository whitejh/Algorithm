import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

// 2025.2.9 월요일 오후 4시 55분

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();

        // 먼저 입력이 Java인지 C++인지 판별한 뒤, 해당 방향으로만 변환하는 것
        boolean hasUpper = false, hasUnderscore = false;
        for(char c : line.toCharArray()) {
            if(Character.isUpperCase(c)) hasUpper = true;
            if(c == '_') hasUnderscore = true;
        }

        // Error 케이스 먼저 처리
        // 둘 다 있으면 Error
        if(hasUpper && hasUnderscore) {
            System.out.println("Error!");
            return;
        }

        // 첫 글자가 대문자이거나 _ 글자 => Error
        if(Character.isUpperCase(line.charAt(0)) || line.charAt(0) == '_') {
            System.out.println("Error!");
            return;
        }

        // 마지막이 _ 글자 => Error
        if(line.charAt(line.length()-1) == '_') {
            System.out.println("Error!");
            return;
        }

        StringBuilder sb = new StringBuilder();
        if(hasUnderscore) {
            // C++ -> Java 변환
            for (int i = 0; i < line.length(); i++) {
                if(line.charAt(i) == '_') {
                    // 연속 _ 체크
                    if(i + 1 < line.length() && line.charAt(i + 1) == '_') {
                        System.out.println("Error!");
                        return;
                    }
                    i++;
                    sb.append(Character.toUpperCase(line.charAt(i)));
                } else {
                    sb.append(line.charAt(i));
                }
            }
        } else if(hasUpper) {
            // Java -> C++ 변환
            for (int i = 0; i < line.length(); i++) {
                char word = line.charAt(i);
                if(Character.isUpperCase(word)) {
                    sb.append('_').append(Character.toLowerCase(word));
                } else {
                    sb.append(word);
                }
            }
        } else {
            // _ 와 대문자가 없으면 그대로 출력
            sb.append(line);
        }

        System.out.println(sb.toString());
    }

}

// 1. _ 가 나오면 그 다음 문자는 소문자에서 대문자로 변경 - 체크
// 2. 대문자가 나오면 해당 문자를 소문자로 바꾸고, 그 앞에 _ 를 붙여줌
// 3. 1,2 경우만 아니면 "Error!" 출력