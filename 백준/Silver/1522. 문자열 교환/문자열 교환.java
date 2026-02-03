import java.io.*;
import java.util.*;
import java.math.*;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    char[] arr = br.readLine().toCharArray();

    int cnt = 0;

    for(int i =0 ;i<arr.length;i++){
      if(arr[i] == 'a') cnt++;
    }

    int ans = cnt;

    int n = arr.length;

    for(int i = 0;i<n;i++){
      int now = 0;
      for(int j = i;j<i+cnt;j++){
        if(arr[j%n] == 'b') now++;
      }
      ans = Math.min(ans,now);
    }

    System.out.println(ans);
  }
}