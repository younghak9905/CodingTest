package samsung;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class back_14499 {
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int[] dice;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[][] map = new int[N][M];
        dice = new int[6];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < K; i++) {
            int dir = Integer.parseInt(st.nextToken());
            int nx = x + dx[dir - 1];
            int ny = y + dy[dir - 1];
            if (nx<0 || nx > M-1 || ny < 0 || ny > N-1) continue;
            x = nx;
            y = ny;
            int tmp = dice[5];
            switch (dir) {
                case 1:
                    dice[5] = dice[2];
                    dice[2] = dice[0];
                    dice[0] = dice[3];
                    dice[3] = tmp;
                    break;
                case 2:
                    dice[5] = dice[3];
                    dice[3] = dice[0];
                    dice[0] = dice[2];
                    dice[2] = tmp;
                    break;
                // 남
                case 4:
                    dice[5] = dice[4];
                    dice[4] = dice[0];
                    dice[0] = dice[1];
                    dice[1] = tmp;
                    break;

                // 북
                default:
                    dice[5] = dice[1];
                    dice[1] = dice[0];
                    dice[0] = dice[4];
                    dice[4] = tmp;
            }
            sb.append(dice[0]).append("\n");

            if (map[ny][nx] == 0) {
                map[ny][nx] = dice[5];
            } else {
                dice[5] = map[ny][nx];
                map[ny][nx] = 0;
            }

        }
        System.out.print(sb);


    }
}
//4 2 0 0 8  N 세로 M 가로 x,y 주사위 좌표 K 명령어 개수
//0 2 //지도에 쓰여있는 숫자
//3 4
//5 6
//7 8
//4 4 4 1 3 3 3 2  //명령어
//동 1 서2 북3 남4
//주사위 전개도
//1-6
//2-5
//3-4
//1 -
//2
//3
//6
//5
//4