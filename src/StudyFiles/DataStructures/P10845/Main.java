package StudyFiles.DataStructures.P10845;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/StudyFiles/DataStructures/P10845/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        Queue queue = new Queue(2000000); //문제에서 주어진 명령의 수 (1 <= N <= 10000) maxSize 를 최악의 경우로 할당

        for (int i = 0; i < N; i++) {
            String request = br.readLine();
            String[] temp = request.split(" ");
            if(temp[0].equals("push")) {
                queue.push(Integer.parseInt(temp[1]));
            } else if(temp[0].equals("pop")) {
                queue.pop();
            } else if(temp[0].equals("size")) {
                queue.size();
            } else if(temp[0].equals("empty")) {
                if(queue.isEmpty()) System.out.println(1);
                else System.out.println(0);
            } else if(temp[0].equals("front")) {
                queue.front();
            } else if(temp[0].equals("back")) {
                queue.back();
            }
        }
    }
}
class Queue {
    final int maxSize;
    int[] arr;
    int leftIndex, rightIndex;
    Queue(int maxSize) {
        this.maxSize = maxSize;
        arr = new int[maxSize];
        leftIndex = 0;
        rightIndex = -1;
    }
    boolean isEmpty() {
        if(rightIndex < leftIndex) return true;
        else return false;
    }

    boolean isFull() {
        if(rightIndex == (maxSize - 1)) return true;
        else return false;
    }

    void push(int value) {
        if(isFull()) {
            System.out.println(-1);
        } else {
            arr[++rightIndex] = value;
        }
    }

    void pop() {
        if(isEmpty()) {
            System.out.println(-1);
        } else{
            System.out.println(arr[leftIndex++]);
        }
    }

    void front() {
        if(isEmpty()) {
            System.out.println(-1);
        } else {
            System.out.println(arr[leftIndex]);
        }
    }

    void back() {
        if(isEmpty()) {
            System.out.println(-1);
        } else {
            System.out.println(arr[rightIndex]);
        }
    }

    void size() {
        if(isEmpty()) System.out.println(0);
        else System.out.println((rightIndex + 1) - (leftIndex));
    }
}
