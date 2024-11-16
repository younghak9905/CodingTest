package samsung;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class swea_2001 {
    static int N,M,max=0;
    static int [][]map;
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Scanner sc = new Scanner(System.in);
        int T=Integer.parseInt(br.readLine());
		/*
		   여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
		*/
        StringTokenizer st;
        for(int test_case = 1; test_case <= T; test_case++) {
            max =0;
            sb.append("#").append(test_case).append(" ");
            st = new StringTokenizer(br.readLine());
             N = Integer.parseInt(st.nextToken());
             M = Integer.parseInt(st.nextToken());
            map = new int[N][N];
            for(int i=0;i<N;i++)
            {
                st = new StringTokenizer(br.readLine());
                for(int j=0;j<N;j++)
                {
                    map[i][j]= Integer.parseInt(st.nextToken());
                }
            }

            for(int i=0;i<=N-M;i++)
            {

                for(int j=0;j<=N-M;j++)
                {
                    recur(i,j);
                }
            }
            sb.append(max).append("\n");
        }
        System.out.println(sb.toString());


    }
    static void recur(int x,int y )
    {   int result=0;
        for(int i=x;i<x+M;i++)
        {
            for(int j=y;j<y+M;j++)
            {
                result+=map[i][j];
            }
        }
        if(max<result)
        {
            max = result;
        }
    }
}

//10
//5 2
//1 3 3 6 7
//8 13 9 12 8
//4 16 11 12 6
//2 4 1 23 2
//9 13 4 7 3
//6 3
//29 21 26 9 5 8
//21 19 8 0 21 19
//9 24 2 11 4 24
//19 29 1 0 21 19
//10 29 6 18 4 3
//29 11 15 3 3 29
