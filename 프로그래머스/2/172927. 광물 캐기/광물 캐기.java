import java.io.*;
import java.util.*;

class Solution {
    public int solution(int[] picks, String[] minerals) {
        // 1. 광물을 5개씩 잘라서 (맨 마지막은 낱개 끼리) 각 곡괭이로 했을 때 cost가 얼마나 드는지 계산 
        // 2. 돌 곡괭이로 작업했을 때 드는 비용을 기준으로 정렬
        // (해당 기준이 각 단위별 코스트 차이가 극명히 들어남. + 돌 곡괭이로 cost가 많이 든다 
        //                                                     == 다른 곡괭이들로도 cost가 많이 든다.)
        // 3. 곡괭이를 다 쓰거나 아니면, 돌을 전부 처리하거나 할 때까지 작업 반복 
        // (해당 단위에서 피로도가 가장 적게 드는 곡괭이를 선정하여 쓴다.)

        List<Mineral> stress = new ArrayList<>(); 
        // 모든 곡괭이 수를 더한다.
        int pick_cnt = Arrays.stream(picks).sum();
        // 최대 작업량을 구한다. 쓸 수 있는 곡괭이 수, 광물량 중 적은 쪽이 최대 작업량이다.
        int work_cnt = Math.min(pick_cnt*5, minerals.length);
        //돌 곡괭이로 했을 때, 구간별 최대 작업량을 구해 놓을 것이다. 
        for(int i =0; i<work_cnt; i+=5){   
            int d_cost = 0;
            int i_cost = 0;
            int s_cost = 0;

            for(int j = 0; j<5; j++){
                int next = i+j;
                // 중요! -> 최대 작업량을 넘어갈 시 더 이상 계산하지 않는다! 
                // 맨 마지막 묶음이 1~4개의 낱개로 되어있을 경우, 해당 break 문을 통해 적절히 탈출할 수 있다!
                if(next == work_cnt) break;

                switch(minerals[next]) {
                    case "diamond": {
                        d_cost+=1;
                        i_cost+=5;
                        s_cost+=25;
                        break;
                    }
                    case "iron": {
                        d_cost+=1;  
                        i_cost+=1;
                        s_cost+=5;
                        break;
                    }
                    case "stone": {
                        d_cost+=1;
                        i_cost+=1;
                        s_cost+=1;
                        break;
                    }
                }  
            }
            // 각 구간 별 다이아, 철, 돌 곡괭이로 작업했을 때,
            // 피로도를 계산해서, stress(피로도) 리스트에 저장한다. 
            stress.add(new Mineral(d_cost, i_cost, s_cost));
        }
        // 내림차순(비용 많이 드는 묶음 순으로 정렬)
        Collections.sort(stress, (o1,o2) -> o2.s_cost - o1.s_cost);
        int min_cost = 0;
        for(int i =0; i< stress.size(); i++){
            // 곡괭이 다 쓰면 탈출
            if(picks[0] == 0 && picks[1] == 0 && picks[2] == 0) break;
            // 다이아 -> 철 -> 돌 곡괭이 순으로 사용
            if(picks[0] > 0) {picks[0]--; min_cost += stress.get(i).d_cost;}
            else if(picks[1] > 0) {picks[1]--; min_cost += stress.get(i).i_cost;}
            else if(picks[2] > 0) {picks[2]--; min_cost += stress.get(i).s_cost;}
        }
        // 피로도의 총합 반환
        return min_cost;
    }
}

// 구간 별, 각 곡괭이로 작업했을 때의 피로도를 저장한다.
class Mineral {
    int d_cost;
    int i_cost;
    int s_cost;

    public Mineral(int d, int i, int s){
        this.d_cost = d;
        this.i_cost = i;
        this.s_cost = s;
    }
}