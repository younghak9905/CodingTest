import java.io.*;
import java.util.*;

public class back_1388 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		char[][] board = new char[N][M];
		for (int i = 0; i < N; i++) {
			board[i] = br.readLine().toCharArray();
		}

		int count = 0;
		// 가로 방향: '-' 연속 구간 시작 카운트
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (board[i][j] == '-' &&
					(j == 0 || board[i][j - 1] != '-')) {
					count++;
				}
			}
		}

		// 세로 방향: '|' 연속 구간 시작 카운트
		for (int j = 0; j < M; j++) {
			for (int i = 0; i < N; i++) {
				if (board[i][j] == '|' &&
					(i == 0 || board[i - 1][j] != '|')) {
					count++;
				}
			}
		}

		System.out.println(count);
	}
}
