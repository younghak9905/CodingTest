import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class back_24460 {
    static int[][] board;
    static int cnt =0;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        board = new int[N][N];
        StringTokenizer st;
        for(int i=0;i<N;i++)
        {
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++)
            {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        System.out.println( divide(0,0,N));
    }
    static int divide(int r,int c, int N)
    {
        if(N==1) {
            return board[r][c];
        }else {
            int []seats = new int[]{
                    divide(r,c,N/2),
                    divide(r,c+N/2,N/2),
                    divide(r+N/2,c,N/2),
                    divide(r+N/2,c+N/2,N/2)
            };
            Arrays.sort(seats);
            return seats[1];
        }


    }
}
