package StudyFiles.DataStructures.P10828;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int T;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/StudyFiles/DataStructures/P10828/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        T = Integer.parseInt(br.readLine());

        Stack stack = new Stack(10000); // 주어진 문제에서 명령의 수가 (1 <= N <= 10000) 최악을 잡아서 maxsize 할당

        for (int i = 0; i < T; i++) {
            String request = br.readLine();

            String[] temp = request.split(" "); // 문자열 안에 공백 문자를 기준으로 배열을 나누게 하려고 Split 함수 사용
            if(temp[0].equals("push")) {
                stack.push(Integer.parseInt(temp[1]));
            } else if(temp[0].equals("pop")) {
                stack.pop();
            } else if(temp[0].equals("size")) {
                stack.size();
            } else if(temp[0].equals("empty")) {
                System.out.println(stack.isEmpty());
            } else if(temp[0].equals("top")) {
                stack.top();
            }
        }
    }
}

class Stack {
    int[] arr;
    int index;
    final int maxSize;

    Stack(int maxSize) {
        this.maxSize = maxSize;
        arr = new int[maxSize];
        index = -1;
    }

    int isEmpty() {
        if(index == -1) return 1; // 현재 인덱스가 -1일 경우 스택 안에 값이 없음
        else return 0;
    }
    int isFull() {
        if(index == (maxSize - 1)) return 1; // 현재 인덱스가 배열의 끝일 경우 (꽉 참)
        else return 0;
    }

    void push(int value) {
        if(isFull() == 0) arr[++index] = value; // index를 먼저 증가 후 값을 넣기 ( index 초기 값 : -1 )
    }

    void pop() {
        if(isEmpty() == 1) {
            System.out.println(-1);
        } else {
            int temp = arr[index]; // temp 에 먼저 값을 넣는다!
            arr[index--] = 0; // arr[index] 값을 0으로 만든 후에 index 하나 줄이기
            System.out.println(temp);
        }
    }

    void size() {
        System.out.println(index + 1); // 현재 index의 +1을 한 값 : 사이즈
    }

    void top() {
        if(isEmpty() == 1) {
            System.out.println(-1);
        } else{
            System.out.println(arr[index]); // 스택에 비어있지 않을 경우 현재 첫번 째 스택 값 출력
        }
    }
}
