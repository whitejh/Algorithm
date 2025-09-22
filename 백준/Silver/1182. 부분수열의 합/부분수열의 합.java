import java.io.*;
import java.util.*;
public class Main{
    static int N,S,arr[];
    static int count=0;
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        arr = new int[N];
        
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arr[i]= Integer.parseInt(st.nextToken());
        }
        
        for(int i=0;i<N;i++){
            dfs(i,arr[i]);
        }
        
        
        System.out.println(count);
        
    }
    static void dfs(int start, int sum){
        if(sum==S){
              count++;
        }
        
        for(int next=start+1; next<N; next++){
            dfs(next,sum+arr[next]);
        }
    }
}