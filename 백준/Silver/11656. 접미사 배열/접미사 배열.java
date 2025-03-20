import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        String text = br.readLine();
        String[] myArr = new String[text.length()];

        for (int i = 0; i < text.length(); i++) {
                myArr[i] = text.substring(i); // 해당 위치부터 끝위치까지
        }
        Arrays.sort(myArr);
        for (int i = 0; i < text.length(); i++) {
            System.out.println(myArr[i]);
        }
    }
}
