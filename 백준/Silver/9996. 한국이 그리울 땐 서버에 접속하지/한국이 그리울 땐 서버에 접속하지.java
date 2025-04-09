import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        String p = br.readLine();
        String[] p2 = p.split("\\*");

        for (int i = 0; i < N; i++) {
            boolean match = false;
            String text = br.readLine();

            // *가 단어에서 가운데에 있는 경우
            if(p2.length == 2) {
                if(text.startsWith(p2[0]) && text.endsWith(p2[1])) {
                    match = true;
                }
            } else { // * 가 맨앞 혹은 맨뒤에 위치
                if(p.toCharArray()[0] == '*') { // 맨앞
                    if(text.endsWith(p2[0])) {
                        match = true;
                    }
                } else { // 맨뒤
                    if(text.startsWith(p2[0])) {
                        match = true;
                    }
                }
            }
            
            if(match && p.length() - 1 <= text.length()) 
            	System.out.println("DA");
            else 
            	System.out.println("NE");
        }
    }
}
