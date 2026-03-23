import java.util.*;
import java.io.*;

// 2026.3.23 월요일 오후 4시 46분
// 풀이시간 50분
// 늘보코치 12주차 구현 문제
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());

		int[] reward = new int[5]; // reward[1] ~ reward[4]

		// 게임 상태
		int score = 0;
		int time = 0;
		int pointPerRoll = 1; // 주사위 1번당 점수
		int timePerTurn = 4; // 매 턴 흐르는 시간

		for(int i = 0; i < N; i++) {
			int num = Integer.parseInt(st.nextToken());

			// 1. 턴 시작 시 시간 초과 체크 -> 게임 종료
			if(time > 240) {
				giveReward(score, reward);
				// 게임 상태 초기화
				score = 0;
				time = 0;
				pointPerRoll = 1;
				timePerTurn = 4;
			}

			// 2. 주사위의 눈에 따른 효과 처리
			if(num == 1) {
				giveReward(score, reward);
				// 게임 상태 초기화
				score = 0;
				time = 0;
				pointPerRoll = 1;
				timePerTurn = 4;
				continue; // 즉시 게임 종료 (이번 턴 점수/시간 반영 안 함)
			}
			else if(num == 2) {
				if(pointPerRoll > 1) {
					pointPerRoll /= 2;
				} else {
					timePerTurn += 2;
				}
			}
			else if(num == 3) {
				// 효과 없음
            }
			else if(num == 4) {
				time += 56; // 이번 턴만 시간 추가
			}
			else if(num == 5) {
				if(timePerTurn > 1) {
					timePerTurn -= 1;
				}
			}
			else if(num == 6) {
				if(pointPerRoll < 32) {
					pointPerRoll *= 2;
				}
			}

			// 게임이 종료될 때마다 얻은 점수에 대한 보상을 받고 새로운 게임을 시작한다.
			// 새로운 게임을 시작할 때 점수가 0점으로 초기화된다.
			// 점수 및 시간 반영
			score += pointPerRoll;
			time += timePerTurn;
		}
		StringBuilder sb = new StringBuilder();
		for(int i = 1; i <= 4; i++) {
			sb.append(reward[i]).append('\n');
		}
		System.out.println(sb);

	}

	// 게임 종료 시 보상 얻는 메서드
	private static void giveReward(int score, int[] reward) {
		if(score>=125) reward[4]++;
		else if(score >= 95) reward[3]++;
		else if(score >= 65) reward[2]++;
		else if(score >= 35) reward[1]++;
		//35미만이면 보상 없음
	}
}