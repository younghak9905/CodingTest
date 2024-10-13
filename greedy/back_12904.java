package greedy;

import java.awt.desktop.ScreenSleepEvent;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;



public class back_12904 {
    static int size;
    static String S, T;
    static StringBuilder sb;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String S = br.readLine();
        StringBuilder T = new StringBuilder(br.readLine());

        while (T.length() > S.length()) {
            // 마지막 문자가 A이면 A를 제거
            if (T.charAt(T.length() - 1) == 'A') {
                T.deleteCharAt(T.length() - 1);
            }
            // 마지막 문자가 B이면 B를 제거하고 문자열을 뒤집음
            else if (T.charAt(T.length() - 1) == 'B') {
                T.deleteCharAt(T.length() - 1);
                T.reverse();
            }
        }

        // 길이가 같아졌을 때 S와 T가 같은지 비교
        if (T.toString().equals(S)) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }
}