package StudyFiles.DataStructures.P18258;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

// 자료구조 큐 연결리스트 구현
public class Main {
    static int N;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/StudyFiles/DataStructures/P18258/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        Queue queue = new Queue();

        for (int i = 0; i < N; i++) {
            String request = br.readLine();
            if(request.contains("push")) {
                String[] temp = request.split(" ");
                queue.push(Integer.parseInt(temp[1]));
            } else if(request.equals("pop")){
                queue.pop();
            } else if(request.equals("size")) {
                queue.size();
            } else if(request.equals("empty")) {
                queue.empty();
            } else if(request.equals("front")) {
                queue.front();
            } else if(request.equals("back")) {
                queue.back();
            }
        }

        queue.print();
    }
}

class Queue {
    int count;
    int value;
    Queue rightNode;
    Queue lastNode; //마지막 인덱스 접근 시간을 단축 시키기 위한 임시 노드
    static StringBuilder sb = new StringBuilder(); // 출력 속도를 빠르게 해주기 위한 String Builder
    Queue() {
        rightNode = null;
        lastNode = null;
        count = 0;
    }

    void lastNodeQuery() {
        Queue rightTemp = lastNode;
        while(true) { // 부모노드에서 부터 마지막 노드로 이동
            if(rightTemp.rightNode == null) {
                break;
            }
            rightTemp = rightTemp.rightNode;
        }
        lastNode = rightTemp;
    }

    boolean isEmpty() {
        if(rightNode == null) return true;
        else return false;
    }

    void empty() {
        if(rightNode == null) sb.append(1).append("\n");
        else sb.append(0).append("\n");
    }

    void push(int value) {
        if(isEmpty()) { //비어 있을 경우 그냥 삽입
            Queue node = new Queue();
            node.value = value;

            // 삽입
            this.rightNode = node;
            lastNode = this.rightNode;
            count++;
        } else { // 비어 있지 않을 경우 node 생성 후 rightNode 를 붙여서 node 를 부모 큐의 rightNode 에 삽입
            Queue node = new Queue();
            node.value = value;

            // 삽입
            lastNodeQuery();
            lastNode.rightNode = node;
            count++;
        }
    }

    void pop() {
        if(isEmpty()) {
            sb.append(-1).append("\n");
        } else {
            sb.append(rightNode.value).append("\n");

            Queue rightTemp = rightNode;
            rightNode = rightTemp.rightNode; // 현재 pop 된 큐를 버리고 오른쪽에 연결된 노드를 삽입
            count--;
        }
    }

    void size() {
        if(isEmpty()) sb.append(0).append("\n");
        else {
            sb.append(count).append("\n");
        }
    }

    void front() {
        if(isEmpty()) sb.append(-1).append("\n");
        else {
            sb.append(rightNode.value).append("\n");
        }
    }

    void back() {
        if(isEmpty()) sb.append(-1).append("\n");
        else {
            lastNodeQuery();
            sb.append(lastNode.value).append("\n");
        }
    }

    void print() {
        System.out.print(sb);
    }
}
