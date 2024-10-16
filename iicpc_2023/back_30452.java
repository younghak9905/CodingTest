package iicpc_2023;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class back_30452 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int [][]grid = new int[N][N];

        for(int i=0;i<N;i++)
        {   st= new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++)
            {
                grid[i][j]=Integer.parseInt(br.readLine());
            }
        }




    }
}
