package DAY02.P1713;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {
    static int N;
    static int K;
    static Nominee[] nominees;

    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("src/DAY02/P1713/input.txt"));
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        K = sc.nextInt();

        nominees = new Nominee[101];

        List<Nominee> list = new ArrayList<>();
        for (int k = 0; k < K; k++) {
            int num = sc.nextInt();
            //해당 후보가 최초 호출 시
            if(nominees[num] == null) {
                nominees[num] = new Nominee(num, 0, 0, false);
            }
            //해당 후보가 사진틀에 있을 경우
            if(nominees[num].isIn) {
                nominees[num].count++;
            } else { //해당 후보가 사진틀에 없음
                //사진틀이 가득 찬 경우
                if(list.size() == N) {
                    //정렬, 지울 후보 선정, 제거
                    Collections.sort(list);
                    //list.get(0).isIn = false;
                    Nominee nominee = list.remove(0);
                    nominee.isIn = false;
                }
                //사진틀에 여유가 있는경우
                nominees[num].count = 1;
                nominees[num].isIn = true;
                nominees[num].timeStamp = k;
                list.add(nominees[num]);
            }
        }
        Collections.sort(list, new Comparator<Nominee>() {
            @Override
            public int compare(Nominee o1, Nominee o2) {
                return Integer.compare(o1.number, o2.number);
            }
        });

        for (int i = 0; i < list.size(); i++) {
            Nominee nomi = list.get(i);
            System.out.print(nomi.number + " ");
        }
    }
}
class Nominee implements Comparable<Nominee> {
    int number;
    int count;
    int timeStamp;
    boolean isIn;

    //1. 추천수, 2. 시간
    @Override
    public int compareTo(Nominee o) {
        int comp = Integer.compare(count, o.count); // count 기준 오름차순
        if(comp == 0) {
            return Integer.compare(timeStamp, o.timeStamp); // timestamp 기준 오름차순
        } else {
            return comp;
        }
    }

    public Nominee(int number, int count, int timeStamp, boolean isIn) {
        this.number = number;
        this.count = count;
        this.timeStamp = timeStamp;
        this.isIn = isIn;
    }

    @Override
    public String toString() {
        return "Nominee{" +
                "number=" + number +
                ", count=" + count +
                ", timeStamp=" + timeStamp +
                ", isIn=" + isIn +
                '}';
    }

    public int getNumber() {
        return number;
    }

    public int getCount() {
        return count;
    }

    public int getTimeStamp() {
        return timeStamp;
    }

    public boolean isIn() {
        return isIn;
    }
}
