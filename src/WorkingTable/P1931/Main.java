package WorkingTable.P1931;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static List<Time> nList;
    static List<Temp> tempList;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/WorkingTable/P1931/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        nList = new ArrayList<>();
        tempList = new ArrayList<>();

        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int first = Integer.parseInt(st.nextToken());
            int last = Integer.parseInt(st.nextToken());
            nList.add(new Time(first, last, last - first));
        }

        Collections.sort(nList);

        //algorithm
        int first, last;
        int tempIndex = 0;
        tempList.add(new Temp(nList.get(0).first, nList.get(0).last));

        for (int i = 1; i < nList.size(); i++) {
            first = nList.get(i).first;
            last = nList.get(i).last;

            // 현재 tempList 랑 겹치는 값이 없을 경우
            if(compare(first, last)) {
                tempList.add(new Temp(first, last));
            }
            else if((nList.get(tempIndex).last > last && last < nList.get(tempIndex).first) || (nList.get(tempIndex).last < first && first > nList.get(tempIndex).first) && tempIndex != 0) {
                for (int j = 0; j < tempList.size(); j++) {
                    if(tempList.get(j).first <= nList.get(tempIndex).first || nList.get(tempIndex).last >= tempList.get(j).first) {
                        if(tempList.get(j).last >= nList.get(tempIndex).first || nList.get(tempIndex).last <= tempList.get(j).last) {
                            tempList.set(j, new Temp(nList.get(tempIndex).first, nList.get(tempIndex).last));
                            tempList.add(new Temp(first, last));
                            tempIndex = 0;
                            break;
                        }
                    }
                }
            }
            // 현재 tempList 랑 겹치는 값이 있을 경우
            else {
                tempIndex = i;
            }
        }

        for(Temp a : tempList) System.out.println(a.toString());
        System.out.println(tempList.size());
    }
    static boolean compare(int first, int last) {
        for (int i = 0; i < tempList.size(); i++) {
            if(first <= tempList.get(i).first || tempList.get(i).last >= first) {
                if(last >= tempList.get(i).first || tempList.get(i).last <= last) {
                    return false;
                }
            }
        }
        return true;
    }
}
class Time implements Comparable<Time> {
    int first;
    int last;
    int center;

    Time(int first, int last, int center) {
        this.first = first;
        this.last = last;
        this.center = center;
    }
    @Override
    public int compareTo(Time o) {
        if(this.center == o.center) {
            if(this.first == o.first) {
                return this.last - o.last;
            } else return this.first - o.first;
        } else return this.center - o.center;
    }

}

class Temp {
    int first;
    int last;

    public Temp(int first, int last) {
        this.first = first;
        this.last = last;
    }

    @Override
    public String toString() {
        return "Temp{" +
                "first=" + first +
                ", last=" + last +
                '}';
    }
}
