import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

// 구현, 정렬
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        ArrayList<Student> myList = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int kor = Integer.parseInt(st.nextToken());
            int eng = Integer.parseInt(st.nextToken());
            int math = Integer.parseInt(st.nextToken());
            myList.add(new Student(name, kor, eng, math));
        } 
        
        Collections.sort(myList);
        for (int i = 0; i < myList.size(); i++) {
            System.out.println(myList.get(i).name);
        }
    }
}

class Student implements Comparable<Student> {
    String name;
    int kor;
    int eng;
    int math;

    public Student(String name, int kor, int eng, int math) {
        this.name = name;
        this.kor = kor;
        this.eng = eng;
        this.math = math;
    }

    // 국어 감소, 영어 증가, 수학 감소, 이름 사전순
    // 정렬 기준을 나타내는 함수
    @Override
    public int compareTo(Student o) {
        if (this.kor != o.kor) {
            return o.kor - this.kor;
        } else if (this.eng != o.eng) {
            return this.eng - o.eng;
        } else if (this.math != o.math) {
            return o.math - this.math;
        }

        return this.name.compareTo(o.name);
    }
}
