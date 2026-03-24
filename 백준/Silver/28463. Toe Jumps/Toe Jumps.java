import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		String dir = br.readLine(); // 진행 방향, EWSN, 동서남북
		
		// 해당 방향에서 바로보는 기준으로 문자열을 저장.
		// 바라볼 때 1열 왼쪽, 1열 오른쪽, 2열 왼쪽, 2열 오른쪽 
		String[] name = {"T", "F", "Lz"};
		char[] T = { '.', 'O', 'P', '.' };
		char[] F = { 'I', '.', '.', 'P' };
		char[] Lz = { 'O', '.', '.', 'P' };
		boolean[] check = new boolean[3];
		
		// 2x2의 격자이기 때문에 2개를 동시에 입력 받는다.
		char[] j = new char[4];
		char[] u = br.readLine().toCharArray();
		char[] d = br.readLine().toCharArray();
		
		switch (dir) {
		case "E": // 동쪽이라면
			j[0] = d[0];
			j[1] = u[0];
			j[2] = d[1];
			j[3] = u[1];
			break;
		case "W": // 서쪽이라면
			j[0] = u[1];
			j[1] = d[1];
			j[2] = u[0];
			j[3] = d[0];
			break;
		case "S": // 남쪽이라면
			j[0] = u[0];
			j[1] = u[1];
			j[2] = d[0];
			j[3] = d[1];
			break;
		case "N": // 북쪽이라면
			j[0] = d[1];
			j[1] = d[0];
			j[2] = u[1];
			j[3] = u[0];
			break;
		}
		
		// 각각의 점프 계열마다 체크 
		for (int i = 0; i < 4; i++) {
			if (!check[0] && j[i] != T[i]) {
				check[0] = true;
			}
			
			if (!check[1] && j[i] != F[i]) {
				check[1] = true;
			}
			
			if (!check[2] && j[i] != Lz[i]) {
				check[2] = true;
			}
		}
		
		// 일치하는 점프가 있다면 출력.
		for (int i = 0; i < 3; i++) {
			if (!check[i]) {
				sb.append(name[i]);
				break;
			}
		}
		
		// 일치하는 점프가 없다면 ?를 출력.
		if (sb.length() == 0) {
			sb.append("?");
		}
		
		bw.write(sb.toString());
        bw.close();
	
	}
}