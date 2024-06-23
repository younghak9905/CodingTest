package day5;
import java.util.Scanner;

public class back_1427 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int[] A = new int[str.length()];

        // 문자열의 각 문자를 숫자로 변환하여 배열에 저장
        for (int i = 0; i < str.length(); i++) {
            A[i] = Integer.parseInt(str.substring(i, i + 1));
        }

        // 배열을 내림차순으로 정렬 (선택 정렬 방식)
        for (int i = 0; i < str.length(); i++) {
            int Max = i;
            for (int j = i + 1; j < str.length(); j++) {
                if (A[j] > A[Max]) { // 내림차순이므로 최댓값을 찾음
                    Max = j;
                }
            }
            if (A[i] < A[Max]) {
                int temp = A[i];
                A[i] = A[Max];
                A[Max] = temp;
            }
        }

        // 정렬된 배열을 출력
        for (int i = 0; i < str.length(); i++) {
            System.out.print(A[i]);
        }
    }
}
