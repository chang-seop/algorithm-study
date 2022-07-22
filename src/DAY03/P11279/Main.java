package DAY03.P11279;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Main {
    static PriorityQueue<Integer> pq;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/DAY03/P11279/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        MaxHeap mh = new MaxHeap();

        for (int n = 0; n < N; n++) {
            int input = Integer.parseInt(br.readLine());
            if(input == 0) {
                System.out.println(mh.delete());
            } else {
                mh.insert(input);
            }
        }
    }
}
class MaxHeap {
    List<Integer> list;
    MaxHeap() {
        list = new ArrayList<>();
        list.add(0);
    }
    public void insert(int value) {
        //리스트 마지막에 삽입
        list.add(value);

        int current = list.size() - 1; // 현재 노드
        int parent = current / 2; // 부모 노드
        while(true) {
            //탈출조건 부모 노드가 없을때 또는 부모 노드 값이 현재 노드 값 보다 크거나 같을 때
            if(parent == 0 || list.get(parent) >= list.get(current)) {
                break;
            }

            //Swap
            int temp = list.get(parent);
            list.set(parent, list.get(current));
            list.set(current, temp);

            current = parent;
            parent = current / 2;
        }
    }
    public int delete() {
        // top 의 값을 가져온 후 마지막 노드를 루트로 갖고 오고 마지막 노드 삭제
        if(list.size() == 1) {
            return 0;
        }
        int top = list.get(1);
        list.set(1, list.get(list.size() - 1));
        list.remove(list.size() - 1);

        // 루트 노드부터 각 자식 노드와 비교하여 최대 값을 루트로 보내는 작업
        int currentPo = 1; // 현재 노드 index
        while(true) {
            int leftPo = currentPo * 2; // 자식 왼쪽 노드 index
            int rightPo = currentPo * 2 + 1; // 자식 오른쪽 노드 index

            //탈출 조건 ( 왼쪽 자식 노드가 리스트 사이즈 보다 크거나 같을 때 )
            if(leftPo >= list.size()) {
                break;
            }

            // 왼쪽 자식노드의 최대 값, 최대 값의 index 저장
            int maxValue = list.get(leftPo);
            int maxPo = leftPo;

            // 오른쪽 자식 노드의 값이 왼쪽 노드 보다 클 경우 maxValue, maxPo 에 저장
            if(rightPo < list.size() && list.get(rightPo) > maxValue) {
                maxValue = list.get(rightPo);
                maxPo = rightPo;
            }

            //현재 노드의 값 보다 maxValue 의 값이 클경우 Swap
            if(list.get(currentPo) < maxValue) {
                list.set(maxPo, list.get(currentPo)); //maxPo 위치에 저장
                list.set(currentPo, maxValue); // currentPo 위치에 저장
            }

            currentPo = maxPo;
        }
        return top;
    }
}
