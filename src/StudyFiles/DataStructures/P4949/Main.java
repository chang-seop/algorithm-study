package StudyFiles.DataStructures.P4949;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    static String N;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/StudyFiles/DataStructures/P4949/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Character> stack = new Stack<>();

        while(true) {
            char[] input = br.readLine().toCharArray();
            if(input[0] == '.' && input.length == 1) break;

            // 초기화
            stack.clear();
            stack.push('C');
            boolean visited = false;

            for(int i = 0; i < input.length; i++) {
                if(input[i] == '.' && stack.peek() != 'C'){
                    visited = true;
                    break;
                }
                if(input[i] == '(') {
                    stack.push('(');
                } else if(input[i] == '[') {
                    stack.push('[');
                }
                else if(input[i] == ')' || input[i] == ']') {
                    if(stack.peek() == 'C') {
                        visited = true;
                        break;
                    } else {
                        if(input[i] == ')' && stack.peek() == '(') {
                            stack.pop();
                        } else if(input[i] == ']' && stack.peek() == '['){
                            stack.pop();
                        } else {
                            visited = true;
                            break;
                        }
                    }
                }
            }
            if(!visited) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }
        }
    }
}
