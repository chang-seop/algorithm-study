package StudyFiles.Sort.P10814;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static List<people> peopleList;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/StudyFiles/Sort/P10814/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        peopleList = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int age = Integer.parseInt(st.nextToken());
            String name = st.nextToken();
            peopleList.add(new people(age, i, name));
        }
        Collections.sort(peopleList);

        for (int i = 0; i < N; i++) {
            System.out.println(peopleList.get(i).age + " " + peopleList.get(i).name);
        }
    }
}
class people implements Comparable<people>{
    int age;
    int count;
    String name;

    people(int age, int count, String name) {
        this.age = age;
        this.count = count;
        this.name = name;
    }

    @Override
    public int compareTo(people o) {
        if(this.age == o.age) {
            return this.count - o.count;
        } else return this.age - o.age;
    }
}
