package DAY03.P1927;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static int N;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/DAY03/P1927/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        MinHeap mh = new MinHeap();

        for (int n = 0, a; n < N; n++) {
            int input = Integer.parseInt(br.readLine());
            if (input == 0) {
                System.out.println(mh.delete());
            } else {
                mh.insert(input);
            }
        }
    }
}

class MinHeap {
    List<Integer> list;

    public MinHeap() {
        list = new ArrayList<>();
        list.add(0); // 1부터 시작하기 때문에 0 삽입 (안씀)
    }

    public void insert(int val) {
        // 1. leaf 마지막에 삽입
        list.add(val);
        // 2. 부모와 비교 후 조건에 맞지 않으면 Swap
        // 3. 조건이 만족되거나 root 까지 반복
        int current = list.size() - 1;
        int parent = current / 2;
        while (true) {
            //부모가 0이거나 부모가 자기 꺼보다 작거나 같으면 탈출조건 (최소 힙)
            if(parent == 0 || list.get(parent) <= list.get(current)) {
                break;
            }
            //swap
            int temp = list.get(parent);
            list.set(parent, list.get(current));
            list.set(current, temp);

            current = parent;
            parent = current / 2;
        }
    }

    public int delete() {
        if(list.size() == 1) {
            return 0;
        }
        // 1. Root 에 leaf 마지막 데이터 가져옴
        int top = list.get(1);
        list.set(1, list.get(list.size() - 1));
        list.remove(list.size() - 1);

        // 2. 자식과 비교 후 조건이 맞지 않으면 swap
        // 3. 조건이 만족되거나 leaf 까지 반복
        int currentPos = 1;
        while(true) {
            int leftPos = currentPos * 2;
            int rightPos = currentPos * 2 + 1;
            // 왼쪽 자식 먼저 확인
            if(leftPos >= list.size()) {
                break;
            }
            int minValue = list.get(leftPos);
            int minPos = leftPos;

            // 오른쪽 자식 확인
            // minValue 가 오른쪽 노드의 값보다 클 때 오른쪽 노드의 정보를 minValue, minPos 저장 (최소 힙)
            if(rightPos < list.size() && minValue > list.get(rightPos)) {
                minValue = list.get(rightPos);
                minPos = rightPos;
            }
            // Swap
            if(list.get(currentPos) > minValue) {
                int temp = list.get(currentPos);
                list.set(currentPos, minValue);
                list.set(minPos, temp);
            }
            currentPos = minPos; // 필수 !!
        }
        return top;
    }
}