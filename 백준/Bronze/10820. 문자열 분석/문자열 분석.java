import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//2025/4/1 화요일 오후 4시 7분
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        String s;
        while ((s = br.readLine()) != null) {
            int small = 0;  //소문자 개수
            int capital = 0;   //대문자 개수
            int number = 0;  //숫자 개수
            int space = 0;  //공백 개수
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (c == ' ') space++;
                if (Character.isUpperCase(c)) capital++;
                if (Character.isLowerCase(c)) small++;
                if (Character.isDigit(c)) number++;
            }
            sb.append(small + " " + capital + " " + number + " " + space + "\n");
        }
        System.out.print(sb);
    }
}
