import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        String arr = br.readLine();
        
        char[] c = arr.toCharArray();

        int sum = 0;
        for (char value : c) {
            sum += value - '0';
        }
        System.out.println(sum);
    }
}

