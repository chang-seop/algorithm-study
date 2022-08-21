package StudyFiles.SetsAndMaps.P11478;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Main {
    static String S;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/StudyFiles/SetsAndMaps/P11478/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashSet<String> hashSet = new HashSet<>(); // 이미 값이 있으면 추가 하지 않음을 이용한 해시 셋

        // 입력
        S = br.readLine();
        int length = S.length();

        // 부분 문자열 구하기 -> 슬라이딩 윈도우
        int start = 0, end = 0;
        String temp = String.valueOf(S.charAt(start)); // start 값 넣기
        while(true) {
            // 탈출 조건
            if(start == length - 1) { // 시작 포인터가 마지막 값을 탐색 했을 때
                hashSet.add((String.valueOf(S.charAt(start))));
                break;
            }

            if(start == end) { // 단일 값
                hashSet.add(temp);
                end++;
            } else if(end == length) { // end 가 문자열 길이 만큼 일 때 start + 1 값을 end 에 대입
                end = ++start;
                temp = String.valueOf(S.charAt(start));
            } else {
                temp += String.valueOf(S.charAt(end++)); // end 값 등록
                hashSet.add(temp);
            }
        }

        System.out.print(hashSet.size()); // 현재 셋 사이즈 출력
    }
}
