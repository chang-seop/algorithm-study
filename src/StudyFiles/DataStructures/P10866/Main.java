package StudyFiles.DataStructures.P10866;


import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/StudyFiles/DataStructures/P10866/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        dequeue dq = new dequeue();

        while(N-- > 0) {
            String[] input = br.readLine().split(" ");
            if(input[0].equals("push_back")) {
                dq.pushBack(Integer.parseInt(input[1]));
            } else if(input[0].equals("push_front")) {
                dq.pushFront(Integer.parseInt(input[1]));
            } else if(input[0].equals("front")) {
                sb.append(dq.front()).append("\n");
            } else if(input[0].equals("back")) {
                sb.append(dq.back()).append("\n");
            } else if(input[0].equals("pop_front")) {
                sb.append(dq.popFront()).append("\n");
            } else if(input[0].equals("pop_back")) {
                sb.append(dq.popBack()).append("\n");
            } else if(input[0].contains("size")) {
                sb.append(dq.size()).append("\n");
            } else if(input[0].contains("empty")) {
                sb.append(dq.isEmpty()).append("\n");
            }
        }
        System.out.print(sb);
    }
}
//Dequeue 연결리스트
class dequeue {
    Node front;
    Node rear;
    int size = 0;

    int isEmpty() {
        if(size == 0) return 1;
        else return 0;
    }
    void pushBack(int data) {
        if(size == 0) {
            pushFront(data);
            return;
        }
        Node temp = new Node();
        temp.data = data;
        temp.prev = rear;
        rear.next = temp;
        rear = temp;
        size++;
    }
    void pushFront(int data) {
        Node temp = new Node();
        temp.data = data;
        temp.next = front;

        if(front != null)
            front.prev = temp;

        front = temp;
        if(front.next == null) {
            rear = front;
        }
        size++;
    }
    int popFront() {
        if(front == null)
            return - 1;
        int data = front.data;
        front = front.next;
        if(front != null)
            front.prev = null;
        size--;

        if(size == 0)
            rear = null;
        return data;
    }
    int popBack() {
        if(rear == null)
            return -1;
        int data = rear.data;
        rear = rear.prev;
        if(rear != null)
            rear.next = null;
        size--;

        if(size == 0)
            front = null;
        return data;
    }
    int size() {
        return size;
    }

    int front() {
        if(front == null)
            return -1;
        return front.data;
    }
    int back() {
        if(rear == null)
            return -1;
        return rear.data;
    }
}

class Node {
    Node next;
    Node prev;
    int data;
    Node() {
        this.next = null;
        this.prev = null;
    }
}