package day5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class back_1377 { //버블 정렬 시 소팅이 완료 된 시점에서의 루프 번호
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); //5*10^6  -> O(nlogn)
        Element[] elements = new Element[N];

        for (int i = 0; i < N; i++) //버블 정렬 시 1루프를 돌 때 오른쪽으로 이동하는 최대 거리는 1이다. 따라서 오른쪽으로 이동한 인덱스의 최대 값이 루프의 횟수라고 할 수 있다.
        {
            elements[i] = new Element(Integer.parseInt(br.readLine()),i);  // 10 1 5 2 3 4  1 5 2 3 10    1 2 3 5 10   1 2 2 -1 -4
        }
        Arrays.sort(elements); // compareTo 기준
        int maxMove=0;
        for(int i=0;i<N;i++)
        {
            int move= elements[i].index-i;  // 정렬 된 상태이기 때문에 본래의 인덱스 elements[i].index - i 는 이동한 거리가 된다.
            if(move > maxMove)
                maxMove=move;
            }
        System.out.print(maxMove+1);
    }
}
class Element implements Comparable<Element>
{
    int index;
    int value;
    public Element(int value, int index)
    {
        this.index= index;
        this.value=value;
    }
    @Override
    public int compareTo(Element o)
    {
        return Integer.compare(this.value, o.value);
    }
}
