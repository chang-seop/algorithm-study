package StudyFiles.Geometry.P2477;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int melon;
    static List<Vertex> shape, shape2, shape3;
    static List<Integer> maxPosition;
    static int area1 = 1, area2 = 1;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/StudyFiles/Geometry/P2477/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        melon = Integer.parseInt(br.readLine());

        shape = new ArrayList<>();
        shape2 = new ArrayList<>();
        shape3 = new ArrayList<>();
        maxPosition = new ArrayList<>();

        for (int i = 0; i < 6; i++) {
            st = new StringTokenizer(br.readLine());
            int position = Integer.parseInt(st.nextToken());
            int length = Integer.parseInt(st.nextToken());
            shape.add(new Vertex(position, length, i));
        }

        Collections.sort(shape);

        // 중복 되지 않는 큰 값 찾기
        boolean visited1 = false;
        int position1 = 0, position2 = 0;
        for (int i = 1; i < 6; i++) {
            if(shape.get(i - 1).position == shape.get(i).position && !visited1) {
                visited1 = true;
                position1 = shape.get(i - 1).position;
            }
            else if(shape.get(i - 1).position == shape.get(i).position && visited1) {
                position2 = shape.get(i - 1).position;
                break;
            }
        }

        //area1 ( 총 넓이 구하기 )
        for(Vertex i : shape) {
            if(i.position != position1 && i.position != position2) {
                area1 *= i.length;
                maxPosition.add(i.position);
            }
        }

        Comparator<Vertex> comp = new Comparator<Vertex>() {
            @Override
            public int compare(Vertex o1, Vertex o2) {
                return o1.count - o2.count;
            }
        };
        Collections.sort(shape, comp);

        //area2 ( 빈 사각형 넓이 구하기 )
        boolean comp1 = false;
        boolean comp2 = false;
        String a = "", b = "";
        for (Vertex i : shape) {
            if(i.position == maxPosition.get(0) || i.position == maxPosition.get(1)) {
                comp1 = true;
            }else if((i.position != maxPosition.get(0) || i.position != maxPosition.get(1)) && comp1) {
                shape2.add(i);
                continue;
            }
            if(!comp1) {
                shape3.add(i);
            }
        }
        shape2.addAll(shape3);

        // 계산
        area1 = area1 * melon;
        area2 = (shape2.get(1).length * shape2.get(2).length) * melon;

        System.out.println(area1 - area2);
    }
}
class Vertex implements Comparable<Vertex>{
    int position;
    int length;
    int count;
    Vertex(int position, int length, int count) {
        this.position = position;
        this.length = length;
        this.count = count;
    }

    @Override
    public int compareTo(Vertex o) {
        return this.position - o.position;
    }
}
