// 셀프 넘버
// 2015/1/15 오후 10시 30분
public class Main {
    public static void main(String[] args) {
        boolean[] check = new boolean[10001]; // boolean의 기본값은 false

        for (int i = 1; i < 10000; i++) {
            int s = i; // 생성자 자기 자신을 더하는 로직

            // 각 자리수 숫자 더하는 로직
            char[] temp = String.valueOf(i).toCharArray();
            for (int j = 0; j < temp.length; j++) {
                s += Integer.parseInt(String.valueOf(temp[j]));
            }

            if (s < 10001) {
                check[s] = true;
            }
        }

        for (int i = 1; i < 10001; i++) {
            if (!check[i]) {
                System.out.println(i);
            }
        }
    }
}
