package simulation;

import java.io.*;
import java.util.*;

public class back_1022 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int r1 = Integer.parseInt(st.nextToken());
		int c1 = Integer.parseInt(st.nextToken());
		int r2 = Integer.parseInt(st.nextToken());
		int c2 = Integer.parseInt(st.nextToken());

		int H = r2 - r1 + 1;
		int W = c2 - c1 + 1;
		int[][] A = new int[H][W];
		int filled = 0;
		int total = H * W;
		int maxVal = 1;

		// Starting point
		int y = 0, x = 0;
		if (r1 <= 0 && 0 <= r2 && c1 <= 0 && 0 <= c2) {
			A[-r1][ -c1] = 1;
			filled++;
		}

		int num = 1;
		int len = 1;
		int dir = 0;
		int[] dy = {0, -1, 0, 1};  // right, up, left, down
		int[] dx = {1, 0, -1, 0};

		outer:
		while (filled < total) {
			for (int rep = 0; rep < 2; rep++) {
				for (int step = 0; step < len; step++) {
					y += dy[dir];
					x += dx[dir];
					num++;
					if (r1 <= y && y <= r2 && c1 <= x && x <= c2) {
						A[y - r1][x - c1] = num;
						filled++;
						if (num > maxVal) maxVal = num;
						if (filled == total) break outer;
					}
				}
				dir = (dir + 1) % 4;
			}
			len++;
		}

		int width = String.valueOf(maxVal).length();
		StringBuilder sb = new StringBuilder();
		String fmt = "%" + width + "d";
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				sb.append(String.format(fmt, A[i][j]));
				if (j < W - 1) sb.append(' ');
			}
			sb.append('\n');
		}
		System.out.print(sb);
	}
}
